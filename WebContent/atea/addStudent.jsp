<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
   <link rel="stylesheet" href="${pageContext.request .contextPath}/css/qiantai.css" type="text/css" charset="UTF-8"/>
	<script type="text/javascript" src="${pageContext.request .contextPath}/js/jQuery.js"></script>
    <script type="text/javascript" src="${pageContext.request .contextPath}/js/jquery-2.1.0.min.js"></script>
</head>
<body leftmargin="2" topmargin="2" background="/JFSystem/images/allbg.gif">
<form action="${pageContext.request.contextPath}/StuServlet?method=addStudent&num=1" id="fm" method="post" target="">
	<table width="98%" border="0" cellpadding="2" cellspacing="1"  align="center">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="17"background="/JFSystem/images/tbg.gif">&nbsp;&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			
			<td >编号</td>
			<td >姓名</td>
			<td >性别</td>
			<td >年龄</td>
			
			<td>密码</td>
			
		</tr>
		<tr bgcolor="#FAFAF1" align="center">
			<td><input type="text" name="stuNum" id="stuNum"></td>
			<td><input type="text" name="stuRealName" id="stuRealName"></td>
			<td><input type="text" name="stuSex" id="stuSex"></td>
			<td><input type="text" name="stuAge" id="stuAge"></td>
			
			<td><input type="text" name="loginPwd" id="loginPwd"></td>
		</tr>
		<tr>
			<td><input type="button" value="提交" onclick="stuAdd()" style="margin-right:30px; width:80px; hight:40px;" />
			</td>
		</tr>
	</table>
	<br>
	
</form>

<script type="text/javascript">
		function stuAdd()
		{
			var stuNum = document.getElementById("stuNum").value;
		    var stuRealName = document.getElementById("stuRealName").value;
		    var stuSex = document.getElementById("stuSex").value;
		    var stuAge = document.getElementById("stuAge").value;
		   
		    var loginPwd = document.getElementById("loginPwd").value;
		    
		    var u1 = $.trim(stuNum);
		    var u2 = $.trim(stuRealName);
		    var u3 = $.trim(stuSex);
		    var u4 = $.trim(stuAge);
		    
		    var u6 = $.trim(loginPwd);
		    if(null == u1 || "" == u1)
		    {
		            alert("请输入编号");
		            return false;
		    }else if(null == u2 || "" == u2){
		            alert("请输入姓名");
		            return false;
		    }
		    else if(null == u3 || "" == u3)
		    {
		            alert("请输入性别");
		            return false;
		    }
		    else if(null == u4 || "" == u4)
		    {
		            alert("请输入年龄");
		            return false;
		    }
		    
		    else if(null == u6 || "" == u6)
		    {
		            alert("请输入密码");
		            return false;
		    }
		    document.getElementById("fm").submit();
		}
	</script>
</body>
</html>