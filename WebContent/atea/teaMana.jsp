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
		function stuDel(stuId)
		{
			if(confirm('确定删除吗？'))
			{
				window.location.href="/JFSystem/StuServlet?method=delStudentById&num=1&stuId="+stuId;
			}
		}
		
		function stuAdd()
		{
			var url="/JFSystem/atea/addStudent.jsp";
			window.location.href=url;
		}
	</script>
</head>
<body leftmargin="2" topmargin="2"  background="/JFSystem/images/allbg.gif">
	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center">
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="4%">序号</td>
			<td width="10%">编号</td>
			<td width="10%">姓名</td>
			<td width="10%">性别</td>
			
			<td width="10%">年龄</td>
			<td width="10%">密码</td>
			<td width="10%">操作</td>
		</tr>
		
		<c:forEach items="${page.list}" var="stu" varStatus="status">
		<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onclick="">
			<td align="center" bgcolor="#FFFFFF">
				${status.index+1 }
			</td>
			<td align="center" bgcolor="#FFFFFF">
				${stu.stuNum }
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${stu.stuRealname}
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${stu.stuSex}
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${stu.stuAge}
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${stu.loginPw}
			</td>			
			<td align="center" bgcolor="#FFFFFF">
					<a href="#" onclick="stuDel(${stu.stuId})"  class="pn-loperator">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<%@ include file="/jsp/pageFile.jsp" %>
	
	<table width="98%" border="0" style="margin-top: 8px;margin-right: 8px;">
		<tr>
			<td>
				<input type="button" value="添加学生" style="width: 80px" onclick="stuAdd()"/>
			</td>
		</tr>
	</table>
</body>
</html>