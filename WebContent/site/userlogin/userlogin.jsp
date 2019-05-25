<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
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
    <script type="text/javascript" src="${pageContext.request .contextPath}/js/jQuery.js"></script>
    <script type="text/javascript" src="${pageContext.request .contextPath}/js/jquery-2.1.0.min.js"></script>

<style type="text/css">

#div2{
	width:300px;
	height:300px;
	background-color:#FFFFCE;
}
</style>
</head>
<body>
<table border="0" cellSpacing="3" width="178" height="22">
                <tr>
                    <td height="22" vAlign="middle" width="100%">
	                   <c:if test="${empty stu }">
	                        <form action="${pageContext.request.contextPath}/StuServlet?method=stuLogin" name="ThisForm" method="post" id="fm" target="loginframe">
	                            <table cellspacing="0" cellspacing="0" width="98%" aligin="center" border="0" height="60">
	                                <tr>
	                                    <td align="center" colspan="2" height="10"></td>
	                               		<span style="color:red  font-size:11px"  id="stuNumMsg">${msg}</span>
	                                </tr>
	                                <tr>
	                                    <td align="right" width="31%" height="30" style="font-size: 11px";>学号:</td>
	                                    <td align="left" width="69%">
	                                    	<input name="userName" type="text" style="width:100px" id="username"/>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <td align="right"  height="30" style="font-size: 11px";>密码:</td>
	                                    <td align="left">
	                                    	<input type="password" style="width:100px" name="userPw" id="userPw"/>
	                                    </td>
	                                </tr>
	
	                                <tr>
	                                    <td align="center" colspan="2" height="3"></td>
	                                </tr>
	
	                                <tr>
	                                    <td align="right" height="30" style="font-size: 11px">&nbsp;</td>
	                                    <td align="left">
	                                    <input type="button"  onclick="checkLogin()" id="btnLogin"  value="登录" style="border: #ccc 1px solid;background-color:#FFFFFF;font-size:12px;font-family:微软雅黑;width:50px;"/>
	                                    <input type="reset" value="重置"  style="border: #ccc 1px solid; background-color:#FFFFFF; font-size:12px;font-family:微软雅黑;width:50px;"/>
	                                    </td>
	                                </tr>
	                            </table>
	                        </form>
                        </c:if>
                        <br/>
                        
                        <c:if test="${not empty stu }">
                        	欢迎你，${stu.stuRealname} &nbsp;&nbsp;
                        <a href="javascript:void(0)" onclick="logout()">安全退出</a>
                        <br/><br/><br/>
                       </c:if> 
                    </td>
                </tr>
            </table>
</body>

<script type="text/javascript">


//学号效验
$(function(){	
    $("#username").blur(function(){
        $("input").css("background-color","#D6D6FF");
        var um=$("#username").val();
        var username=$.trim(um);
        if(""!= username &&  username != null){
            $.post("/JFSystem/StuServlet",{"method":"checkUserExist","username":username},function(data){
                console.log(data);
                if(data=="yes"){             
                    $("#stuNumMsg").html(" ");
                }
                if(data=="no")
                    {
                		$("#stuNumMsg").html("用户不存在，请重新输入 ");
                    }
			});
        }else
           {
                alert("请输入学号");
           }
    });  
});


function  checkLogin()
{
    var username = $("#username").val();
    var password = $("#userPw").val();
    
    var um = $.trim(username);
    var up = $.trim(password);
    
    if(null == um || " " == um)
    {
            alert("请输入用户名");
            return false;
    }
    
    if(null == up || "" == up)
    {
            alert("请输入密码");
            
            return false;
    }
    document.getElementById("fm").submit();
}


function logout()
{
	if(confirm("确定退出吗？")){
		location.href="/JFSystem/StuServlet?method=stuLogout";
	}	
}

</script>
</html>