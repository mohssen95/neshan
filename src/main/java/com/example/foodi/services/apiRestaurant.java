package com.example.foodi.services;

import com.example.foodi.db.daoRestaurant;
import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class apiRestaurant {

    private daoRestaurant daoRestaurant;
    public apiRestaurant(daoRestaurant daoRestaurant){
        this.daoRestaurant = daoRestaurant;
    }

    @GetMapping(path = "/restaurants")
    public List<Restaurant> getAllResturant(){
        return this.daoRestaurant.getAll();
    }


    @GetMapping(path = "/restaurants/{id}")
    public List<Food> getMenu(@PathVariable int id){
        System.out.println("in here");

        return this.daoRestaurant.getMenus(id);
    }


}
