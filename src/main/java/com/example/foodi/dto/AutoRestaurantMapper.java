package com.example.foodi.dto;

import com.example.foodi.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AutoRestaurantMapper {
    AutoRestaurantMapper MAPPER = Mappers.getMapper(AutoRestaurantMapper.class);

    @Mapping(source = "address",target = "address")
    @Mapping(source = "menu",target = "menu")
    @Mapping(source = "name",target = "name")
    RestaurantDto mapToRestaurantDto(Restaurant restaurant);
}
