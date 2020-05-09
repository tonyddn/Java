package com.pra.service;

import java.util.List;

import com.pra.pojo.UserInformation;

public interface UserService {

	List<UserInformation> validloginuser(String username,String password);
	int addregister(UserInformation user);
}
