package com.example.SpringMVC.Dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CustomerDTO {
    private Long customerId;

    private String username;

    private String email;

    private String phone;

    private String password;

    private String role;

    private String cDate;

}
