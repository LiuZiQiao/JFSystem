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
	                <h2>教学视频 </h2>
			            <div id="welcome">
			                <div>
			                	<div class="c1-body">
                                <c:forEach items="${page.list }" var="v">				
									<div class="c1-bline" style="padding:7px 0px;">
										<div class="f-left">
											<img src="/JFSystem/img/head-mark4.gif" aligin="middle" class="i">
											<a href="${pageContext.request.contextPath }/VedioServlet?method=findVedioByVid&id=${v.vedioId}" >${v.vedioName}</a>
										</div>	 
										<div class="f-right">${v.uploadTime}</div>  <hr style="border:1px dashed #000; height:1px"/>             						
										<div claess="clear"></div>
			                		</div>
                                </c:forEach>
                           <%--
                                <div style="text-align:center">
                                			共${page.totalPageNum }页/第${page.currentPageNum }页
                                			<a href="${pageContext.request.contextPath }/VedioServlet?method=findVedioWithPage&num=1">首页</a>
                                			<a href="${pageContext.request.contextPath }/VedioServlet?method=findVedioWithPage&num=${page.prevPageNum}">上一页</a>
											<c:forEach begin="${page.startPage }"  end="${page.endPage}"  var="i">
											<a href="${pageContext.request.contextPath }/VedioServlet?method=findVedioWithPage&num=${i}">${i }</a>
											</c:forEach>
                                			<a href="${pageContext.request.contextPath }/VedioServlet?method=findVedioWithPage&num=${page.nextPageNum}">下一页</a>
                                			<a href="${pageContext.request.contextPath }/VedioServlet?method=findVedioWithPage&num=${page.totalPageNum}">末页</a>
 			                                <input type="text" name="pagenum" id="pagenum" size="1"/>
 			                                <input type="button" onclieck="jump()" value="前往"/>
											<script type="text/javascript">
												function jump(){
													var totalPageNum = ${page.totalPageNum};
													var pagenum=document.getElementById("pagenum").value;
													var reg = /^[1-9][0-9]{0,1}$/;
													if(!reg.test(pagenum))
													{
														alert("请输入符合规定的数");
														return ;
													}
													
													if(parseInt(pagenum)>parseInt(totalpage))
													{
														alert("不能大于总页数");
														return;
													}
													
													window.location.href="${pageContext.request.contextPath}/VedioSsrvlet&num="+pagenum;
												}
											
											</script> 
                                </div>
                                  --%>
                        		<%@ include  file ="/jsp/pageFile.jsp" %>  
                              
                        		<!--<jsp:include flush="true"  page="/jsp/pageFile.jsp"></jsp:include>
                    -->
                                    <div class="pg-3"></div>
			                	</div>
                            </div>
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