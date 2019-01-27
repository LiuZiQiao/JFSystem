<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
    <script src="${pageContext.request.contextPath }/js/menu.js"></script>
    
    <style type="text/css">
    	body{
    		margin-left: 0px;
    		margin-top: 0px;
    		margin-right: 0px;
			margin-bottom: 0px;
    	}
    	.STYLE1{color:#FFFFFF}
    	.STYLE2{
    			color:#03515d;
    			font-size:12px;
    	}
    	
    	a:link{font-size:12px;text-decoration: none;color:#000000;}
    	a:visited{font-size:12px;text-decoration: none;color:#000000;}
    	a:hover{font-size:12px;text-decoration: none;color:#FF0000;}
    	a.v1:link{font-size:12px;text-decoration: none;color:#03515d;}
    	a.v1:visited{font-size:12px;text-decoration: none;color:#03515d;}
    </style>
</head>
<body>
	<table width="156" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center" valign="top">
				<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="33" background="${pageContext.request.contextPath }/images/main_29.gif"></td>
					</tr>
					<tr>
						<td height="30" background="${pageContext.request.contextPath }/images/main_30.gif">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td width="13%">&nbsp;</td>
									<td width="72" height="20">
										<div align="center">
											<table width="100%" height="21" border="0" cellpadding="0" cellspacing="0"> 
												<tr>
													<td><div align="center"><img  src="${pageContext.request.contextPath }/images/main_30.gif"></div></td>
													<td valign="middle">
														<div align="center"  class="STYLE1" style="font-family:微软雅黑  font-size:12"  ></div>
 													</td>
												</tr>
											</table>
										</div>
									</td>
									<td width="15%">&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr id="show1" style="display:none">
						<td align="center" valign="top">
							<table border="0" align="center" cellpadding="5" cellspacing="5">
								<tr>
									<td><a href="${pageContext.request.contextPath }/admin/userinfo/userPeople"></a>
											<img  src="${pageContext.request.contextPath }/images/arr3.gif" border="">
								</tr>
							</table>
						</td>
					</tr>
					
					<tr>
						<td height="30" background="${pageContext.request.contextPath }/images/main_20.gif">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td width="13%" >&nbsp;</td>
									<td width="72%" height="20" >
										<div align="center">
											<table width="100%" height="21" border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td><div align="center"><img  src="${pageContext.request.contextPath }/images/top_8.gif" id="td2" onClick=""></div></td>
													<td valign="middle">
														<div align="center"  class="STYLE1" style="font-family:微软雅黑  "  >老师信息管理</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
									<td width="15%">&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
					
					<tr id="show2" style="display:none">
						<td align="center" valign="top">
							<table border="0" align="center" cellpadding="5" cellspacing="5">
								<tr>
									<td><a href="${pageContext.request.contextPath }/TeacherServlet?method=findTeacherWithPage&num=1" target="12" style="margin-left:20px;">
											<img  src="${pageContext.request.contextPath }/images/arr3.gif" border="0">&nbsp;&nbsp;老师信息管理</a>
									</td>
								</tr>
								<tr>
									<td><a href="${pageContext.request.contextPath }/admin/tea/teaAdd.jsp" target="12" style="margin-left:20px;">
											<img  src="${pageContext.request.contextPath }/images/arr3.gif" border="0">&nbsp;&nbsp;添加老师信息</a></td>
								</tr>
							</table>
						</td>
					</tr>
					
				</table>
			</td>
		</tr>
	</table>
</body>
</html>