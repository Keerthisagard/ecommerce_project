package com.cruds.service;

import com.cruds.db.LoginUserDao;

public class LoginService {
    private LoginUserDao userDao;

    public LoginService() {
        userDao = new LoginUserDao();
    }

    public boolean validateUser(String email, String password) {
        return userDao.validateUser(email, password);
    }
}