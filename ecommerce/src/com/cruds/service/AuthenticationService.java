package com.cruds.service;

import com.cruds.db.LoginUserDao;
import com.cruds.entity.User;

public class AuthenticationService {
    private LoginUserDao userDao;

    public AuthenticationService() {
        userDao = new LoginUserDao();
    }

    public boolean authenticateUser(String email, String password) {
        return userDao.validateUser(email, password);
    }
}
