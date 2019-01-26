<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
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
	                <h2>留言互动 </h2>
			            <div id="welcome">
			                <div>
			                	<div class="c1-body">
			                		<div style="width:100%;height:200px;border:0px solid green;margin-top:100px">
										<form action="${pageContext.request.contextPath }/MessageServlet?method=addMessage"  name="formAdd"  id="fm1" method="post">
												<table align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC">
													<tr bgcolor="#EEF4EA">
														<td colspan="3" background="/...////img/" class="title"><span>信息交流</span></td>
													</tr>
													<tr align="center" bgcolor="#FFFFFF"  onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='red';">
														<td width="25%" bgcolor="#FFFFFF" align="right">
														信息内容:
														</td>
														<td width="75%" bgcolor="#FFFFFF" align="left">
																<input type="text" id="content" name="content" size="80"/>
														</td>
													</tr>
													
													<tr align="center" bgcolor="#FFFFFF"  onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='red';">
														<td width="25%" bgcolor="#FFFFFF" align="right">
														&nbsp;
														</td>
														<td width="75%" bgcolor="#FFFFFF" align="left">
																<input type="button" value="提交" onclick="check()"/>&nbsp;
																<input type="reset" value="重置"/>&nbsp;
														</td>
													</tr>
												</table>
										</form>
			                		
			                		
			                		</div>
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

     <script type="text/javascript">
    		function check()
    		{
				var content = $("#content").val();
				var ct=$.trim(content);
				if(null==ct|| "" == ct)
				{
					alert("请输入内容");
					return false; 
				}
    			document.getElementById("fm1").submit();
    		}
     
     </script>
</html>