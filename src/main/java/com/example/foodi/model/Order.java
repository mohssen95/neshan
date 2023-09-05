package com.example.foodi.model;

import com.example.foodi.model.enums.OrderState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "order_table")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long order_id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "restaurant_id")
    private long restaurantId;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    private List<OrderInfo>orderItems=new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private OrderState state;
    private float rate;

}
