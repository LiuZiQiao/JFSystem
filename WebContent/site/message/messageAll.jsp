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
                <div id="right" >
	                <h2 style="padding-left:30px; font-size:25px">留言互动 </h2>
			        <hr style="height:3px;border:none;border-top:3px groove skyblue"/> 
			            
			            <div id="welcome">
			                <div>
			                	<div class="c1-body">
                                <c:forEach items="${page.list }" var="v" varStatus="sta">				
									<div class="c1-bline" >
									<ul>
									<li>
										<div class="f-left">
										<!-- 	<img src="/JFSystem/img/head-mark4.gif" aligin="middle" class="img-vm"> -->
											<a href="${pageContext.request.contextPath }/MessageServlet?method=findMessageWithId&id=${v.messageId}"  target="rightframe" style="text-decoration:none; color:black; font-size:20px;">${v.content}</a>
										</div>	 
										<div class="f-right">${v.leaveWordTime}</div> <hr style="height:2px;border:none;border-top:2px groove skyblue"/>          						
										<div class="clear"></div>
										</li>
									</ul>
			                		</div>
                                </c:forEach>
									<center><a href="${pageContext.request.contextPath }/MessageServlet?method=addMessageUI" target="rightframe" style="color:black">发布留言</a></center>
                                    <div class="pg-3"></div>
                                    <%@ include  file ="/jsp/pageFile.jsp" %>  
			                	</div>
                            </div>
		                </div>
                </div>
</html>