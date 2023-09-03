package com.example.foodi.dto;

import com.example.foodi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    @Mapping(source = "address",target = "address")
    @Mapping(source = "username",target = "username")
    @Mapping(source = "name",target = "name")
    UserDto mapToUserDto(User user);

//    User mapToUser(UserDto userDto);

}
