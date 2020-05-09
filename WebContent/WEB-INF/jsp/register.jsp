<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
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
          url: "addregister",
          //数据，json字符串
          data: params,
          //请求成功
          success:function(result) {
             // console.log(result);
            if(result.status=='OK')
            	{
             alert(result.msg);
             window.location = result.url;
            	}
            else
            	{
            	 $("#errormessage").html(result.msg);
            	}
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
Register

<form name="form1" id="form1">
<table>
<tr>
<td>
Username
</td>
<td>
<input type="text" name="username" id="username">
</td>
</tr>
<tr>
<td>
password
</td>
<td>
<input type="password" name="password" id="password">
</td>
</tr>
<tr>
<td>
realname
</td>
<td>
<input type="text" name="realname" id="realname">
</td>
</tr>
<tr>
<td>
sex
</td>
<td>
<input type="radio" name="sex"  value="1" checked>Man 
<input type="radio" name="sex"  value="0">Woman
</td>
</tr>
<tr>
<td>
age
</td>
<td>
<input type="text" name="age" id="age"> 
</td>
</tr>
<tr>
<td>
hobby
</td>
<td>
<input type="checkbox" name="hobby" id="hobby" value="Playing Game">Play Game 
<input type="checkbox" name="hobby" id="hobby" value="Listening Music">Listening Music
<input type="checkbox" name="hobby" id="hobby" value="Reading Book">Reading Book
<input type="checkbox" name="hobby" id="hobby" value="Others">Others
</td>
</tr>
<tr>
<td>
email
</td>
<td>
<input type="text" name="email" id="email"> 
</td>
</tr>
<tr>
<td>
position
</td>
<td>
<select name ="position" id="position">
<option value="">Please Select</option>
<option value="Staff">Staff</option>
<option value="Manager">Manager</option>
<option value="Administrator">Administrator</option>
</select>
</td>
</tr>
<tr>
<td>
department
</td>
<td>
<select name="department" id="department">
<option value="">Please Select</option>
<option value="IT">IT</option>
<option value="Purchasing">Purchasing</option>
<option value="HR">HR</option>
</select>
</td>
</tr>
<tr>
<td>
<input type="button" name="btn"  id="btn"value="Register">
</td>
</tr>
<tr>
<td>
 <label id="errormessage"></label>
</td>
</tr>
</table>
</form>
</body>
</html>