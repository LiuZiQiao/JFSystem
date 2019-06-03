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
<body leftmargin="2" topmargin="2">
<form action="${pageContext.request.contextPath}/VedioServlet?method=uploadVedio&num=1"  method="post" id="fm"  enctype="multipart/form-data">
	<table width="500px" border="0" cellpadding="2" cellspacing="1"  align="center">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="17"background="/JFSystem/images/tbg.gif">&nbsp;&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td>视频名称</td>
			<td><input type="text" name="vedioName" id="vedioName"/></td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td>视频详情</td>
			<td><input type="text" name="vedioPro" id="vedioPro"/></td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td>视频标签</td>
			<td><input type="text" name="attachmentOldName" id="attachmentOldName"/></td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td>选择文件</td>
			<td><input type="file" name="fileSelect" id="fileSelect"/></td>
		</tr>
		<tr >
			<td><input type="button" name="btn" value="上传" onclick="vedioAdd()"/></td>
		</tr>
		
	</table>
</form>
	<script type="text/javascript">
		function vedioAdd()
		{
			var vedioName = document.getElementById("vedioName").value;
		    var vedioPro = document.getElementById("vedioPro").value;
		    var oldName = document.getElementById("attachmentOldName").value;
		    var fileSelect = document.getElementById("fileSelect").value;
		  
		    var u1 = $.trim(vedioName);
		    var u2 = $.trim(vedioPro);
		    var u3 = $.trim(oldName);
		    if(null == u1 || "" == u1)
		    {
		            alert("请输入视频名称");
		            return false;
		    }else if(null == u2 || "" == u2){
		            alert("请输入视频详情");
		            return false;
		    }
		    else if(null == u3 || "" == u3)
		    {
		            alert("请输入视频标签");
		            return false;
		    }
		    else if(null == fileSelect || fileSelect == "")
		    {
		            alert("请选择文件");
		            return false;
		    } 
		    document.getElementById("fm").submit(); 
		}
	</script>
</body>
</html>