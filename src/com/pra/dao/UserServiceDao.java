package com.pra.dao;

import java.util.List;

import com.pra.pojo.UserInformation;

public interface UserServiceDao {
	List<UserInformation> validloginuser(String username,String password);
	int addregister(UserInformation user);
}
