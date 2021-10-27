package com.little.service.Impl;

import com.little.entity.Refrigerator;
import com.little.entity.User;
import com.little.interfaces.UserSqlTable;
import com.little.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserSqlTable userDatabase;
    @Override
    public List<User> getUser(){
        List<User> users= userDatabase.getUser();
        return users;
    }
}
