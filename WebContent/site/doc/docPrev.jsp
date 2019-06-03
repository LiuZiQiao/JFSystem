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
	                <h2 style="padding-left:30px; font-size:25px">教学资料 </h2>
	                <hr style="height:3px;border:none;border-top:3px groove skyblue"/> 
			            <div id="welcome" style="border:1px;">
			                <div>
			                	<div class="c1-body" >
                                <c:forEach items="${list }" var="v">				
									<div class="c1-bline" >
									<ul>
										<li >
										<div class="f-left">
											<a href="${pageContext.request.contextPath }/DocServlet?method=findDocByVid&id=${v.docId}" target="rightframe" style="text-decoration:none; color:black; font-size:20px;">${v.docName}</a>
										</div>	 
										<div class="f-right">${v.uploadTime}</div>   <hr style="height:2px;border:none;border-top:2px groove skyblue"/>    						    						
										<div class="clear"></div>
									</li>
									</ul>
			                		</div>
                                </c:forEach>
			                				
                                    <div class="pg-3" ></div>
			                	</div>
                            </div>
                            <p class="more" style="right"><a href="${pageContext.request.contextPath }/DocServlet?method=findDocWithPage&num=1" target="rightframe"><img  src="${pageContext.request.contextPath }/img/pic1.png" style="width:50px; height:30px; float:right;"></a></p>
                            
		                </div>
                </div>
                <div class="clear"></div>
</body>
</html>