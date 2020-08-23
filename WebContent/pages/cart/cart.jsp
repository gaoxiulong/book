<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%--
	静态保护，头部信息:
		base标签+jquery+css
 --%>
<%@ include file="/pages/common/head.jsp" %>
<script type="text/javascript">
	$(function(){
		//查找删除，绑定单击事件
		$("a.deleteClass").click(function(){
			return confirm("确定要删除【" +$(this).parent().parent().find("td:first").text() + "】吗？");			
		});
		
		$("#clearClass").click(function(){
			return confirm("确定要清空购物车吗？");			
		});
		
		//change事件
		$("input.updateClass").change(function(){
			var newCount = this.value;
			var id = $(this).attr("itemId");
			if(confirm("确定要修改【" +$(this).parent().parent().find("td:first").text() + "】数量为：" + newCount + "吗？")){
				   //点击了确认
				   location.href = "${ path }cartServlet?action=updateItem&count=" + newCount + "&id=" + id;
			}else{
				   //点击了取消
				   this.value = this.defaultValue;
			}
		});
		
	});

</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
				<%--静态包含 登录成功之后的菜单 --%>
				<%@ include file="/pages/common/login_success_menu.jsp" %>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>	
			<c:if test="${ not empty sessionScope.cart.items }">
				<c:forEach items="${ sessionScope.cart.items }" var="entry">
					<tr>
						<td>${ entry.value.name }</td>
						<td>
							<input type="text" name="count" value="${ entry.value.count }"
								style="width:60px" class="updateClass" itemId = "${ entry.value.id }"/>
						</td>
						<td>${ entry.value.price }</td>
						<td>${ entry.value.totalPrice }</td>
						<td><a class="deleteClass" href="cartServlet?action=deleteItem&id=${ entry.value.id }">删除</a></td>
					</tr>	
				</c:forEach>	
			</c:if>
			<c:if test="${  empty sessionScope.cart.items }">
				<tr>
					<td colspan="5"><a href = "index.jsp">当前购物车为空，亲，赶紧去购物吧！</a></td>
				</tr>	
			</c:if>

		</table>
		
		<c:if test="${ not empty sessionScope.cart.items }">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${ sessionScope.cart.totalCount }</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${ sessionScope.cart.totalPrice }</span>元</span>
				<span class="cart_span"><a id="clearClass" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	
	</div>
	
	<%--静态包含页脚 --%>
	<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>