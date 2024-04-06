package com.cruds.service;

import com.cruds.db.UserDao;
import com.cruds.entity.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean registerUser(User user) {
        // Add validation logic if needed
        return userDao.registerUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNumber());
    }
}