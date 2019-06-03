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
		function vedioDel(vedioId)
		{
			if(confirm('确定删除吗？'))
			{
				window.location.href="/JFSystem/VedioServlet?method=delVedioById&num=1&vedioId="+vedioId;
			}
		}
		
		function vedioAdd()
		{
			var url="/JFSystem/atea/uploadVedio.jsp";
			window.location.href=url;
		}
	</script>
</head>
<body leftmargin="2" topmargin="2"  background="/JFSystem/images/allbg.gif">
	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="17"background="/JFSystem/images/tbg.gif">&nbsp;&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="8%">序号</td>
			<td width="20%">名称</td>
			<td width="20%">详情</td>
			<td width="20%">原名</td>
			
			
			<td width="10%">上传时间</td>
		</tr>
		
		<c:forEach items="${page.list}" var="vedio" varStatus="status">
		<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onclick="">
			<td align="center" bgcolor="#FFFFFF">
				${status.index+1 }
			</td>
			<td align="center" bgcolor="#FFFFFF">
				${vedio.vedioName }
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${vedio.vedioPro}
			</td>
			<td align="center" bgcolor="#FFFFFF">
			${vedio.vedioAttachment}
			</td>
			
			<td align="center" bgcolor="#FFFFFF">
			${vedio.uploadTime}
			</td>			
			<td align="center" bgcolor="#FFFFFF">
					<a href="#" onclick="vedioDel(${vedio.vedioId})"  class="pn-loperator">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<%@ include file="/jsp/pageFile.jsp" %>
	
	<table width="98%" border="0" style="margin-top: 8px;margin-right: 8px;">
		<tr>
			<td>
				<input type="button" value="上传视频" style="width: 80px" onclick="vedioAdd()"/>
			</td>
		</tr>
	</table>
</body>
</html>