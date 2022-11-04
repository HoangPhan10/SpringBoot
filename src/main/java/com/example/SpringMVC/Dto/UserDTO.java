package com.example.SpringMVC.Dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;

    private  String name;

    private String password;

    private  String username;

    private List<String> roles;
}
