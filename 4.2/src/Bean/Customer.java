package Bean;

import java.util.List;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月25日 上午9:21:19 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class Customer {
	private String cname;
	private List<String> travelCities;//要旅游的城市
	
	public Customer(List<String> travelCities2, String string) {
		// TODO Auto-generated constructor stub
		this.cname = string;
		this.travelCities = travelCities2;
	}

	public String test(){
		return "abc";
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<String> getTravelCities() {
		return travelCities;
	}

	public void setTravelCities(List<String> travelCities) {
		this.travelCities = travelCities;
	}
}
