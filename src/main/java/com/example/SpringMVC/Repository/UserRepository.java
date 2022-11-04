package com.example.SpringMVC.Repository;

import com.example.SpringMVC.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
