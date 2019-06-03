<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
     <link rel="stylesheet" href="${pageContext.request .contextPath}/css/qiantai.css" type="text/css" charset="UTF-8"/>
    <script type="text/javascript" src="${pageContext.request .contextPath}/js/jQuery.js"></script>
    <script type="text/javascript" src="${pageContext.request .contextPath}/js/jquery-2.1.0.min.js"></script>

</head>
<body leftmargin="2" topmargin="2" background="/JFSystem/images/allbg.gif">
<form action="${pageContext.request.contextPath}/TeacherServlet?method=addTeacher&num=1" method="POST" id="fm">
	<table width="98%" border="0" cellpadding="2" cellspacing="1"  align="center">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="17"background="/JFSystem/images/tbg.gif">&nbsp;&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			
			<td >编号</td>
			<td >姓名</td>
			<td >性别</td>
			<td >年龄</td>
			<td >账号</td>
			<td>密码</td>
			
		</tr>
		<tr bgcolor="#FAFAF1" align="center">
			<td><input type="text" name="teaNum" id="teaNum"></td>
			<td><input type="text" name="teaRealName" id="teaRealName"></td>
			<td><input type="text" name="teaSex" id="teaSex"></td>
			<td><input type="text" name="teaAge" id="teaAge"></td>
			<td><input type="text" name="loginName" id="loginName"></td>
			<td><input type="text" name="loginPwd" id="loginPwd"></td>
		</tr>
		<tr>
			<td><input type="button" value="提交"  onclick="teaAdd()" style="margin-right:30px; width:80px; hight:40px;"/>
			</td>
		</tr>
	</table>
	<br>
	
</form>
	<script type="text/javascript">
		function teaAdd()
		{
			var teaNum = document.getElementById("teaNum").value;
		    var teaRealName = document.getElementById("teaRealName").value;
		    var teaSex = document.getElementById("teaSex").value;
		    var teaAge = document.getElementById("teaAge").value;
		    var loginName = document.getElementById("loginName").value;
		    var loginPwd = document.getElementById("loginPwd").value;
		    
		    var u1 = $.trim(teaNum);
		    var u2 = $.trim(teaRealName);
		    var u3 = $.trim(teaSex);
		    var u4 = $.trim(teaAge);
		    var u5 = $.trim(loginName);
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
		    else if(null == u5 || "" == u5)
		    {
		            alert("请输入账号");
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