package Bean;
/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月2日 下午12:11:16 
* @version 1.0 
* @parameter  对文档进行查询的条件类
* @since  
* @return  
*/
public class DocSearchBean {
	
	private String d_type;//文档类型
	private String d_name;//文档名称包含字段
	private String d_user;//文档上传用户
	private String d_date1;//文档上传日期区间较早时间
	private String d_date2;//文档上传日期区间较晚时间
	private String d_point;//文档下载所需点数
	
	
	
	public DocSearchBean() {
		super();
	}

	
	
	



	public String getD_type() {
		return d_type;
	}

	public void setD_type(String d_type) {
		this.d_type = d_type;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getD_user() {
		return d_user;
	}

	public void setD_user(String d_user) {
		this.d_user = d_user;
	}

	public String getD_date1() {
		return d_date1;
	}

	public void setD_date1(String d_date1) {
		this.d_date1 = d_date1;
	}

	public String getD_date2() {
		return d_date2;
	}

	public void setD_date2(String d_date2) {
		this.d_date2 = d_date2;
	}

	public String getD_point() {
		return d_point;
	}

	public void setD_point(String d_point) {
		this.d_point = d_point;
	}
	
	
}
