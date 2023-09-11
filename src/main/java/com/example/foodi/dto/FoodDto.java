package com.example.foodi.dto;

import com.example.foodi.model.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class FoodDto {


    private String foodName;
    private long price;
    private FoodType type;
    private String description;
    private float foodRate;

}
