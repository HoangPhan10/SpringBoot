package com.example.SpringMVC.Service;

import com.example.SpringMVC.Dto.CustomerDTO;
import com.example.SpringMVC.Entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getListCustomer();
    Customer getCustomer(Long id);
    void createCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO,Long id);
    void deleteCustomer(Long id);
}
