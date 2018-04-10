package MyUnitl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.great.aoplog.Log;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import Bean.Admin;
import Bean.Emp;
import Bean.User;
import Dao.IDocDao;
import Dao.IEmpDao;
import Dao.IUserDao;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月29日 下午20:48:33 
* @version 1.0 
* @parameter  操作用户表的方法集合类
* @since  
* @return  
*/
@Service
//@Controller
@Component("myEmpUnitl")
public class MyEmpUnitl {
	
	// 管理员登录部分
	@Log(operationType = "登录操作", operationName = "管理员登录")
	public Admin loginAdmin(String userName, String password) {
		System.out.println("进入管理员用户名和密码验证函数");
		Admin admin = null;
		if (userName.equals("tologin")) {
			return admin;
		} else {
			SqlSession sessoin = MybatisUtil.getSession();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", userName);
			map.put("psw", password);
			System.out.println(map);
			admin = sessoin.selectOne("findAdmin", map);
			System.out.println(admin);
			System.out.println(admin.getA_name());
		}
		System.out.println(admin);
		return admin;
	}
	//员工登录部分
	public User loginEmp(String userName, String password) {
		System.out.println("进入用户用户名和密码验证函数");
		User user = null;
		if(userName.equals("tologin")){
			return user;
		}else{
			SqlSession sessoin = MybatisUtil.getSession();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", userName);
			map.put("psw", password);
			user = sessoin.selectOne("findUser", map);
		}
		return user;
	}

	// 员工注册部分
	public boolean addEmp(User user){
		boolean flag = false;
		
		SqlSession session = MybatisUtil.getSession();
		IEmpDao dao = session.getMapper(IEmpDao.class);
		
		Integer rows=dao.registerUser(user);
		if(rows==1){
			flag = true;
		}
		session.commit();
		return flag;
	}
	
	//注册时检测用户名是否存在部分
	@Test
	public static boolean checkEmpNameExist(String emp_Name){
		boolean flag = false;
		User user = null;
//		flag = empDao.empNameExist(emp_Name);
		SqlSession sessoin = MybatisUtil.getSession();
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("name", emp_Name);
		user = sessoin.selectOne("findUserByName", emp_Name);
		if(user!=null){
			flag = true;
		}
		return flag;
	}
	
	// 拉取用户详细信息部分
	@Test
	public static User getUserInfo(String emp_Name) {
		User user = null;
		SqlSession sessoin = MybatisUtil.getSession();
		user = sessoin.selectOne("findUserByName", emp_Name);
		return user;
	}
	
	//根据条件从用户表中拉取所有符合条件的用户
	@Test
	public List<User> getAllUser(){
		List<User> resultList = null;
		SqlSession session = MybatisUtil.getSession();
		IUserDao dao = session.getMapper(IUserDao.class);
		resultList = dao.findAllUser();
		for(User u : resultList){
			System.out.println(u.getUser_name());
		}
		return resultList;
	}
	
	//更新用户状态
	@Test
	public int enableUser(User user){
		SqlSession session = MybatisUtil.getSession();
		IUserDao dao = session.getMapper(IUserDao.class);
		int r = dao.updateUserEnable(user);
		session.commit();
		return r;
	}
	
}
