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
    <style type="text/css">
    .div1{
    position:relative;
    text-align:center;
    top:50px;}
    
    
    
   </style>
</head>
<body>
<div class="div1">
<a href="${pageContext.request.contextPath}/StuServlet?method=findStudentWithPage&num=1" target="centerFrame">管理学生信息</a>
<a href="${pageContext.request.contextPath }/StuServlet?method=findVedioWithPage&num=1" target="centerFrame">管理视频信息</a>
<a href="${pageContext.request.contextPath }/StuServlet?method=findDocWithPage&num=1" target="centerFrame">管理文档信息</a>
<a href="${pageContext.request.contextPath }/MessageServlet?method=findMsgWithPage&num=1" target="centerFrame">回复留言信息</a>
</div>
	
</body>
</html>