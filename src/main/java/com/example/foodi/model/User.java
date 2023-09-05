package com.example.foodi.model;


import com.example.foodi.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_owner")
//    private Set<Address> address;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "address")
    private String address;

}