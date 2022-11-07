package com.example.SpringMVC.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseData {
    private String name;
    private int code;
    private Object data;
}



