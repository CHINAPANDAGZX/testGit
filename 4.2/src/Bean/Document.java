package Bean;
/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月1日 下午6:27:47 
* @version 1.0 
* @parameter  文档表类
* @since  
* @return  
*/
public class Document {
	private Integer d_id;
	private String 	d_name;
	private String  d_type;
	private String  d_avatarurl;
	private String  d_date;
	private Integer d_up_userid;
	private String  d_description;
	private Integer d_dlpoint;
	private Integer d_dlfrequency;
	
	private User user;//用于存放查询结果的用户名称
	
	public Document() {
		super();
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_type() {
		return d_type;
	}
	public void setD_type(String d_type) {
		this.d_type = d_type;
	}
	public String getD_avatarurl() {
		return d_avatarurl;
	}
	public void setD_avatarurl(String d_avatarurl) {
		this.d_avatarurl = d_avatarurl;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	public Integer getD_up_userid() {
		return d_up_userid;
	}
	public void setD_up_userid(Integer d_up_userid) {
		this.d_up_userid = d_up_userid;
	}
	public String getD_description() {
		return d_description;
	}
	public void setD_description(String d_description) {
		this.d_description = d_description;
	}
	public Integer getD_dlpoint() {
		return d_dlpoint;
	}
	public void setD_dlpoint(Integer d_dlpoint) {
		this.d_dlpoint = d_dlpoint;
	}
	public Integer getD_dlfrequency() {
		return d_dlfrequency;
	}
	public void setD_dlfrequency(Integer d_dlfrequency) {
		this.d_dlfrequency = d_dlfrequency;
	}
	
	
}
