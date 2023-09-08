package com.example.foodi.service;

import com.example.foodi.dto.RestaurantDto;
import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    Optional<RestaurantDto> getReataurant(Long id);
    List<Food> getMenu(Long id);
    List<RestaurantDto> getAll();


    boolean removeRestaurant(long rid, long oid);

    List<String> findMostCheapRestaurant();
    Restaurant updatePriceFood(long rid, int fid, long pric);

    Restaurant addFood(long id, Food f);
    List<?> getTopResByNumOfOrder();
}
