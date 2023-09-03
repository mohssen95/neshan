package com.example.foodi.model;

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
@Getter
@Setter
@Table(name = "restaurant_table")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurant_id;
    @Column(name = "res_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    private List<Food> menu=new ArrayList<>();
    @Column(name = "res_ownerId",unique = true)
    private long ownerId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "res_address")

    private Address address;




}
