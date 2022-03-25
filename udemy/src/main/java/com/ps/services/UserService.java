package com.ps.services;

import java.util.List;

import com.ps.domain.User;
import com.ps.repository.UserRepository;
import com.ps.repository.UserRepositoryImpl;

public class UserService {
    public User CreateUser(User user){
        UserRepository userRepository=new UserRepositoryImpl();
        return userRepository.create(user);
    }
    public List<User> listUsers(){
        UserRepository userRepository=new UserRepositoryImpl();
        return userRepository.getUsers();   
    }
}
