package com.mvcprime.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mvcprime.domain.Role;
import com.mvcprime.domain.UserMaster;
import com.mvcprime.domain.UserRole;

@Repository(value = "userDao")
public class JPAUserDao implements UserDao {

    private EntityManager em = null;
    
    private List<UserRole> listRoles;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @SuppressWarnings("unchecked")
    public List<UserMaster> getUserList() {
        return em.createQuery("select u from UserMaster u order by u.id").getResultList();
    }

    @Transactional
    public void saveUser(UserMaster prod) {
        em.merge(prod);
    }

	@Override
	public User verifyLogin(String login) {
		 List<UserMaster> listUser = em.createQuery("SELECT u FROM UserMaster u where u.login = :login")
                .setParameter("login", login).getResultList();
		 if (!listUser.isEmpty()) {
			 listRoles = listUser.get(0).getAuthorities();
			 return new User(listUser.get(0).getLogin(), listUser.get(0).getPassword(), getAuthorities());
		 }
		return null;
	}
	
	public List<Role> getRoles(){
		List<Role> roles = new ArrayList<Role>();
		for(Role role : Role.values()) {
    		roles.add(role);
    	}
		return roles;
	}
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
    	
    	for(UserRole userrole : listRoles) {
    		list.add(new SimpleGrantedAuthority(userrole.getAuthority()));
    	}

        return list;
    }
    
    

	

}
