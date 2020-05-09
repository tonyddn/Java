package com.pra.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pra.dao.UserServiceDao;
import com.pra.pojo.UserInformation;
import com.pra.service.UserService;


@Service("userservice")
public class UserServiceImpl implements UserService {

	//@Autowired(required = false)
	@Resource(name="USD")
	private UserServiceDao USD;
	
	
	public UserServiceDao getUSD() {
		return USD;
	}

	public void setUSD(UserServiceDao uSD) {
		USD = uSD;
	}

	@Override
	public List<UserInformation> validloginuser(String username, String password) {
		
		
	List<UserInformation> resultdata =USD.validloginuser(username, password);
		return resultdata;
	}
	
	@Override
	public int addregister(UserInformation user) {
		// TODO Auto-generated method stub
		
		int resultdata = USD.addregister(user);
		return resultdata;
	}
	
	

}
