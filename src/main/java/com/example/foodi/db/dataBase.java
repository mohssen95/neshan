package com.example.foodi.db;


import com.example.foodi.model.Food;
import com.example.foodi.model.Order;
import com.example.foodi.model.Restaurant;
import com.example.foodi.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dataBase {

    public static List<Order> orders=new ArrayList<>();
    private static int countResturant=0;
    public static ArrayList<Restaurant> resturants=new ArrayList<>();
    private static ArrayList<Food>menu1=new ArrayList<>();
    private static ArrayList<Food>menu2=new ArrayList<>();
    private static ArrayList<Food>menu3=new ArrayList<>();
    static {


        menu1.add(new Food(10,"قرمه سبزی",85000));
        menu1.add(new Food(11,"قیمه نثار",105000));
        menu1.add(new Food(12,"دیزی",150000));
        menu1.add(new Food(13,"دوغ کوچک",12000));

        menu2.add(new Food(10,"پیتزا",220000));
        menu2.add(new Food(11,"برگر ذغالی",95000));

        menu3.add(new Food(10,"کوبیده",110000));
        menu3.add(new Food(11,"نوشابه",30000));
        menu3.add(new Food(12,"نان",2000));
        menu3.add(new Food(13,"قارچ",60000));
        menu3.add(new Food(14,"سالاد",110000));
        menu3.add(new Food(15,"دلستر",30000));


        resturants.add(new Restaurant(++countResturant,"abdi",menu1));
        resturants.add(new Restaurant(++countResturant,"maman joon",menu2));
        resturants.add(new Restaurant(++countResturant,"darbari",menu3));
    }
    static ArrayList<User> users=new ArrayList<>();

    static {

        users.add(new User(2,"mohsen","mashhad-imamreza24-p14"));
        users.add(new User(3,"amir","mashhad-vakilAbad20-p16"));
        users.add(new User(4,"sajjad","rasht-mirzakoochak2-p84"));
        users.add(new User(5,"mohsen","mashhad-imamreza24-p14"));

    }

    static {
        orders.add(new Order(100,2,2, Arrays.asList(10,11,15)));
        orders.add(new Order(101,4,1, Arrays.asList(10)));
        orders.add(new Order(102,5,2, Arrays.asList(10,13)));

    }


}
