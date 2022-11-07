package com.example.SpringMVC.Dto;

import com.example.SpringMVC.Entity.Order;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class CustomerDTO {
    private String username;

    private String email;

    private String phone;

    private String password;

    private String role;
}
