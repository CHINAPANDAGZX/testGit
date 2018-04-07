package MyUnitl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static String conf = "SqlMapConfig.xml";
	private static Reader reader =null;
	private static SqlSessionFactory  ssf=null;
	//加载xml 
	
	static{
		try {
			reader = 	Resources.getResourceAsReader(conf);
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			 ssf = 	sfb.build(reader);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//得到连接
	public static SqlSession getSession(){
		
		return  ssf.openSession();
		
	}
	
	//
	
	public static void closeSession(SqlSession session){
		if(null != session){
			session.close();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		 System.out.println(MybatisUtil.getSession());

	}

}
