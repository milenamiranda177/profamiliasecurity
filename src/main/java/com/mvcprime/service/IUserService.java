package com.mvcprime.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.mvcprime.domain.UserMaster;

public interface IUserService extends Serializable {

    public void createUser(UserMaster user);
    public User verifyLogin(String login);
    public List<UserMaster> getUsers();

}
