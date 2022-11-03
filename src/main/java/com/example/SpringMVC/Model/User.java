package com.example.SpringMVC.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int age;
    private String address;
}
