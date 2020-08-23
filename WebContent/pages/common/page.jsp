<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--分页模块抽象 --%>
<div id="page_nav">
		
			<%--
				如果当前页不是第一页，才会显示首页、上一页
			 --%>
			<c:if test="${ requestScope.page.pageNo > 1 }">
				<a href="${ page.url }&pageNo=1">首页</a>
				<a href="${ page.url }&pageNo=${ requestScope.page.pageNo - 1 }">上一页</a>
			</c:if>
			<%-- 
			<a href="#">3</a>
			【${ requestScope.page.pageNo }】
			<a href="#">5</a>
			--%>
			
			<%--连续5个页码显示功能 START--%>
			<c:choose>
				<%-- 当总的页数小于等于5的情况  --%>
				<c:when test="${ page.pageTotal <= 5 }">
					<!-- 遍历出所有的页码 -->
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${ page.pageTotal }"></c:set>
				</c:when>
				<%-- 总页码大于5的情况 --%>
				<c:otherwise>
					<c:choose>
					<%-- 如果当前页码为 1 - 3，那么 我们显示前面5个页码，也就是1-5  --%>
					<c:when test="${ page.pageNo <= 3 }">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="5"></c:set>						
					</c:when>
					<%-- 如果当前页码为 末尾的三个，也就是 page.pageNo >= page.pageTotal - 2 ,那么 就显示末尾5个页码 --%>
					<c:when test="${ page.pageNo >= page.pageTotal - 2 }">
						<c:set var="begin" value="${ page.pageTotal - 4 }"></c:set>
						<c:set var="end" value="${ page.pageTotal }"></c:set>							
					</c:when>
					<%-- 其他中间的页码，显示 page.pageNo - 2 到 page.pageNo + 2  --%>
					<c:otherwise>
						<c:set var="begin" value="${ page.pageNo - 2 }"></c:set>
						<c:set var="end" value="${ page.pageNo + 2 }"></c:set>					
					</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			
				<!-- 遍历页码  -->
			<c:forEach begin="${ begin }" end="${ end }" var="i">
				<%-- 如果页码是当前页，则不加连接 --%>
				<c:if test="${ i == page.pageNo }">
					【${ i }】
				</c:if>
				<%-- 如果页码不是当前页，加连接 --%>
				<c:if test="${ i != page.pageNo }">
					<a href="${ page.url }&pageNo=${i}">${ i }</a>
				</c:if>
			</c:forEach>	
			
			<%--连续5个页码显示功能 END--%>
			
			<%--
				如果当前页等于最后一页，就不需要显示末页和下一页。
			 --%>
			<c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }">
				<a href="${ page.url }&pageNo=${ requestScope.page.pageNo + 1 }">下一页</a>
				<a href="${ page.url }&pageNo=${ requestScope.page.pageTotal }">末页</a>
			</c:if>
			共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount }条记录 到第<input value="${ requestScope.page.pageNo }" name="pn" id="pn_input"/>页
			<input id="searchPageNo" type="button" value="确定">
			
			<%--以下是脚本 --%>
			<script type="text/javascript">
			
				$(function(){
					//给指定页面的按钮绑定单击事件
					$("#searchPageNo").click(function(){
						//获取输入框中的页面
						var pageNo = $("#pn_input").val();
						//修改浏览器请求地址，刷新页面。
						/*
							js中语言中提供了一个现成的对象叫location对象表示浏览器地址栏
							有一个属性叫href，表示浏览器地址栏中的地址
							href属性可读可写
						alert(location.href);
						*/
						location.href = "${ path }${ page.url }&pageNo=" + pageNo;
					});				
				});
			
			</script>
</div>