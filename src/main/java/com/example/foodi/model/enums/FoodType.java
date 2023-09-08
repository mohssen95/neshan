package com.example.foodi.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodType {

    FAST_FOOD("فست غود"),
    KEBAB("کباب"),
    TRADITIONAL("سنتی"),
    BERGER("کباب"),
    IRANIAN("ایرانی"),
    SEA("دریایی"),
    SIDE_DISHED("دورچین"),
    DRINK("نوشیدنی");
    private final String persianName;

}
