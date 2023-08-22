package com.example.foodi.db;


import com.example.foodi.model.Order;
import com.example.foodi.model.Restaurant;
import com.example.foodi.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.foodi.db.dataBase.orders;
import static com.example.foodi.db.dataBase.users;


@Component
public class daoUser {



    public boolean addUser(User user){
        users.add(user);
        return users.contains(user);
    }
    public List<User> getUsers(){
        System.out.println(users.size());
        return users.stream().toList();
    };

    public boolean order(Order order) {
        if(dataBase.resturants.get(order.getIdRestaurant()).addOrder(order.getFoodIds()))
        {
            int i= orders.size();
            order.setIdOrder(i+100);
            orders.add(order);
            return true;
        }
        return false;

    }


    public boolean signAsRestaurant(Restaurant restaurant) {
        restaurant.setId(dataBase.resturants.size()+1);
        return dataBase.resturants.add(restaurant);

    }



}
