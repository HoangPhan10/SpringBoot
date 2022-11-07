package com.example.SpringMVC.Service;

import com.example.SpringMVC.Dto.CustomerDTO;
import com.example.SpringMVC.Entity.Customer;
import com.example.SpringMVC.Request.CustomerInput;
import com.example.SpringMVC.Response.ResponseData;

import java.util.List;

public interface CustomerService {
    ResponseData getListCustomer();
    ResponseData getCustomer(Long id);
    ResponseData createCustomer(CustomerInput customerInput);
    ResponseData updateCustomer(CustomerInput customerInput,Long id);
    ResponseData deleteCustomer(Long id);
}
