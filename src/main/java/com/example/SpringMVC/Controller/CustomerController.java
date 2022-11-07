package com.example.SpringMVC.Controller;

import com.example.SpringMVC.Dto.CustomerDTO;
import com.example.SpringMVC.Entity.Customer;
import com.example.SpringMVC.Request.CustomerInput;
import com.example.SpringMVC.Response.ResponseData;
import com.example.SpringMVC.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public static final Logger logger = LoggerFactory.getLogger(CustomerDTO.class);
    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public ResponseData getAllCustomer(){
        ResponseData responseData =customerService.getListCustomer();
      return responseData;
    }

    @GetMapping("/get")
    public ResponseData getCustomerById(@RequestParam(name="id") Long id){
        ResponseData responseData =customerService.getCustomer(id);
        return responseData;
    }
    @PostMapping("/create")
    public ResponseData insertCustomer(@Valid @RequestBody CustomerInput customerInput){
        ResponseData responseData= customerService.createCustomer(customerInput);
        return responseData;
    }
    @PutMapping("/update")
    public ResponseData updateCustomer(CustomerInput customerInput,@RequestParam(name="id") Long id){
        ResponseData responseData = customerService.updateCustomer(customerInput,id);
        return responseData;
    }

    @GetMapping("/delete")
    public ResponseData deleteCustomer(Long id){
       ResponseData responseData = customerService.deleteCustomer(id);
        return responseData;
    }

}
