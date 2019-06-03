<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
    <style type="text/css">
    	body{
    		margin-left: 0px;
    		margin-top: 0px;
    		margin-right: 0px;
			margin-bottom: 0px;
    	}
    	.STYLE1(font-size:12px)
    	.STYLE2{
    			color:#03515d;
    			font-size:12px;
    	}
    	.div1{
    	position:relative;
    	text=align:center;
    	
    	
    	font-size:30px;
    	font-wigth:bolder;
    	display:bloder}
    	
    	.div2{
    	position:relative;
    	
    	font-size:18px;
    	margin-top: 27px;
    	}
    	
    	a:link{font-size:12px;text-decoration: none;color:#000000;}
    	a:visited{font-size:12px;text-decoration: none;color:#000000;}
    	a:hover{font-size:12px;text-decoration: none;color:#FF0000;}
    	a.v1:link{font-size:12px;text-decoration: none;color:#03515d;}
    	a.v1:visited{font-size:12px;text-decoration: none;color:#03515d;}
    </style>
    <script type="text/javascript">
    		function logout()
    		{
    			if(confirm("确定要退出吗?"))
    			{
    				window.parent.location="/JFSystem/AdminServlet?method=adminLogout";	
    			}
    		}
    </script>
</head>

<body>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="26" background="/JFSystem/images/main_03.gif">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="227" height="26" background="/JFSystem/images/main_01.gif">&nbsp;</td>
							<td>&nbsp;</td>
							<td width="60">
								<img src="JFSystem/images/main_05.gif" width="60" height="26" />
							</td>
						</tr>
					</table>
				</td>
			</tr>	
			<tr>
				<td height="64">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td  valign="top" height="100" background="/JFSystem/images/main_01.gif">
								<table align="center">
									<tr height="8"><td></td></tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td>
											<div class="div1">
												教学辅助管理系统后台
											</div>
										</td>
						</tr>
								</table>
							 </td>
									</tr>
								</table>
							</td>
							<tr>
							<td  valign="top" height="64" background="red">
								<table align="center">
									<tr height="8"><td></td></tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td>
											<div class="div2">
												<c:if test="${ not empty admin}">
												欢迎您：${admin.userName}管理员
												</c:if>	
												&nbsp;&nbsp;
												<SCRIPT>
													setInterval("clock.innerHTML=new Date().toLocaleString()");
												</SCRIPT>
												<span id=clock></span>&nbsp;&nbsp;&nbsp;
												<a href="#" style="font-size:17px" onclick="logout()">注销</a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						
						</tr>
					</table>
				
	</body>
</body>
</html>