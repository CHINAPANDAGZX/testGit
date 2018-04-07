package Dao;

//import java.util.ArrayList;
import Bean.Emp;
import Bean.User;

public interface IEmpDao {
	//检查用户当前登录状态,返回true表示未登录
//	public boolean checkOnlineState(String emp_ID);
	
	//员工登录函数
	public Emp login(String name, String psw);
	//新增人员
	public boolean addEmp(String emp_ID, String emp_Name, String emp_Psw);
	//检测当前的用户名是否已经被使用
	public boolean empNameExist(String emp_Name);
	
	Integer registerUser(User user);

}
