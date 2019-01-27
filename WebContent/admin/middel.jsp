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
    </style>
    <style >
    	.navPoint{
    	COLOR:white;CURSOR:hand;FONT_FAMILY:Webdings;FONT_SIZE:9pt
    	}
    </style>
    <script >
			function switchSysBar()
			{
				var locate=location.href.replace('/JFSystem/admin/meddel.jsp');
				var ssrc=document.all("img1").src.replace(locate,'');
				if(ssrc=="/JFSystem/img/main_30.gjf")
				{
						document.all("img1").src="/JFSystem/img/main_30_1.gif"	;
						document.all("frmTitle").style.display="none"	
				}
				else
				{
					document.all("img1").src="/JFSystem/img/main_30.gif"	;
					document.all("frmTitle").style.display=""	
				}
			}
	</script>
    
</head>

<body  style="overflow:hidden">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="156" id="frmTitle" noWrap name="fmTitle" align="center">
				<iframe name="11" src="/JFSystem/admin/left.jsp" height="100%" width="156" border=" ">
				浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
				</iframe>
			</td>
			<td width="4" valign="middle" background="/JFSystem/images/">
				<span class="navPoint" id="switchPoint" title="关闭/打开左栏">
				<img  src="/JFSystem/images/main_30.gif" name="img1" width="4" height="47" id="">
				</span>
			</td>
			<td align="center" valign="top">
						<iframe name="12" src="/JFSystem/admin/middel.jsp" height="100%" width="100%" border="0" frameborder="0" >
				浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
				</iframe>
			</td>
		</tr>
	</table>
</body>
</html>