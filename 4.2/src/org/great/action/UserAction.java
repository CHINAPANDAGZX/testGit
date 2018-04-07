package org.great.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Bean.Document;
import Bean.User;
import MyUnitl.MyDocUnitl;
import MyUnitl.MyEmpUnitl;

public class UserAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String verifyCode;
	private String userImage;
	private User user;
	private String req;// 用于保存页面跳转请求变量
	// ---------------上传头像部分变量----------------------//
	private File myfileone; // 自己写的单个头像文件
	private String myfileoneFileName;// 自己写的单个头像文件名称

	private List<File> myfile; // 对应页面的file控件的name
	private List<String> myfileFileName; // 对应上传的文件名，命名方式：myfile(对应页面上的file控件的name)+FileName（固定）
	private List<String> myfileContentType;// 对应上传的文件类型，命名方式：myfile(对应页面上的file控件的name)+ContentType（固定）
	// ----------------------------------------------------//
	// ---------------spring反向控制生成类部分开始----------------------//
	String s = "applicationContext.xml";
	// ---------------spring反向控制生成类部分结束----------------------//
	// 跳转到首页的函数

	public String pageShift() {
		String str = "home";
		System.out.println("页面跳转函数启动");
		if ((req != null) && (req.length() != 0)) {
			if (req.equals("home")) {
				str = "home";
			} else if (req.equals("login")) {
				str = "login";
			} else if (req.equals("register")) {
				str = "register";
			} else if (req.equals("uploadtest")) {
				str = "uploadtest";
			} else if (req.equals("admin_login")) {
				str = "admin_login";
			} else {
				str = "error";
			}

		} else {
			str = "error";
		}
		return str;
	}

	// 登录部分函数
	public String login() {
		String f = "error";
		String verifyCode2 = (String) session.get("imageCode");
		verifyCode = verifyCode.toUpperCase();
		if (verifyCode2.equals(verifyCode)) {
			ApplicationContext conf = new ClassPathXmlApplicationContext("applicationContext.xml");
			MyEmpUnitl meu = conf.getBean("myEmpUnitl", MyEmpUnitl.class);
//			MyEmpUnitl meu = new MyEmpUnitl();
			User admin = meu.loginEmp(user.getUser_name(), user.getUser_psw());
			
//			User admin = MyEmpUnitl.loginEmp(user.getUser_name(), user.getUser_psw());
			if (admin != null) {
				userImage = admin.getUser_avatarURL();//配置用户头像
				session.put("user", admin);
				f = "success";
				
				
			}
			((AbstractApplicationContext) conf).close();//Destroy 
		}else{
			
			f="error";
		}

		
		return f;
	}

	// 注册部分函数
	public String register() {
		String f = "error";
		// 上传头像部分操作开始
		try {
			upFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 上传头像部分操作结束
		ApplicationContext conf = new ClassPathXmlApplicationContext(s);
		MyEmpUnitl meu = conf.getBean("myEmpUnitl", MyEmpUnitl.class);
		((AbstractApplicationContext) conf).close();//Destroy 
		boolean flag = meu.addEmp(user);
//		boolean flag = MyEmpUnitl.addEmp(user);

		if (flag) {
			f = "login";
		} else {
			f = "error";
		}
		return f;
	}

	// 拉取用户信息函数
	public String myInfo() {
		if ((req != null) && (req.length() != 0)) {
			if (req.equals("myInfo")) {
				System.out.println("获取用户详细信息");
				user = MyEmpUnitl.getUserInfo(user.getUser_name());
			}
		}
		return "success";
	}

	public boolean checkFileUpload() {
		boolean flag = false;
		String path = "G:/lxz/20130611"; // 路径
		File f = new File(path);
		if (!f.exists()) {
			System.out.println("当前用户路径：' " + path + " ' 不存在！");
			return false;
		}
		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (fs.isDirectory()) {
				System.out.println(fs.getName() + " [目录]");
			} else {
				System.out.println(fs.getName());
			}
		}
		return flag;
	}


	// 上传头像部分操作函数
	public void upFile() throws IOException {

		InputStream is = new FileInputStream(this.getMyfileone()); // 构建输入流

		String root = ServletActionContext.getRequest().getRealPath("/upload"); // 设置文件上传的路径
		// 声明文件目录image，如果文件名不存在就建一个呗～
		File file = new File(root);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 将上传上来的文件名进行更改，格式为用户名+原文件名后缀
		String newFileType = this.getMyfileoneFileName().split("\\.")[1];
		System.out.println("上传的文件类型：" + newFileType);
		String newFileName = user.getUser_name() + "." + newFileType;
		System.out.println("新的文件名称为：" + newFileName);
		// 将新的文件名添加到user类中
		user.setUser_avatarURL("upload/" + newFileName);
		// System.out.println(root);
		File destFile = new File(root, newFileName);// 构建文件
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

	// 上传文件队列操作函数
	public void upFile2() throws IOException {
		for (int i = 0; i < this.getMyfile().size(); i++) {

			InputStream is = new FileInputStream(this.getMyfile().get(i)); // 构建输入流

			String root = ServletActionContext.getRequest().getRealPath("/upload"); // 设置文件上传的路径
			// 声明文件目录image，如果文件名不存在就建一个呗～
			File file = new File(root);
			if (!file.exists()) {
				file.mkdirs();
			}
			// 将上传上来的文件名进行更改，格式为用户名+原文件名后缀
			String newFileType = this.getMyfileFileName().get(i).split("\\.")[1];
			System.out.println("上传的文件类型：" + newFileType);
			String newFileName = user.getUser_name() + "." + newFileType;
			System.out.println("新的文件名称为：" + newFileName);
			// System.out.println(root);
			File destFile = new File(root, newFileName);// 构建文件
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
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
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

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

}
