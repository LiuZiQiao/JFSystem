<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="text-align: center">
	共${page.totalPageNum }页/第${page.currentPageNum }页 <a
		href="${pageContext.request.contextPath }/${page.url }&num=1">首页</a> <a
		href="${pageContext.request.contextPath }/${page.url }&num=${page.prevPageNum}">上一页</a>
	<c:forEach var="pagenum" begin="${page.startPage }"
		end="${page.endPage }">
		<a
			href="${pageContext.request.contextPath }/${page.url }&num=${pagenum}">${pagenum }</a>
	</c:forEach>
	<a
		href="${pageContext.request.contextPath }/${page.url }&num=${page.nextPageNum}">下一页</a>
	<a
		href="${pageContext.request.contextPath }/${page.url }&num=${page.totalPageNum}">末页</a>
	<input type="text" name="pagenum" id="pagenum" size="1" /> <input
		type="button" onclick="jump()" value="前往" />
	<script type="text/javascript">
		function jump() {
			var totalPageNum = $
			{
				page.totalPageNum
			};
			var pagenum = document.getElementById("pagenum").value;
			var reg = /^[1-9][0-9]{0,1}$/;
			if (!reg.test(pagenum)) {
				alert("请输入符合规定的数");
				return;
			}
			if (parseInt(pagenum) > parseInt(totalPageNum)) {
				alert("不能大于总页数");
				return;
			}
			window.location.href = "${pageContext.request.contextPath}/${page.url }&num="
					+ pagenum;
		}
	</script>
</div>