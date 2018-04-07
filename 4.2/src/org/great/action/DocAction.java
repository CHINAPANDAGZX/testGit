package org.great.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import MyUnitl.MyDateUnitl;
import MyUnitl.MyDocUnitl;
import MyUnitl.MyEmpUnitl;
import Bean.DocSearchBean;
import Bean.Document;
/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月31日 下午10:14:46 
* @version 1.0 
* @parameter  用于处理所有文档操作的动作类
* @since  
* @return  
*/
public class DocAction extends BaseAction{
	private Document doc;
	private String resultList;//查询结果列表
	private DocSearchBean dsb;//查询条件类
	private String test;
	/**
	 * 
	 */
	// ---------------条件查询文档变量----------------------//
	private String doc_name;
	private String doc_type;
	private String doc_date1;
	private String doc_point;
	// ---------------条件查询文档变量----------------------//
	
	// ---------------上传头像部分变量----------------------//
	private File myfileone; // 自己写的单个头像文件
	private String myfileoneFileName;// 自己写的单个头像文件名称

	private List<File> myfile; // 对应页面的file控件的name
	private List<String> myfileFileName; // 对应上传的文件名，命名方式：myfile(对应页面上的file控件的name)+FileName（固定）
	private List<String> myfileContentType;// 对应上传的文件类型，命名方式：myfile(对应页面上的file控件的name)+ContentType（固定）
	// ----------------------------------------------------//
	// ---------------spring反向控制生成类部分开始----------------------//
	private String s = "applicationContext.xml";
	// ---------------spring反向控制生成类部分结束----------------------//
	private MyDateUnitl myDu = new MyDateUnitl();
	
	// 上传文档总操作函数
	public String upLoadDo() {
		String f = "error";//先行设置结果参数
		ApplicationContext conf = new ClassPathXmlApplicationContext(s);
		//----------------打印提交上来的上传信息开始------------------------//
		System.out.println("下载点数");
		System.out.println(doc.getD_dlpoint());
		System.out.println("文件名称");
		System.out.println(doc.getD_name());
		System.out.println("文件描述");
		System.out.println(doc.getD_description());
		System.out.println("上传用户ID");
		System.out.println(doc.getD_up_userid());
		//上传用户ID
		
		//----------------打印提交上来的上传信息结束------------------------//
		//----------------后台补充的上传信息开始----------------------------//
		//上传文件名
		//上传文件类型
		//上传地址
		//以上三个将到上传文件函数中填写
		//上传时间,以当前服务器时间为准
		doc.setD_date(myDu.getNowDate());
		//下载次数先行设置为0
		doc.setD_dlfrequency(0);
		//----------------后台补充的上传信息结束----------------------------//
		// 上传文件部分操作开始
		try {
			upFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 上传文件部分操作结束
//		boolean flag = false;
		MyDocUnitl mdu = conf.getBean("myDocUnitl", MyDocUnitl.class);
		((AbstractApplicationContext) conf).close();//Destroy 
//		MyDocUnitl mdu = new MyDocUnitl();
		boolean flag = mdu.addDoc(doc);

		if (flag) {
			f = "success2";
		} else {
			f = "error";
		}
		return f;
	}
	
	//文档查询函数
//	public List<Document> findDoc(){
	public String findDoc(){
		System.out.println("操作类文档查询函数启动");
		List<Document> list = null;
//		MyDocUnitl mdu = new MyDocUnitl();
		ApplicationContext conf = new ClassPathXmlApplicationContext(s);
		MyDocUnitl mdu = conf.getBean("myDocUnitl", MyDocUnitl.class);
		((AbstractApplicationContext) conf).close();//Destroy 
		list = mdu.findDoc(dsb);
		Gson gson = new Gson();
		resultList = gson.toJson(list);
//		return list;
		return "success";
	}
	
	// 上传文档部分操作函数
	public void upFile() throws IOException {
		InputStream is = new FileInputStream(this.getMyfileone()); // 构建输入流
		String root = ServletActionContext.getRequest().getRealPath("/upload"); // 设置文件上传的路径
		// 声明文件目录image，如果文件名不存在就建一个呗～
		File file = new File(root);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 将上传上来的文件名进行更改，格式为用户名+原文件名后缀
		String oldFileName = this.getMyfileoneFileName();
		String newFileType = this.getMyfileoneFileName().split("\\.")[1];
		System.out.println("上传的文件名称：" + oldFileName);
		doc.setD_name(oldFileName);
		System.out.println("上传的文件类型：" + newFileType);
		doc.setD_type(newFileType);
//		String newFileName = user.getUser_name() + "." + newFileType;
//		System.out.println("新的文件名称为：" + newFileName);
		// 将新的文件名添加到user类中
//		user.setUser_avatarURL("upload/" + newFileName);
		// System.out.println(root);
		File destFile = new File(root, oldFileName);// 构建文件
		doc.setD_avatarurl("upload/" + oldFileName);
		// root:上传路径，this.getMyfileFileName():上传后生成的文件名
		System.out.println(this.getMyfileFileName() + "\r\n" + destFile);
		OutputStream os = new FileOutputStream(destFile); // 构建输出流

		byte[] buffer = new byte[400]; // 以下为读写文件操作

		int length = 0;

		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();

	}
		
	
	
	public File getMyfileone() {
		return myfileone;
	}
	public void setMyfileone(File myfileone) {
		this.myfileone = myfileone;
	}
	public String getMyfileoneFileName() {
		return myfileoneFileName;
	}
	public void setMyfileoneFileName(String myfileoneFileName) {
		this.myfileoneFileName = myfileoneFileName;
	}
	public List<File> getMyfile() {
		return myfile;
	}
	public void setMyfile(List<File> myfile) {
		this.myfile = myfile;
	}
	public List<String> getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(List<String> myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public List<String> getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(List<String> myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String getResultList() {
		return resultList;
	}

	public void setResultList(String resultList) {
		this.resultList = resultList;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getDoc_type() {
		return doc_type;
	}

	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}

	public String getDoc_date1() {
		return doc_date1;
	}

	public void setDoc_date1(String doc_date1) {
		this.doc_date1 = doc_date1;
	}

	public String getDoc_point() {
		return doc_point;
	}

	public void setDoc_point(String doc_point) {
		this.doc_point = doc_point;
	}

	public DocSearchBean getDsb() {
		return dsb;
	}

	public void setDsb(DocSearchBean dsb) {
		this.dsb = dsb;
	}

	
	
	
}
