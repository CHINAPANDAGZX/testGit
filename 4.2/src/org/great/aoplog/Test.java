package org.great.aoplog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	
	public static void main(String[] args){
		 //启动Spring容器        
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext_aoplog.xml");
        //获取service或controller组件
        UserController userController = (UserController) ctx.getBean("userController");
        userController.testAOP("zhangsan", "123456");
	}
}
