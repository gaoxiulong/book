<%@page import="sun.applet.resources.MsgAppletViewer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%--
	静态保护，头部信息:
		base标签+jquery+css
 --%>
<%@ include file="/pages/common/head.jsp" %>
<script type="text/javascript">

	$(function(){
		//使用ajax验证用户名是否已存在
		$("#username").blur(function(){
			//获取用户名
			var usernameValue = this.value;
			//判断用户名不能为空
			if(usernameValue == ""){
				$("span.errorMsg").text("用户名不能为空!");
				return;
			}
			//发送ajax请求
			$.getJSON("${path}/userServlet","action=existsUsername&username=" + usernameValue ,function(msg){
				
				if(msg.existsUsername == true){
					$("span.errorMsg").text("用户名已经存在!");
					
				}else {
					$("span.errorMsg").text("用户名可以用！");
				}
				
			});
		});
		
		
		//验证码切换操作
		$("#codeImg").click(function(){
			//在单击时间的function函数中，有一个this对象，这个this对象是当前正在响应事件的dom对象
			this.src="kaptcha.jpg?t=" + new Date();
		});
		
		
		$("#sub_btn").click(function(){

// 			验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
			//1 先获取用户名输入框中的内容
			var usernameText = $("#username").val();
			//2 创建正则表达式对象
			var usernamePatt = /^\w{5,12}$/;
			//3 调用test方法验证结果
			if ( !usernamePatt.test(usernameText) ) {
				//4 如果不合法，要提示用户，并阻止提交。
				$("span.errorMsg").text("用户名不合法!");
				return false;
			}
			

// 			验证密码：必须由字母，数字下划线组成，并且长度为5到12位
			//1 先获取密码输入框中的内容
			var passwordText = $("#password").val();
			//2 创建正则表达式对象
			var passwodPatt = /^\w{5,12}$/;
			//3 调用test方法验证结果
			if ( !passwodPatt.test(passwordText) ) {
				//4 如果不合法，要提示用户，并阻止提交。
				$("span.errorMsg").text("密码不合法!");
				return false;
			}


// 			验证确认密码：和密码相同
			// 1 获取确认密码内容
			var repwdText = $("#repwd").val();
			// 2 比较确认密码和密码是否一致
			if ( repwdText != passwordText ) {
				// 3 不一致就要提示用户，并阻止提交
				$("span.errorMsg").text("确认密码和密码不一致!");
				return false;
			}


// 			邮箱验证：xxxxx@xxx.com
			// 1 先获取邮箱内容
			var emailText = $("#email").val();
			// 2 创建邮箱正则表达式
			var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			// 3 使用test方法验证结果
			if ( !emailPatt.test(emailText) ) {
				// 4 不合法时提示用户，阻止提交
				$("span.errorMsg").text("邮箱格式不合法!");
				return false;
			}

// 			验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
			var codeText = $("#code").val();

// 			alert("去空格前：[" + codeText + "]");
			codeText = $.trim( codeText );
// 			alert("去空格后：[" + codeText + "]");

			if ( codeText == "" ) {
				$("span.errorMsg").text("验证码不能为空!");
				return false;
			}
			
			$("span.errorMsg").text("");
			// return false 可以阻止元素的默认行为。
			return true;
		});
	});
</script>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
<%-- 								<%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>  --%>	
									${ requestScope.msg }
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" 
										autocomplete="off" tabindex="1" name="username" id="username" 
<%-- 									value="<%=request.getAttribute("username")==null?"":request.getAttribute("username") %>"--%>	
										value ="${ requestScope.username }"										
										/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" 
										autocomplete="off" tabindex="1" name="password" id="password" 
<%-- 									value="<%=request.getAttribute("password")==null?"":request.getAttribute("password") %>"--%>
										value ="${ requestScope.password }"	
										/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" 
										autocomplete="off" tabindex="1" name="repwd" id="repwd" 
<%-- 									value="<%=request.getAttribute("password")==null?"":request.getAttribute("password") %>"
										value ="${ requestScope.password }"                                                  --%>
										/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" 
										autocomplete="off" tabindex="1" name="email" id="email" 
<%-- 									value="<%=request.getAttribute("email")==null?"":request.getAttribute("email") %>"--%>
										value ="${ requestScope.email }"
										/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 140px;" name="code" id="code"/>
									<img id="codeImg" src="http://localhost:8080/book/kaptcha.jpg" style="float: right; margin-right: 50px; width: 90px;height: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
	<%--静态包含页脚 --%>
	<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>