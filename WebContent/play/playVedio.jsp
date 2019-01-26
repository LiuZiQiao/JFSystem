<%@ page language="java"  import="java.util.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
        <div style="width:748px;margin:0 auto;border:3px solid #C3AD7C;">
         <%--  <div style="width:100%; height: 147px;background-image: url('/JFSystem/images/bg.bmp');border: "></div> --%> 
            <div style="width:100%; height:100%;margin-top: 0px;border:0px solid green;padding:1px" >
                <video width="100%" height="100%" controls="controls">
            <%--<source src="test.mp4" type="video/mp4"/> --%>        
                    <source type="video/mp4" src="${pageContext.request.contextPath }/uplaod/${vedio.vedioAttachment}" />
                    <source src="${pageContext.request.contextPath }/uplaod/${vedio.vedioAttachment}" type="video/avi"/>
                </video>
            </div>
        </div>
    </div>
</body>
</html>