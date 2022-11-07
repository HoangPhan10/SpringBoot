package com.example.SpringMVC.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "OrderDetail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

//    @Column(name="ProductId")
//    private Long productId;

//    @Column(name = "OrderId")
//    private Long orderId;

    @Column(name = "Total")
    private Double total;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "Status")
    private String status;

    @ManyToOne()
    @JoinColumn(name="OrderId")
    private Order order;

    @ManyToOne()
    @JoinColumn(name="ProductId")
    private Product product;

}

