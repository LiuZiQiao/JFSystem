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
     
     
     <style>
table{
	line-height:40px;
}

#div1{
	width:300px;
	height:240px;
	}
#div2{
	width:300px;
	height:300px;
	background-color:#FFFFCE;
}
.img1{
	width:300px;
	height:50px;
	background-color:white;
}
.btn{
	width:60px;
}

</style>
</head>
<body>
<!-- 
	  <div class="nav">
            <ul class="menu">
            	<li><a href="/JFSystem/DocumentServlet?method=findAllDocumentsWithPage&num1" style=""></a>
                <li><a href="${pageContext.request .contextPath}/doc/docAll.html" style="font-family: 微软雅黑;font-size:12px;"><img src="${pageContext.request .contextPath}/images/jxzl.png "/></a></li>
                 <li><a href="${pageContext.request .contextPath}/VedioServlet?method=findPrevVedio" style="font-family: 微软雅黑;font-size:12px;"><img src="${pageContext.request .contextPath}/images/jxsp.png "/></a></li>
                <li><a href="/JFSystem/ExamServlet?method=findAllExamWithPage&num=1"  style="font-family: 微软雅黑;font-size:12px;"><img src="${pageContext.request .contextPath}/images/stxz.png "/></a></li>
                <li><a href="${pageContext.request .contextPath}/MessageServlet?method=findMessageWithPage&num=1" style="font-family: 微软雅黑;font-size:12px;"><img src="${pageContext.request .contextPath}/images/lyhd.png "/></a></li>
            </ul>
        </div>
 -->
									<div id="div1">
										<a href="${pageContext.request .contextPath}/DocServlet?method=findPrevDoc" target="rightframe"><img class="img1" src="${pageContext.request .contextPath}/images/jxzl.png " /></a><br />
										<a href="${pageContext.request .contextPath}/VedioServlet?method=findPrevVedio" target="rightframe"><img class="img1" src="${pageContext.request .contextPath}/images/jxsp.png " alt="alt" /></a><br />
										<a href="${pageContext.request .contextPath}/ExamServlet?method=findPrevExam" target="rightframe"><img class="img1" src="${pageContext.request .contextPath}/images/stxz.png " /></a><br />
										<a href="${pageContext.request .contextPath}/MessageServlet?method=findMessageWithPage&num=1" target="rightframe"><img class="img1" src="${pageContext.request .contextPath}/images/ssjl.png " /></a><br />
									</div>
        <!--     	<jsp:include flush="true" page="/site/userlogin/userlogin.jsp"></jsp:include> -->
            	 <iframe src="${pageContext.request .contextPath}/site/userlogin/userlogin.jsp" name="loginframe" scrolling="no" frameborder="0"></iframe>
</body>
</html>