package com.example.foodi.service;

import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    Optional<Restaurant> getReataurant(Long id);
    List<Food> getMenu(Long id);
    List<Restaurant>getAll();
}
