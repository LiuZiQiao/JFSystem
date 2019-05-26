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
	#div1{
		width:1000px;
		height:230px;
    	background-image:url(${pageContext.request .contextPath}/images/top2.jpg);
		background-repeat:no-repeat;
		background-position:center;
		text-align:center;
    }
	body{
		font-family:"微软雅黑";
		margin:0px;
		padding:0px;
		font-size:12px;
		height:36px;
	}
	</style>
</head>
<title>教学辅助系统</title>
<body>
	<center>
    <div>
        <div id="div1">
            <h1>教务管理</h1>
        </div>
	        <div style="overflow:hidden;white-space:nowrap">
		    	<iframe src="${pageContext.request .contextPath}/site/left.jsp" name="leftframe" scrolling="no" height="540px"  width="300px" frameborder="0"></iframe>
		        <iframe src="${pageContext.request .contextPath}/site/right.jsp" name="rightframe" scrolling="no" height="540px"  width="700px" frameborder="0"></iframe>
	        </div>
        <iframe src="${pageContext.request .contextPath}/site/footer.jsp" name="rightframe" scrolling="no" height="540px"  width="800px" frameborder="0"></iframe>
    </div>
    </center>

</body>
</html>   
</html> 