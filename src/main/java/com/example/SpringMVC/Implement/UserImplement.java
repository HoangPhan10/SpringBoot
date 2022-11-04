package com.example.SpringMVC.Implement;

import com.example.SpringMVC.Dto.UserDTO;
import com.example.SpringMVC.Entity.User;
import com.example.SpringMVC.Repository.UserRepository;
import com.example.SpringMVC.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserImplement implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void insertUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
        userDTO.setId(user.getId());
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = userRepository.getById(userDTO.getId());
        if(user!=null){
            modelMapper.typeMap(UserDTO.class,User.class).addMappings(mapper->mapper.skip(User::setPassword)).map(userDTO,user);
            userRepository.save(user);
        }
    }

    @Override
    public void updatePassword(UserDTO userDTO) {
        User user = userRepository.getById(userDTO.getId());
        if(user!=null){
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.getById(id);
        if (user!=null){
            userRepository.delete(user);
        }
    }

    @Override
    public List<UserDTO> getALl() {
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        userRepository.findAll().forEach(user->{
            userDTOS.add(modelMapper.map(user,UserDTO.class));
        });
        return userDTOS;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.getById(id);
        if (user!=null){
            return  modelMapper.map(user,UserDTO.class);
        }
        return null;
    }
}
