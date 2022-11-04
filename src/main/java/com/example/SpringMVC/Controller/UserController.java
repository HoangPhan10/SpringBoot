package com.example.SpringMVC.Controller;

import com.example.SpringMVC.Dto.UserDTO;
import com.example.SpringMVC.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        userService.insertUser(userDTO);
        return userDTO;
    }

    @PutMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return userDTO;
    }

    @PutMapping("/update/password")
    public UserDTO updatePassword(@RequestBody UserDTO userDTO){
        userService.updatePassword(userDTO);
        return userDTO;
    }

    @GetMapping("/get")
    public List<UserDTO> getListUser(){
        return userService.getALl();
    }

    @GetMapping("/get/id")
    public UserDTO getUserById(@RequestParam(name="id") Long id){
        return Optional.of(new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK))
                .orElse(new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND)).getBody();
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam(name="id") Long id){
        userService.deleteUser(id);
    }



}
