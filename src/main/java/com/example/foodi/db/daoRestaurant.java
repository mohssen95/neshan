package com.example.foodi.db;


import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.foodi.db.dataBase.resturants;


@Component
public class daoRestaurant {

    public List<Restaurant> getAll() {
        return resturants;
    }

    public List<Food> getMenus(int restaurantId){
        return resturants.get(restaurantId).getMenu();
    }


}
