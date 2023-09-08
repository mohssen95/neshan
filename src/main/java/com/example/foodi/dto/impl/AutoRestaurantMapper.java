package com.example.foodi.dto.impl;

import com.example.foodi.dto.RestaurantDto;
import com.example.foodi.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AutoRestaurantMapper {
    AutoRestaurantMapper INSTANCE = Mappers.getMapper(AutoRestaurantMapper.class);


    RestaurantDto mapToRestaurantDto(Restaurant restaurant);

    List<RestaurantDto> mapToRestaurantDto(List<Restaurant> restaurants);

    RestaurantDto mapToRestaurantDto(Optional<Restaurant> restaurantOptional);
}
