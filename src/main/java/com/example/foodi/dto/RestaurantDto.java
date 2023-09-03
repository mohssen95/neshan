package com.example.foodi.dto;

import com.example.foodi.model.Address;
import com.example.foodi.model.Food;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestaurantDto {
    private String name;
    private List<Food> menu=new ArrayList<>();
    private Address address;

}
