package com.example.foodi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orderInf_table")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    long orderItemId;

    @OneToOne(cascade = CascadeType.ALL)
    private Food foodItem;

    @Column(name = "number")
    private int numItem;

    @Column(name = "description",length = 335)
    private String userDescription;
}
