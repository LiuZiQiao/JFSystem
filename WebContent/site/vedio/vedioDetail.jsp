<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
      <link rel="stylesheet" href="${pageContext.request .contextPath}/css/qiantai.css" type="text/css" charset="UTF-8"/>
      <script type="text/javascript" src="${pageContext.request .contextPath}/js/jquery-2.1.0.min.js"></script>
     <script type="text/javascript" src="${pageContext.request .contextPath}/js/jQuery.js"></script>
	<style type="text/css">
		.cl-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
	</style>
	<script type="text/javascript" src="${pageContext.request .contextPath}/js/public.js"></script>
	
	<script type="text/javascript">
			function down1(path,oIdName)
			{
				var url="/JFSystem/VedioServlet?method=downloadVedio&vedioAttachment="+path+"&vedioOIdName";
				window.oper(url,"_self");
			}
			
			function vedioBofang(attachMent)
			{
				var url="/JFSystem/bofang/bofang.jsp";
			}
	
	</script>
</head>
<body>
                <div id="right" ">
	                <h2>教学视频 </h2>
			            <div id="welcome">
			                <div>
			                	<div class="c1-body">
			                		<table width="100%" border="0">
			                			<tr>
			                				<td align="center">${vedio.vedioName}<hr/></td>
			                			</tr>
			                			<tr>
			                				<td aligin="center" style="word-break:break-all;">视频介绍
			                				${vedio.vedioPro }
			                				<hr/>
			                				</td>
			                			</tr>
			                			
			                			<tr>
			                				<td aligin="center">
			                					<a href="${pageContext.request.contextPath }/VedioServlet?method=downloadVedio&id=${vedio.vedioId}" style="font-size:13px;  color:red">下载</a>
			                		<%-- 			<a href="${pageContext.request.contextPath }/VedioServlet?method=playVedioById&id=${vedio.vedioId}" class="pn-Loperator" style="color:red">播放</a>
			                			--%>		<a href="${pageContext.request.contextPath }/play/playVedio.html" class="pn-Loperator" style="color:red">播放</a>
			                					<hr/>
			                				</td>
			                			</tr>
			                			
			                			<tr>
			                				<td aligin="center"> 发布时间：${vedio.uploadTime}</td>
			                			</tr>
			                		</table>		
			                	</div>
                            </div>
                        <!--     <p class="more"><a href="/JFSystem/site/vedio/vedioAll.jsp">more</a></p>  -->
		                </div>
                </div>

</body>
</html>