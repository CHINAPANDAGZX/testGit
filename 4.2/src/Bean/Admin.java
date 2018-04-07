package Bean;
/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月3日 上午11:01:30 
* @version 1.0 
* @parameter  管理员类
* @since  
* @return  
*/
public class Admin {
	
	private String a_id;//管理员ID
	private String a_name;//管理员名称
	private String a_psw;//管理员密码
	private String a_class;//管理员等级
	
	public Admin() {
		super();
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_psw() {
		return a_psw;
	}

	public void setA_psw(String a_psw) {
		this.a_psw = a_psw;
	}

	public String getA_class() {
		return a_class;
	}

	public void setA_class(String a_class) {
		this.a_class = a_class;
	}
	
	
}
