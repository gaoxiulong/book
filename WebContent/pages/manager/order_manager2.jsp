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
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
			</tr>	
			<c:forEach items="${ requestScope.orderItems }" var="orderItems">		
				<tr>
					<td>${ orderItems.name }</td>
					<td>${ orderItems.count }</td>
					<td>${ orderItems.price}</td>
					<td>${ orderItems.totalPrice}</td>
				</tr>	
			</c:forEach>
			
		</table>
	</div>
	
	<%--静态包含页脚 --%>
	<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>