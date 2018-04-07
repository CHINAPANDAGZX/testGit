package MyUnitl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import Bean.DocSearchBean;
import Bean.Document;
import Bean.User;
import Dao.IDocDao;
import Dao.IEmpDao;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月1日 下午6:26:00 
* @version 1.0 
* @parameter  操作文档表的集合类
* @since  
* @return  
*/
@Component("myDocUnitl")
public class MyDocUnitl {
	// 上传文档向表中添加记录部分
	public boolean addDoc(Document doc) {
		boolean flag = false;

		SqlSession session = MybatisUtil.getSession();
//		IEmpDao dao = session.getMapper(IEmpDao.class);
		IDocDao dao = session.getMapper(IDocDao.class);
		Integer rows = dao.addDoc(doc);
		if (rows == 1) {
			flag = true;
		}
		session.commit();
		return flag;
	}
	//查询文档部分
	
	public List<Document> findDoc(DocSearchBean dsb){
		System.out.println("进入工具类条件搜索文档函数");
		//----------------对输入进行判断开始---------------------//
		if(dsb.getD_point().equals("")){
			dsb.setD_point(null);
		}
		if(dsb.getD_type().equals("")){
			dsb.setD_type(null);
		}
		if(dsb.getD_name().equals("")){
			dsb.setD_name(null);
		}
		if(dsb.getD_name()!=null){
			String str = dsb.getD_name();
			//为防止出错，提前将模糊搜索的% %提前加上
			dsb.setD_name("%" + str + "%");
			
		}
		if(dsb.getD_date1().equals("")){
			dsb.setD_date1(null);
		}
//		if(dsb.getD_date2().equals("")){
//			dsb.setD_date2(null);
//		}
		System.out.println("要搜索的包含文件名："+dsb.getD_name());
		System.out.println("要搜索的第一日期："+dsb.getD_date1());
		System.out.println("要搜索的第二日期："+dsb.getD_date2());
		//----------------对输入进行判断结束---------------------//
		List<Document> list = null;
		SqlSession session = MybatisUtil.getSession();
		IDocDao dao = session.getMapper(IDocDao.class);
//		HashMap<String,String> map = new HashMap<String,String>();
		//map中有几个参数：1、type：代表文档类型;2、name：文件名包含字段;3、user：上传用户;4、date1：前日期
		//5、date2：后日期;6、point：下载所需点数
//		System.out.println(doc_point);
//		map.put("point", doc_point);
//		System.out.println(map);
		list = dao.findDocument(dsb);
		System.out.println("文档搜索结果数："+list.size());
//		for(Document doc : list){
//			System.out.println("-----");
//			System.out.println(doc.getD_id());
////			System.out.println(doc.getD_up_userid());
////			User user = doc.getUser();
////			System.out.println(user.getUser_name());
//		}
		
		return list;
	}

	// 查询所有文档
	public List<Document> findAllDoc() {
		System.out.println("进入全部搜索文档函数");
		List<Document> list = null;
		SqlSession session = MybatisUtil.getSession();
		IDocDao dao = session.getMapper(IDocDao.class);
		list = dao.findAllDocument();
		for (Document doc : list) {
			System.out.println(doc.getD_id());
		}
		return list;
	}
	
}
