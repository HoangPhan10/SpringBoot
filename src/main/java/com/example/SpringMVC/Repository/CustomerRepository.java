package com.example.SpringMVC.Repository;

import com.example.SpringMVC.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByCustomerId(Long Id);
}
