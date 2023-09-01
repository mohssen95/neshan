package com.example.foodi.service.impl;

import com.example.foodi.repo.RestaurantRepository;
import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;
import com.example.foodi.service.RestaurantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Optional<Restaurant> getReataurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Food> getMenu(Long id) {
        return (List<Food>) restaurantRepository.findById(id).get().getMenu();
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }


}
