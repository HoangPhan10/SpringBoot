package com.example.SpringMVC.Implement;

import com.example.SpringMVC.Dto.CustomerDTO;
import com.example.SpringMVC.Entity.Customer;
import com.example.SpringMVC.Entity.Order;
import com.example.SpringMVC.Repository.CustomerRepository;
import com.example.SpringMVC.Request.CustomerInput;
import com.example.SpringMVC.Response.ResponseData;
import com.example.SpringMVC.Service.CustomerService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CustomerImplement implements CustomerService {
    public static final Logger logger = LoggerFactory.getLogger(CustomerDTO.class);

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseData getListCustomer() {
        List<CustomerDTO> customerDTOS = new ArrayList<CustomerDTO>();
        customerRepository.findAll().forEach(cus -> {
            if(!cus.getDeleted()){
                customerDTOS.add(modelMapper.map(cus, CustomerDTO.class));
            }
        });
        return new ResponseData("data",200,customerDTOS);
    }

    @Override
    public ResponseData getCustomer(Long id) {
        Customer customer = customerRepository.findByCustomerId(id);
        if(customer!=null){
            CustomerDTO customerDTO = modelMapper.map(customerRepository.findByCustomerId(id),CustomerDTO.class);
            return new ResponseData("data",200,customerDTO);
        }
        return new ResponseData("Error",400,"Not found id = "+id);
    }

    @Override
    public ResponseData createCustomer( CustomerInput customerInput) {
        Customer customer = modelMapper.map(customerInput,Customer.class);
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        customer.setCDate(ft.format(date));
        customer.setDeleted(false);
        customerRepository.save(customer);
        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
        return new ResponseData("Insert data success",201,customerDTO);
    }

    @Override
    public ResponseData updateCustomer(CustomerInput customerInput, Long id) {
        Customer customer = customerRepository.findByCustomerId(id);
        if(customer!=null){
            if(customerInput.getEmail()!=null){
                customer.setEmail(customerInput.getEmail());
            }
            if(customerInput.getPassword()!=null){
                customer.setPassword(customerInput.getPassword());
            }
            if(customerInput.getPhone()!=null){
                customer.setPhone(customerInput.getPhone());
            }
            if (customerInput.getRole()!=null){
                customer.setRole(customerInput.getRole());
            }
            if(customerInput.getUsername()!=null){
                customer.setUsername(customerInput.getUsername());
            }
            customerRepository.save(customer);
            CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
            return new ResponseData("Update data success",202,customerDTO);
        }
        return new ResponseData("Error",400,"Not found id = "+id);
    }

    @Override
    public ResponseData deleteCustomer(Long id) {
        Customer customer = customerRepository.findByCustomerId(id);
        if(customer!=null){
            customer.setDeleted(true);
            customerRepository.save(customer);
            return new ResponseData("Delete data success",202,1);
        }
        return new ResponseData("Error",400,"Not found id = "+id);
    }
}
