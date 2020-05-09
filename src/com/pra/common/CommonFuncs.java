package com.pra.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("Commonfuncs")
public class CommonFuncs {
	public static final Logger logger = LogManager.getLogger();
	
	private String Msg;
     public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	private String Url;
     public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	private Status status;

	  
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private String statusname;
	
	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public void printtest(String txt){
		
		System.out.println(txt);
	}
	
	public enum Status
	{
	   OK("1"),Failed("2");
	   
		public final String statusname; 
	    
		private Status(String statusname) { 
	            this.statusname = statusname; 
	     } 
	
		public String getstatusname() { 
	        return statusname; 
	     } 
	}

	
}

 
