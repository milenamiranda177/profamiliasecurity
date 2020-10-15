package com.mvcprime.restfull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvcprime.domain.Role;
import com.mvcprime.domain.UserMaster;
import com.mvcprime.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserMasterRest {
	@Autowired
    private UserService service;
	
	@RequestMapping
    public List<UserMaster> getUsers() {
        return service.getUsers();
    }
	
	@RequestMapping("/roles")
    public List<Role> getRoles() {
        return service.getRoles();
    }
}
