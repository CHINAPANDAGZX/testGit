package Dao;

import java.util.List;

import Bean.User;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月3日 下午4:54:09 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public interface IUserDao {
	//查询所有用户信息
	public List<User> findAllUser();
	//启用或禁用用户
	public int updateUserEnable(User user);
	
}
