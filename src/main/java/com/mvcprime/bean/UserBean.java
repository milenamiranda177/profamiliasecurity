package com.mvcprime.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mvcprime.domain.Role;
import com.mvcprime.domain.UserMaster;
import com.mvcprime.service.IUserService;

@Component
@ViewScoped
public class UserBean {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
    private IUserService userService;

	private List<UserMaster> lista;
	private UserMaster user;
	
	private Role role;
	private List<Role> roles;
	
	@PostConstruct
	public void init() {
		lista = new ArrayList<UserMaster>();
		user = new UserMaster();
		roles = userService.getRoles();
	}
	
	public String oncreate()
    {
		user.addAuthorities(role.getRole());
        userService.createUser(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario Creado!"));
        return "/views/select";
    }

	public List<UserMaster> getLista() {
		lista = userService.getUsers();
		return lista;
	}
	public void setLista(List<UserMaster> lista) {
		this.lista = lista;
	}

	public UserMaster getUser() {
		return user;
	}

	public void setUser(UserMaster user) {
		this.user = user;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
	

	
	
	
	
}
