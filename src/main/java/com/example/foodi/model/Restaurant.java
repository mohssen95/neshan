package com.example.foodi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resId;
    @Column(name = "res_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    private Set<Food> menu = new HashSet<>();
    @Column(name = "res_ownerId")
    private long ownerId;

    @OneToOne
    @JoinColumn(name = "res_address")
    private Address address;

}
