package com.example.foodi.dto.impl;

import com.example.foodi.dto.UserDto;
import com.example.foodi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);


    UserDto mapToUserDto(User user);
    User mapToUser(UserDto user);
}
