package com.mvcprime.repository;

import java.util.List;

import com.mvcprime.domain.Role;
import com.mvcprime.domain.UserMaster;

import org.springframework.security.core.userdetails.User;

public interface UserDao {

    public List<UserMaster> getUserList();

    public void saveUser(UserMaster user);
    
    public User verifyLogin(String login);
    
    public List<Role> getRoles();

}