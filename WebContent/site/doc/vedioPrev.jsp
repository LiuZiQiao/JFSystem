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
	   <div id="weapper">
            <div id="header">

            </div>
        
        	   <div id="left">
        	   			<jsp:include flush="true"  page="/site/left.jsp"></jsp:include>
        	   </div>
                
                <div id="right" ">
	                <h2>教学文档 </h2>
			            <div id="welcome">
			                <div>
			                	<div class="c1-body">
<!-- 									
										<div class="f-left">
											<img src="/JFSystem/img/head-mark4.gif" aligin="middle" class="i">
											<a href="/JFSystem/VedioServlet?method=findVedioById&id=${v.vedioId }">
										</div>
										<div class="f-right">${v.uploadTime }</div>
										<div class="clear"></div>
 -->
                                <c:forEach items="${list }" var="v">				
									<div class="c1-bline" style="padding:7px 0px;">
										<div class="f-left">
											<img src="/JFSystem/img/head-mark4.gif" aligin="middle" class="i">
											<a href="/JFSystem/site/vedio/vedioDetail.jsp" >${v.vedioName}</a>
										</div>	 
										<div class="f-right">${v.uploadTime}</div>               						
										<div claess="clear"></div>
			                		</div>
                                </c:forEach>
			                				
                                    <div class="pg-3"></div>
			                	</div>
                            </div>
                            <p class="more"><a href="${pageContext.request.contextPath }/VedioServlet?method=findVedioWithPage&num=1">more</a></p>
                            
		                </div>
		            	<%@ include file="/site/footer.jsp" %>
                </div>
                <div class="clear"></div>

                <div id="footer">
                    <div id="copyright">
    Copyright &copy;点心网络文化工作室&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/JFSystem/site/Instruction.jsp">欢迎加入</a>

                    </div>
                </div>
        </div>
</body>
</html>