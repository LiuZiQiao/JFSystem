<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
      <script type="text/javascript" src="${pageContext.request .contextPath}/js/jquery-2.1.0.min.js"></script>
     <script type="text/javascript" src="${pageContext.request .contextPath}/js/jQuery.js"></script>
	<style type="text/css">
		.cl-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
	</style>
</head>
<body>
                
                <div id="right" ">
	                <h2>试题下载</h2>
			            <div id="welcome">
			                <div>
			                	<div class="c1-body">
                                <c:forEach items="${page.list }" var="v">				
									<div class="c1-bline" style="padding:7px 0px;">
										<div class="f-left">
											<!-- 	<img src="/JFSystem/img/head-mark4.gif" aligin="middle" class="i"> -->
											<a href="${pageContext.request.contextPath }/ExamServlet?method=findExamByid&id=${v.examId}"  target="rightframe">${v.examName}</a>
										</div>	 
										<div class="f-right">${v.uploadTime}</div>  <hr style="border:1px dashed #000; height:1px"/>             						
										<div claess="clear"></div>
			                		</div>
                                </c:forEach>
                               </div>
</body>
</html>