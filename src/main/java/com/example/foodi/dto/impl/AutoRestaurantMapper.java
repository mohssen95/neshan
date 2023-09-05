package com.example.foodi.dto.impl;

import com.example.foodi.dto.RestaurantDto;
import com.example.foodi.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoRestaurantMapper {
    AutoRestaurantMapper MAPPER = Mappers.getMapper(AutoRestaurantMapper.class);

    RestaurantDto mapToRestaurantDto(Restaurant restaurant);
}
