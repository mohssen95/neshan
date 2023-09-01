package com.example.foodi.api;

import com.example.foodi.model.Restaurant;
import com.example.foodi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class apiRestaurant {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    ResponseEntity<?> getRestaurants(){
        try {
            List<Restaurant> restaurants = restaurantService.getAll();
            return ResponseEntity.ok(restaurants);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }

//    @GetMapping(path = "/restaurants/{id}")
//    public List<Food> getMenu(@PathVariable int id){
//        System.out.println("in here");
//
//        return this.daoRestaurant.getMenus(id);
//    }
//
//    @DeleteMapping(path = "/restaurants/{rid}/owner/{oid}")
//    public boolean removeRestaurant(@PathVariable("rid") int rid,@PathVariable("oid") int oid){
//        System.out.println("in here");
//        return daoRestaurant.removeRestaurant(rid,oid);
//    }
//
//    @PatchMapping(path = "restaurants/{oid}/menu/food/{fid}/price/{pric}")
//    public boolean updatePriceFood(@PathVariable int oid,@PathVariable int fid,@PathVariable int pric){
//     return daoRestaurant.updatePriceFood(oid,fid,pric);
//    }
//
//
//    @PostMapping(path = "/restaurants/{id}/menu/add")
//    public boolean addFood(@PathVariable int id,@RequestBody Food f){
//        return daoRestaurant.addFood(id,f);
//    }
//

}
