package com.example.SpringMVC.Implement;

import com.example.SpringMVC.Dto.CustomerDTO;
import com.example.SpringMVC.Entity.Customer;
import com.example.SpringMVC.Entity.Order;
import com.example.SpringMVC.Repository.CustomerRepository;
import com.example.SpringMVC.Service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Customer> getListCustomer() {
        List<Customer> customer = new ArrayList<Customer>();
        customerRepository.findAll().forEach(cus -> {
            if(!cus.getDeleted()){
                customer.add(cus);
            }
        });
        return customer;
    }

    @Override
    public Customer getCustomer(Long id) {
        return null;
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-mm-dd");
        customer.setCDate(ft.format(date));
        customer.setDeleted(false);
        customerRepository.save(customer);
    }


    @Override
    public void updateCustomer(CustomerDTO customerDTO,Long id) {
        Customer customer = customerRepository.getById(id);
        if(customer!=null){
            modelMapper.typeMap(CustomerDTO.class,Customer.class).addMappings(mapper->mapper.skip(Customer::setPassword))
                    .map(customerDTO,customer);
             customerRepository.save(customer);
        }
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
