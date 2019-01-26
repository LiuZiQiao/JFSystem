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
<title>教学辅助系统</title>
<body>
        <div id="weapper">
                <div id="header"></div>
        
        	   <div id="left">
        	   			<jsp:include flush="true"  page="/site/left.jsp"></jsp:include>
        	   </div>
                
                <div id="right" style="margin-left:70px;margin-top:70px">
	                	<h2>欢迎进入教学辅助系统 </h2>
		                	<div id="welcome"  style="margin-left:30px;font-size:15px;margin-top:70px">
		                			<p>获取视频、笔记、代码</p>
		                			<br/><br/>
		                	</div>
		                	<%@ include file="/site/footer.jsp" %>
	             </div>
        </div>
      
 </body>   
</html> 