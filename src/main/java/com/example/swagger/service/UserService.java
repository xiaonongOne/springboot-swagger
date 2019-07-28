package com.example.swagger.service;


import com.example.swagger.bean.User;

public interface UserService {
    int deleteById(Long id);

    int createUser(User user);

    User selectById(Long id);

    int modifyUser(User user);

}
