<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $("#btn").click(function(){

	  var params = $("#form1").serialize();
	  
	//  var username = $("#username").val();
	//  var passowrd = $("#password").val();
	  
	//  alert (username);
	  // 开始ajax调用  
	  $.ajax({
          //请求方式
          type: "POST",
          //请求的媒体类型
      //    contentType: "application/json;charset=UTF-8",
      //如果传递非json数据，要把application/json删除,不然controller接收不到数据
          //请求地址
          url: "validuserlogin",
          //数据，json字符串
          data: params,
          //请求成功
          success:function(result) {
             // console.log(result);
             alert(result.msg);
          },
          //请求失败，包含具体的错误信息
          error : function(e){
              console.log(e.status);
              console.log(e.responseText);
          }
      });

	  
	  
	//  alert('abc');
  });
});
</script>
</head>
<body>
登陆
<br>
<form name="form1" id="form1">
<table>
<tr>
<td>
UserName
</td>
<td>
<input type="text" name="username" id="username">
</td>
</tr>
<tr>
<td>
Password
</td>
<td>
<input type="password" name="password" id="password">
</td>
</tr>
<tr>
<td>
<input type="button" name="btn"  id="btn"value="Enter">
</td>
</tr>
<tr>
<td>
<a href="register">Register</a>
</td>
</tr>
</table>
</form>
</body>
</html>