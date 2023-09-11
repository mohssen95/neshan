package com.example.foodi.dto;

import com.example.foodi.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class RestaurantDto  {

    private String name;
    private List<FoodDto> menu=new ArrayList<>();
    private String address;

    public RestaurantDto(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.address = restaurant.getAddress();
    }
}
