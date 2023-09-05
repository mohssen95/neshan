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
    @Column(name = "restaurant_id")
    private long restaurant_id;
    @Column(name = "name")
    private String name;

    @Column(name = "rate")
    private float rate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private List<Food> menu=new ArrayList<>();

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner",unique = true,nullable = false)
    private User ownerUser;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_owner",unique = true)
//    private Set<Address> address;
    @Column(name = "address")
    private String address;


}
