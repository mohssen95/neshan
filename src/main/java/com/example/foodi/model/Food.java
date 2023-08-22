package com.example.foodi.model;

public class Food {
    private int foodId;
    private String foodName;

    private long price;


    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Food(int foodId, String foodName, long price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
    }
}
