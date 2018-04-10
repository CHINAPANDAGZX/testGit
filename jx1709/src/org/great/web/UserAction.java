package org.great.web;

import javax.annotation.Resource;

import org.great.dao.UserMapper;
import org.great.entity.User;
import org.great.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {
	private String username;
	private String password;
	private User user;
	
	
	@Resource
	private UserMapper userMapper;
	
	public String login() {
		
		/*System.out.println("login----");
		ApplicationContext conf = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper =  	conf.getBean(UserMapper.class);
		System.out.println(userMapper);*/
		
//		Users user = new Users(username,password);
//		Users nuser = userMapper.login(user);
//		System.out.println(nuser.getLoginname());
		
		User nuser = new User(user.getUser_name(),user.getUser_psw());
		User nuser2 = userMapper.loginUser(nuser);
		System.out.println(nuser2.getUser_name());
		return "success";

	}

	
	
	
	public UserMapper getUserMapper() {
		return userMapper;
	}




	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}




	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
