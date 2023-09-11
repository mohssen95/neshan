package com.example.foodi.dto;

import com.example.foodi.model.enums.ERole;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private String username;
    private String password;
    private String name;
    private String address;
    private ERole role;
    private String email;


}
