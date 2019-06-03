<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"  %>
<!DOCTYPE html >
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div>
        <div style="width:748px;margin:0 auto;border:3px solid #C3AD7C;">
         <%--  <div style="width:100%; height: 147px;background-image: url('/JFSystem/images/bg.bmp');border: "></div> --%> 
            <div style="width:100%; height:100%;margin-top: 0px;border:0px solid green;padding:1px" >
                <video width="100%" height="100%" controls="controls">
        <%--            <source type="video/mp4" src="${pageContext.request.contextPath }/uplaod/${vedio.vedioAttachment}" />
                    <source type="video/ogg" src="${pageContext.request.contextPath }/uplaod/${vedio.vedioAttachment}"/>
             --%>
            <object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" height="320" id="MediaPlayer1" width="310">
				     <br><param name="AutoStart" value="-1">
				    <param name="ShowStatuBar" value="-1">
				    <param name="Filename" value="<%=request.getContextPath()%>/upload/<%=request.getParameter("vedio")%>">
			    </object>
                </video>
            </div>
        </div>
    </div>
</body>
</html>