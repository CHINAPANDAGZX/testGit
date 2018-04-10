package org.great.dao;

import org.great.entity.User;
import org.great.entity.Users;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

	public Users login(Users user);
	public User loginUser(User user);
}
