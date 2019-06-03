<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request .contextPath}/js/jquery-2.1.0.min.js"></script>
     <script type="text/javascript" src="${pageContext.request .contextPath}/js/jQuery.js"></script>
     <script type=text/css>
     		body{TEXT-ALIGN:center;padding-bottom:0px;
		     		background-color:#ddeef2;margin:0px;
		     		padding-left;0px;padding-right:0px;padding-top:0px}

     </script>
<title>Insert title here</title>
</head>
<body>
	<div style="margin:0px auto; width:936px;margin-top:180px;font-family:微软雅黑; font-size:33px;">
	<%--	<img src="${pageContext.request.contextPath }/img/dianxin.jpg"  style="margin:0px auto; width:936px;margin-top:180px"/> --%>
		教学辅助管理系统
	</div>
 	<div style="background-color:#278296;margin-top:20px;"> 
		<div style="margin:0px auto;width:936px">
			<div style="background:url(/${pageContext.request.contextPath }/img/dianxin.jpg) no- ">
				<div style="text-align:left;width:360px;float:right;height;200px;_height:95px; ">
					<form action="#" id="fm" name="ThisForm" method="post">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td style="height:18px"><span id="msg" style="color:red;font-size:15px">${msg}</span></td>
							</tr>
							<tr>
								<td style="height: 30px">
									<span style="font-family:微软雅黑;font-size:13px;">账号：</span>
									<input type="text" id="userName" name="userName" style="width: 110px"/>
								</td>
							</tr>
							<tr>
								<td style="height: 30px">
									<span style="font-family:微软雅黑;font-size:13px;">密码：</span>
									<input type="password" id="userPw"  name="userPw" style="width: 110px"/>
								</td>
							</tr>
							<tr>
								<td style="height: 50px">
									<span style="font-family:微软雅黑;font-size:13px;"> 类型</span>
									<select class="INPUT_text" name="userType" style="height: 20px;width: 55px">
										<option value="0">老师</option>
										<option value="1">管理员</option>
									</select>
									<input type="button"  value="登录" style="width: 80px;" onclick="check()"/>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function check(){
	var username=$("#userName").val();
	var password=$("#userPw").val();
	var um=$.trim(username);
	var up=$.trim(password);
	
	
	if(null == um||um =="")
	{
		alert("请输入账号");
		return false;
	}
	
	if(null==up||""==up){
		alert("请输入密码");
		return false;
		}
	
	if(document.ThisForm.userType.value=="1"){
		document.getElementById("fm").action="${pageContext.request.contextPath}/AdminServlet?method=adminLogin";
	}else if(document.ThisForm.userType.value=="0"){
		document.getElementById("fm").action="${pageContext.request.contextPath}/TeacherServlet?method=teaLogin";
	}
		document.getElementById("fm").submit();
}
</script>
</html>