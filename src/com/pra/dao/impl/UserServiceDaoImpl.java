package com.pra.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pra.common.CommonFuncs;
import com.pra.dao.UserServiceDao;
import com.pra.pojo.UserInformation;



@Repository("USD")
public class UserServiceDaoImpl implements UserServiceDao {
	
	//@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Resource(name="Commonfuncs")
	private CommonFuncs Commonfuncs;

	
	public CommonFuncs getCommonfuncs() {
		return Commonfuncs;
	}



	public void setCommonfuncs(CommonFuncs commonfuncs) {
		Commonfuncs = commonfuncs;
	}



	@Override
	public List<UserInformation> validloginuser(String username, String password) {
	
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("username", username);
		params.put("password", password);
		
		
		List<UserInformation> resultdata = sqlSessionTemplate.selectList("usermapers.finduser",params);
		return resultdata;
		
		// TODO Auto-generated method stub
		
	}



	@Override
	public int addregister(UserInformation user) {
		// TODO Auto-generated method stub
		int resultdata=0;
		try{
		 resultdata = sqlSessionTemplate.insert("usermapers.addregister", user);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Commonfuncs.logger.error("DAO - Register Error",ex);
		}
		
		return resultdata;
	}

}
