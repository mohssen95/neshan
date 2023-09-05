package com.example.foodi.model;

import com.example.foodi.model.enums.FoodType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foodId")
    private long foodId;

    @Column(name = "Name",length = 40)
    private String foodName;

    @Column(name = "Price")
    private long price;

    @Column(name = "Type")
    @Enumerated(EnumType.STRING)
    private FoodType type;

    @Column(name = "description",length = 300)
    private String description;
    @Column(name = "rate")
    private float foodRate;
}
