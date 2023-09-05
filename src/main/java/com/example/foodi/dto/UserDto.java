package com.example.foodi.dto;

import com.example.foodi.model.enums.Role;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private String username;
    private String password;
    private String name;
    private String address;
    private Role role;


}
