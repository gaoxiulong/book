<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>

<%--
	静态保护，头部信息:
		base标签+jquery+css
 --%>
<%@ include file="/pages/common/head.jsp" %>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			
			<%--静态包含manager模块的菜单 --%>
			<%@ include file="/pages/common/manager_menu.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>	
			<c:forEach items="${ requestScope.allorder }" var="order">	
				<tr>
					<td>${ order.createTime }</td>
					<td>${ order.price }</td>
					<td><a href="orderServlet?action=queryItemOrder&orderId=${ order.orderId }&flag=1">查看详情</a></td>
					<c:if test="${ order.status == 0}">
						<td><a href="orderServlet?action=updateOrder&orderId=${ order.orderId  }&status=${ order.status + 1}">点击发货</a></td>
					</c:if>
					<c:if test="${ order.status == 1}">
						<td>已发货</td>
					</c:if>
					<c:if test="${ order.status == 2}">
						<td>已完成</td>
					</c:if>
				</tr>	
			</c:forEach>

		</table>
		

	</div>
	
	<%--静态包含页脚 --%>
	<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>