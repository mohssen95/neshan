package com.example.foodi.repo;

import com.example.foodi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    /*
    select  AVG(food_table.price),food_table.restaurant_id,res_name  from restaurant_table
    left join food_table on food_table.restaurant_id=restaurant_table.restaurant_id
    group by restaurant_table.restaurant_id
    order by AVG(food_table.price ) ASC
    * */



    @Query(value = "select  res_name  from restaurant_table\n" +
            "left join food_table on food_table.restaurant_id=restaurant_table.restaurant_id\n" +
            "group by restaurant_table.restaurant_id\n" +
            "order by AVG(food_table.price ) ASC",nativeQuery = true)
    List<String> findMostCheapRestaurant();


    @Query(value = "select count(restaurant_table.restaurant_id) AS ABC, restaurant_table.restaurant_id, res_name from order_table\n" +
            "    right join restaurant_table\n" +
            "        on order_table.restaurant_id=restaurant_table.restaurant_id\n" +
            "        group by restaurant_table.restaurant_id" +
            "           order by count(restaurant_id) desc",nativeQuery = true)
    List<?> topRestaurantsByNumberOfOrder();


}
