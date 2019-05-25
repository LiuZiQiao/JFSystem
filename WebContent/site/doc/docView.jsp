<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div id="right">
	                <h2>教学资料 </h2>
			                	<div class="c1-body">
			                		<table width="100%" border="0">
			                			<tr>
			                				<td align="center">${doc.docName}<hr/></td>
			                			</tr>
			                			<tr>
			                				<td aligin="center">
													<!--显示文档内容  -->
													<p>${doc.docContext}</p>
			                				</td>
			                			</tr>
			                		</table>		
			                	</div>
                            </div>
</body>
</html>