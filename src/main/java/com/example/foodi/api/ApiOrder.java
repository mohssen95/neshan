package com.example.foodi.api;
import com.example.foodi.model.Order;
import com.example.foodi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


@RestController
@RequestMapping("/api/orders")
public class ApiOrder {


    //get all order from specific
    @Autowired
    OrderService orderService;
    @GetMapping("")
    ResponseEntity<?> getOrder(@PathVariable long id) {
        try {
            Optional<Order> order = orderService.getOrder(id);
            return ResponseEntity.ok(order.get());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }



}
