package com.example.SpringMVC.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInput {
    @NotNull(message = "username not null2")
    @Min(value = 3,message = "min user 3")
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String password;
    @NotNull
    private String role;

}
