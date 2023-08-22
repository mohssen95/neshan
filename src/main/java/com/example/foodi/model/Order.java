package com.example.foodi.model;

import java.util.List;

public class Order {
    private int idOrder;
    private int idUser;
    private int idRestaurant;
    private List<Integer> foodIds;

    public Order(int idOrder, int idUser, int idRestaurant, List<Integer> foodIds) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idRestaurant = idRestaurant;
        this.foodIds = foodIds;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public List<Integer> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(List<Integer> foodIds) {
        this.foodIds = foodIds;
    }



}
