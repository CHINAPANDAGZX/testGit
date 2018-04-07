package org.great.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Bean.Customer;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月25日 上午9:08:10 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class CityAction {
	
//	private List<City> cities;//所有城市
	private Customer customer;
	private String Sproperty;
	private Map<String,String> map = new HashMap<String,String>();
	
	public String execute(){
//		CityDao cityDao = new CityDAO();
//		cities = cityDao.findAllCities();
		
		List<String> travelCities = new ArrayList<String>();
		travelCities.add("shanghai");
		travelCities.add("diaoyudao");
		
		customer = new Customer(travelCities,"show object property");
		Sproperty = "show s : property";
		
		map.put("shanghai", "上海");
		map.put("beijing", "北京");
		
		return "success";
	}
	
	public String getSproperty() {
		return Sproperty;
	}

	public void setSproperty(String sproperty) {
		Sproperty = sproperty;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
