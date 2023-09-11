package com.example.foodi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address_table")
public class Address1 {

    @Id
    private Long address_id;
    @Column(name = "city",nullable = false,length = 30)
    private String city;
    @Column(name = "street",length = 255)
    private String street;
    @Column(name = "zipcode")
    private Long zipcode;

}
