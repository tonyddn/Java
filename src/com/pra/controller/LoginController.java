package com.pra.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {
	
	
	
	//@Autowired(required = false)
	@Resource(name="userservice")
	private UserService userservice;
	
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	//@Autowired(required = false)
	@Resource(name="Commonfuncs")
	private CommonFuncs Commonfuncs;
	

	

	

	public CommonFuncs getCommonfuncs() {
		return Commonfuncs;
	}

	public void setCommonfuncs(CommonFuncs commonfuncs) {
		Commonfuncs = commonfuncs;
	}

	

	@RequestMapping(value="login",method = RequestMethod.GET)
       public String login()
	   {
		   
	        return "login";
	   }
	
	@RequestMapping(value="test",method = RequestMethod.GET)
    public String test()
	   {
		   
	        return "test";
	   }
	   
	@ResponseBody
	@RequestMapping(value="validuserlogin",method = RequestMethod.POST)
	  public JSONObject validuserlogin(String username,String password)
	  {
	  
	      
	 List<UserInformation> resultdata =  userservice.validloginuser(username, password);
	
	 if(resultdata == null)
	 {
		 Commonfuncs.setMsg("Username not exists or Password is error.");
		   Commonfuncs.setUrl("");
		   Commonfuncs.setStatus(Status.Failed);
		   
		  Commonfuncs.setStatusname(Status.Failed.statusname); 
		 
	 }
	 else
	 {
		 
		 Commonfuncs.setMsg(resultdata.get(0).getRealname());
		   Commonfuncs.setUrl("main");
		   Commonfuncs.setStatus(Status.OK);
		   
		  Commonfuncs.setStatusname(Status.OK.statusname); 
	 }
	
	   JSONObject entityJson = JSONObject.fromObject(Commonfuncs);
	 
//	   CommonFuncs.logger.info("print log!");
	 
      return entityJson;
	  }

	  @ResponseBody
	   @RequestMapping(value="/testmsg",method = RequestMethod.POST)
      public JSONObject testmsg(){
		   
		   Commonfuncs.setMsg("abc");
		   Commonfuncs.setUrl("bcd");
		   Commonfuncs.setStatus(Status.OK);
		   
		  Commonfuncs.setStatusname(Status.OK.statusname); 
		   JSONObject entityJson = JSONObject.fromObject(Commonfuncs);
			  
			 
		   return entityJson;
	   }

}
