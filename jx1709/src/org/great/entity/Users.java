package org.great.entity;

public class Users {

	private String userid;
	private String loginname;
	private String pwd;
	public Users(String userid, String loginname, String pwd) {
		super();
		this.userid = userid;
		this.loginname = loginname;
		this.pwd = pwd;
	}
	public Users(String loginname, String pwd) {
		super();
		this.loginname = loginname;
		this.pwd = pwd;
	}
	public Users() {
		super();
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
