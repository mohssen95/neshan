package com.example.foodi.services;

import com.example.foodi.db.daoUser;
import com.example.foodi.model.Order;
import com.example.foodi.model.Restaurant;
import com.example.foodi.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class apiUser {

    private daoUser daoUser;
    public apiUser(daoUser daoUser){
        this.daoUser = daoUser;}


    @GetMapping(path = "/users")
    public List<User> getUsers(){
        System.out.println("in here");
        return this.daoUser.getUsers();
    }

    @PostMapping(path = "/users")
    public boolean addUser(@RequestBody User user){
        return daoUser.addUser(user);
    }


    /*
    {
        "idOrder": 100,
        "idUser": 2,
        "idRestaurant": 2,
            "foodIds": [
                10,
                11,
                15
                ]
      }
    * */
    @PostMapping(path = "/users/order")
    public boolean orderFood(@RequestBody Order order){
        return daoUser.order(order);
    }
    @PostMapping(path = "/users/signRestaurant")
    public boolean signAsRestaurant(@RequestBody Restaurant restaurant){
        return daoUser.signAsRestaurant(restaurant);

    }







}
