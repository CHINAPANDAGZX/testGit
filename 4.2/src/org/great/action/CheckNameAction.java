package org.great.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Bean.Emp;
import MyUnitl.MyEmpUnitl;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月22日 下午3:37:47 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class CheckNameAction {
	private String ename;
	User user;

	private Map<String,Object> info = new HashMap<String,Object>();
	@Test
	public String check(){
		System.out.println("进入验证函数");
		System.out.println(ename);
		boolean flag = MyEmpUnitl.checkEmpNameExist(ename);
		if(!flag){
			info.put("success", true);
			info.put("message", "当前用户名可以使用");
		}else{
			info.put("success", false);
			info.put("message", "当前用户名已经被使用！");
		}
		System.out.println(info);
		return "success";
	}
	
	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
