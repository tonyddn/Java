package com.pra.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pra.common.CommonFuncs;
import com.pra.common.CommonFuncs.Status;
import com.pra.pojo.UserInformation;
import com.pra.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class RegisterController {
	@Resource(name="userservice")
	private UserService userservice;
	
	

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	@Resource(name="Commonfuncs")
	private CommonFuncs Commonfuncs;

	public CommonFuncs getCommonfuncs() {
		return Commonfuncs;
	}

	public void setCommonfuncs(CommonFuncs commonfuncs) {
		Commonfuncs = commonfuncs;
	}

	@RequestMapping(value="register",method = RequestMethod.GET)
    public String register()
	   {
		   
	        return "register";
	   }

	@ResponseBody
	@RequestMapping(value="addregister",method = RequestMethod.POST)
    public JSONObject addregister(UserInformation user)
	{
	   int resultdata=0;
		try
		{
		 resultdata = userservice.addregister(user);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Commonfuncs.logger.error("Controller - Register Error",ex);
		}
		
		 if(resultdata>0)
		 {
			 Commonfuncs.setMsg("Register Success!");
			   Commonfuncs.setUrl("login");
			   Commonfuncs.setStatus(Status.OK);
			   Commonfuncs.logger.info("Register Success!");
			 
		 }
		 else
		 {
			 Commonfuncs.setMsg("Register failed!");
			//   Commonfuncs.setUrl("login");
			   Commonfuncs.setStatus(Status.Failed);
		 }
		 
		 JSONObject entityJson = JSONObject.fromObject(Commonfuncs); 
		 return entityJson;
		}
		
		
		


}
