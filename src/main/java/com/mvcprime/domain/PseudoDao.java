package com.mvcprime.domain;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.mvcprime.repository.UserDao;

public class PseudoDao implements UserDao {

    private List<UserMaster> userList;

    public PseudoDao(List<UserMaster> userList) {
        this.userList = userList;
    }

    public List<UserMaster> getUserList() {
        return userList;
    }

	@Override
	public void saveUser(UserMaster user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User verifyLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	


}
