package com.example.SpringMVC.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Data
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name ="Username",unique = true)
    private String username;

    @Column(name ="Email",unique = true)
    private String email;

    @Column(name ="Phone",unique = true)
    private String phone;

    @Column(name="Password")
    private String password;

    @Column(name="CDate")
    private String cDate;

    @Column(name="Deleted")
    private Boolean deleted;

    @Column(name="Role")
    private String role;

//    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
//    private Set<Order> orders;
}
