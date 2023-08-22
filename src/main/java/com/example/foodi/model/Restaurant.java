package com.example.foodi.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<Food>menu;

    public Restaurant(int id, String name, ArrayList<Food> menu) {

        this.id = id;
        this.name = name;
        this.menu=menu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getMenu() {

        return menu;
    }

    public void setMenu(List<Food> menu) {
        this.menu = menu;
    }

    public boolean addOrder(List<Integer> foods) {
        //if can do order return true
        return true;
    }
}
