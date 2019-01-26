<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	 <div id="logo">
	 
	 <br/><br/><br/><span style="background:blue;font-size:25px;margin-left:25px">教学辅助系统</span>
	 </div>
	  <div class="nav">
            <ul class="menu">
            	<li><a href="/JFSystem/DocumentServlet?method=findAllDocumentsWithPage&num1" style=""></a>
                <li><a href="doc/docAll.html" style="font-family: 微软雅黑;font-size:12px;">教学资料</a></li>
                 <li><a href="${pageContext.request .contextPath}/VedioServlet?method=findPrevVedio" style="font-family: 微软雅黑;font-size:12px;">教学视频</a></li>
                <li><a href="/JFSystem/ExamServlet?method=findAllExamWithPage&num=1"  style="font-family: 微软雅黑;font-size:12px;">试题下载</a></li>
                <li><a href="${pageContext.request .contextPath}/MessageServlet?method=findMessageWithPage&num=1" style="font-family: 微软雅黑;font-size:12px;">留言互动</a></li>
            </ul>
        </div>
    
        <div id="news">
            <jsp:include flush="true" page="/site/userlogin/userlogin.jsp"></jsp:include>
       		<div class="hr-dots"></div>
       	
        </div>
</body>
</html>