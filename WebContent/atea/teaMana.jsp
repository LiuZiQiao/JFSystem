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
	<script type="text/javascript">
		function teaDel(teaId)
		{
			if(confirm('确定删除吗？'))
			{
				window.location.href="/JFSystem/TeacherServlet?method=delTeacherById="+teaId;
			}
		}
		
		function teaAdd()
		{
			var url="/JFSystem/TeacherServlet?method=addTeacher";
			window.location.href=url;
		}
	</script>
</head>
<body leftmargin="2" topmargin="2" back background="/JFSystem/images/allbg.gif">
	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="17"background="/JFSystem/images/tbg.gif">&nbsp;&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="4%">序号</td>
			<td width="10%">编号</td>
			<td width="10%">姓名</td>
			<td width="10%">性别</td>
			
			<td width="10%">年龄</td>
			<td width="10%">账号</td>
			<td width="10%">密码</td>
			<td width="10%">操作</td>
		</tr>
		
		<c:forEach items="${page.list}" var="tea" varStatus="status">
		<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onclick="">
			<td align="center" bgcolor="#FFFFFF">
				${status.index+1 }
			</td>
			<td align="center" bgcolor="#FFFFFF">
				${tea.teaNum }
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${tea.teaRealName}
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${tea.teaSex}
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${tea.teaAge}
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${tea.loginName}
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${tea.loginPwd}
			</td>			
			<td align="center" bgcolor="#FFFFFF">
					<a href="#" onclick="teaDel(${tea.teaId})"  class="pn-loperator">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<%@ include file="/jsp/pageFile.jsp" %>
	
	<table width="98%" border="0" style="margin-top: 8px;margin-right: 8px;">
		<tr>
			<td>
				<input type="button" value="添加教师" style="width: 80px"; onclick="teaAdd()"/>
			</td>
		</tr>
	</table>
</body>
</html>