package com.example.SpringMVC.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductId;

   @ManyToOne()
   @JoinColumn(name="CategoryId")
   private Category category;

   @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
   private Set<OrderDetail> orderDetails;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private Double price;

    @Column(name="Material")
    private String material;

    @Column(name = "Image")
    private String image;

    @Column(name="Color")
    private String color;

    @Column(name = "Amount")
    private int amount;
}
