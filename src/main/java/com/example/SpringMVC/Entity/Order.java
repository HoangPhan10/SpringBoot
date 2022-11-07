package com.example.SpringMVC.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="Order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

//    @Column(name ="CustomerId")
//    private Long customerId;

    @Column(name="Amount")
    private Double amount;

    @Column(name="Total")
    private int total;

    @ManyToOne()
    @JoinColumn(name="CustomerId")
    private Customer customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;
}
