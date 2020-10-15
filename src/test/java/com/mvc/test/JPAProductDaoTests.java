package com.mvc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvcprime.domain.UserMaster;
import com.mvcprime.domain.UserRole;
import com.mvcprime.repository.UserDao;

public class JPAProductDaoTests {

    private ApplicationContext context;
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        userDao = (UserDao) context.getBean("userDao");
    }

    @Test
    public void testGetProductList() {
        List<UserMaster> products = userDao.getUserList();
        assertNotNull(products);	   
    }

    @Test
    public void testSaveUser() throws NoSuchAlgorithmException {
    	List<UserMaster> user = userDao.getUserList();
    	Integer countBefore = user.size();
    	
        UserMaster p = new UserMaster();
        p.setId(300);
        p.setLogin("PEDRO");
        p.setEnabled(1);
        p.setPassword("12345");
        p.setFullname("PEDRO EL ESCAMOSO");
        
        p.addAuthorities("ROLE_USER");
        
        userDao.saveUser(p);

        user = userDao.getUserList();
        Integer countAfter = user.size();
        assertNotSame(countBefore, countAfter);
    }
}
