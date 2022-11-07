package com.example.SpringMVC.Controller;

import com.example.SpringMVC.Dto.CustomerDTO;
import com.example.SpringMVC.Entity.Customer;
import com.example.SpringMVC.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public static final Logger logger = LoggerFactory.getLogger(CustomerDTO.class);
    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public List<Customer> getAllCustomer(){
        return customerService.getListCustomer();
    }
    @PostMapping("/create")
    public CustomerDTO insertCustomer(CustomerDTO customerDTO){
        customerService.createCustomer(customerDTO);
        return customerDTO;
    }
    @PutMapping("/update")
    public  CustomerDTO updateCustomer(CustomerDTO customerDTO,@RequestParam(name="id") Long id){
        customerService.updateCustomer(customerDTO,id);
        logger.info(customerDTO.toString());
        return customerDTO;
    }
}
