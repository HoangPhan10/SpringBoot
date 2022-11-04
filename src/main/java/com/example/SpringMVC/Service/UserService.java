package com.example.SpringMVC.Service;

import com.example.SpringMVC.Dto.UserDTO;

import java.util.List;

public interface UserService {
    void insertUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void updatePassword(UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getALl();
    UserDTO getUserById(Long id);
}
