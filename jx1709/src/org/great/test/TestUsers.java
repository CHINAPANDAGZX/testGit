package org.great.test;

import org.great.dao.UserMapper;
import org.great.entity.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUsers {

	@Test
	public void testUserLogin(){
		ApplicationContext conf = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper =  	conf.getBean(UserMapper.class);
		System.out.println(userMapper);
		
		Users user = new Users("AAA","AAA");
		Users nuser = userMapper.login(user);
		System.out.println(nuser.getLoginname());
	
	}
}
