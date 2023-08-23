package com.example.foodi.services;

import com.example.foodi.db.daoRestaurant;
import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path = "/restaurants/{rid}/owner/{oid}")
    public boolean removeRestaurant(@PathVariable("rid") int rid,@PathVariable("oid") int oid){
        System.out.println("in here");
        return daoRestaurant.removeRestaurant(rid,oid);
    }

    @PatchMapping(path = "restaurants/{oid}/menu/food/{fid}/price/{pric}")
    public boolean updatePriceFood(@PathVariable int oid,@PathVariable int fid,@PathVariable int pric){
     return daoRestaurant.updatePriceFood(oid,fid,pric);
    }


    @PostMapping(path = "/restaurants/{id}/menu/add")
    public boolean addFood(@PathVariable int id,@RequestBody Food f){
        return daoRestaurant.addFood(id,f);
    }


}
