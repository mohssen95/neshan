package com.example.foodi.api;

import com.example.foodi.dto.RestaurantDto;
import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;
import com.example.foodi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiRestaurant {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    ResponseEntity<?> getRestaurants(){
        try {
            List<RestaurantDto> restaurants = restaurantService.getAll();
            return ResponseEntity.ok(restaurants);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }
    @GetMapping("/restaurants/economy")
    ResponseEntity<?> getEcoRestaurants(){
        try {
            List<String> restaurants = restaurantService.findMostCheapRestaurant();
            return ResponseEntity.ok(restaurants);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }

    @GetMapping(path = "/restaurants/{id}")
    ResponseEntity<?> getRestaurant(@PathVariable long id){
        try {
            Optional<Restaurant> restaurant =  restaurantService.getReataurant(id);
            return ResponseEntity.ok(restaurant);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }


    @GetMapping(path = "/restaurants/menu/{id}")
    ResponseEntity<?> getMenu(@PathVariable long id){
        try {
            List<Food> menu=  restaurantService.getMenu(id);
            return ResponseEntity.ok(menu);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }
    @GetMapping(path = "/restaurants/top")
    ResponseEntity<?> getTopRestaurants(){
        try {

            return ResponseEntity.ok(restaurantService.getTopResByNumOfOrder());

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }
    @DeleteMapping(path = "/restaurants/{rid}/owner/{oid}")
    public boolean removeRestaurant(@PathVariable("rid") long rid,@PathVariable("oid") long oid){
        System.out.println("in here");
        return restaurantService.removeRestaurant(rid,oid);
    }

    @PatchMapping(path = "restaurants/{rid}/menu/food/{fid}/price/{pric}")
    public Restaurant updatePriceFood(@PathVariable long rid,@PathVariable int fid,@PathVariable long pric){
        System.out.println("in here");
        return restaurantService.updatePriceFood(rid,fid,pric);
    }


    @PostMapping(path = "/restaurants/{id}/menu/add")
    public Restaurant addFood(@PathVariable long id,@RequestBody Food f){
        return restaurantService.addFood(id,f);
    }



}
