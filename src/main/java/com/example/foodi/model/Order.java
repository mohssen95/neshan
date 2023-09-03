package com.example.foodi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orderTable")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long order_id;
    private long user_id;
    private long restaurantId;
    private String state;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Food>foodItems=new ArrayList<>();



}
