package MyUnitl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Bean.Emp;

public class TestDept {

	@Test
	public void testAddDept(){
		
		SqlSession sessoin = MybatisUtil.getSession();
		
		Emp emp = new Emp("4", "kkk", "654321");
		
		sessoin.insert("addDept", emp);
		sessoin.commit();
		
		
	}
	
	@Test
	public void testloginEmp(){
		
		SqlSession sessoin = MybatisUtil.getSession();
		
		String name = "aaa";
		String psw = "123456";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("did", name);
		map.put("did2", psw);
		
		Emp emp = sessoin.selectOne("findUser", map);
		sessoin.commit();
		
		System.out.println(emp.getEmp_name());
		
		
		
	}
	
	@Test
	public void testDelDept(){
		
		SqlSession sessoin = MybatisUtil.getSession();
		
//		Dept dept = new Dept(201, "www", "sss");
//		
//		
//		//String did = "40212";
//		
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("did", "201");
//		map.put("did2", "20");
//		
//		
//		
//		sessoin.delete("deleteById",map);
//		sessoin.commit();
		
		
	}
	
	
}
