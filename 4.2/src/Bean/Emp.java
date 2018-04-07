package Bean;
/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月16日 下午2:41:35 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class Emp {
	private String emp_id;
	private String emp_name;
	private String emp_psw;
	public Emp() {
		super();
	}
	public Emp(String emp_id, String emp_name, String emp_psw) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_psw = emp_psw;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_psw() {
		return emp_psw;
	}
	public void setEmp_psw(String emp_psw) {
		this.emp_psw = emp_psw;
	}
	
}
