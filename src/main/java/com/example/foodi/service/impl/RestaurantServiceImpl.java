package com.example.foodi.service.impl;

import com.example.foodi.dto.impl.AutoRestaurantMapper;
import com.example.foodi.dto.RestaurantDto;
import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;
import com.example.foodi.repo.RestaurantRepository;
import com.example.foodi.service.RestaurantService;
import jakarta.transaction.Transactional;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RedissonClient redissonClient;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Optional<RestaurantDto> getReataurant(Long id) {

        RBucket<RestaurantDto> bucket = redissonClient.getBucket("rest-" + id);

        if (bucket.isExists()) {
            return Optional.of(bucket.get());
        }

        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);

        //put to cache server
        restaurantOptional.ifPresent(restaurant -> {
            bucket.set(new RestaurantDto(restaurant));
        });

//        System.out.println(AutoRestaurantMapper.INSTANCE.mapToRestaurantDto(restaurantOptional.get()));
        Optional<RestaurantDto> restaurantDtoOptional = restaurantOptional.map(RestaurantDto::new);

        return restaurantDtoOptional;
    }

    @Override
    public List<Food> getMenu(Long id) {
        List<Food>menu=new ArrayList<>();
        System.out.println(restaurantRepository.getReferenceById(id).getName());
        restaurantRepository.getReferenceById(id).getMenu().forEach(menu::add);
        return menu;
    }
    public Optional<Restaurant> getRestaurant(Long id) {

        return restaurantRepository.findById(id);

    }

    @Override
    public List<RestaurantDto> getAll() {

        List<Restaurant> restaurants=restaurantRepository.findAll();
        return restaurants.stream().map(restaurant -> AutoRestaurantMapper.INSTANCE.mapToRestaurantDto(restaurant))
                .collect(Collectors.toList());
    }


    @Override
    public boolean removeRestaurant(long rid, long oid) {

        if(restaurantRepository.getReferenceById(rid).getOwnerUser().getUserId()==oid) {
            restaurantRepository.delete(restaurantRepository.getReferenceById(rid));
        return true;}
        else return false;
    }

    @Override
    public List<String> findMostCheapRestaurant() {
        return restaurantRepository.findMostCheapRestaurant();
    }


    @Override
    public Restaurant updatePriceFood(long rid, int fid, long pric) {
        Restaurant restaurant=restaurantRepository.getReferenceById(rid);
        restaurant.getMenu().get(fid-1).setPrice(pric);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant addFood(long id, Food food) {
        Restaurant restaurant=restaurantRepository.findById(id).get();
        List<Food>menu=restaurant.getMenu();
        menu.add(food);
        restaurant.setMenu(menu);
        return  restaurantRepository.save(restaurant);
    }

    @Override
    public List<?> getTopResByNumOfOrder() {
        return restaurantRepository.topRestaurantsByNumberOfOrder();
    }


}
