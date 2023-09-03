package com.example.foodi.dto;

import com.example.foodi.model.Address;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private String username;
    private String name;
    private Address address;

}
