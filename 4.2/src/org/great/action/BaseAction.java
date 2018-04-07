package org.great.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月21日 下午3:40:12 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class BaseAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Map<String,Object> session;//方法三的部分
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		System.out.println("基础类实现标记");
		session = arg0;
	}

}
