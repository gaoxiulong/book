<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


				<div>
					<span>欢迎<span class="um_span">${ sessionScope.user.username}</span>光临尚硅谷书城</span>
					<a href="orderServlet?action=queryOrder">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
					<a href="index.jsp">返回</a>
				</div>