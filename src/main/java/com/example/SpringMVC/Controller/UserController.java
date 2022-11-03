package com.example.SpringMVC.Controller;

import com.example.SpringMVC.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private List<User> listUser = new ArrayList<User>();

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        listUser.add(user);
        return user;
    }

    @GetMapping("/list/get")
    public List<User> getListUser(){
        return listUser;
    }

    @GetMapping("/id/get")
    public User getUserById(@RequestParam(name="id") int id){
        for(int i=0;i<listUser.size();i++){
            if(listUser.get(i).getId()==id){
            return listUser.get(i);
            }
        }
        return null;
    }
}
