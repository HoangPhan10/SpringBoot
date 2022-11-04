package com.example.SpringMVC.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private  String name;

    @Column(name = "password")
    private String password;

    @Column(name = "username",unique = true)
    private  String username;

    @ElementCollection
    @JoinTable(name ="user_role",joinColumns = @JoinColumn(name="id"))
    @Column(name = "role")
    private List<String> roles;

}


