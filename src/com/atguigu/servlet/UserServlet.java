package com.atguigu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.Utils;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserServlet
 * 代码优化，使得注册和登录都使用同一个servlet。
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	//全局对象UserService
	private UserService userService = new UserServiceImpl();
	
	protected void existsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 获取请求参数--用户名
		String username = request.getParameter("username");
		//2 查询数据库，判断用户名是否存在
		boolean existsUsername = userService.existsUsername(username);
		//3 返回用户是否存在
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("existsUsername", existsUsername);
		
		//4 生成Gson对象，用于把map转换为json字符串返回
		Gson gson = new Gson();
		String jsonString = gson.toJson(map);
		response.getWriter().write(jsonString);
		
	}
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // 1 获取请求的参数
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String code = request.getParameter("code");
				
				//对1的代码进行优化，BeanUtils工具类可以把一些值一次性置入到Bean对象中
				User user = Utils.copyParamToBean(request.getParameterMap(), new User());
				
				// 2 检查验证码是否正确
				// 获取验证码
				String token = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				request.getSession().removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if (token != null && token.equalsIgnoreCase(code)) {
					// 3、检查用户名是否可用
					if (userService.existsUsername(username)) {
						// 用户名已存在
						System.out.println("用户名已存在！ ===>>>>" + username);
						
						//第三阶段：把错误信息，以及回显信息保存到request域中
						request.setAttribute("msg",	"用户名已存在！");
						request.setAttribute("username", username);
						request.setAttribute("email", email);
						
						/**
						 * 转发中的斜杠表示http://ip:port/工程名/ ====>>>> 映射到代码的WebContent目录
						 */
						request.getRequestDispatcher("/pages/user/regist.jsp")
								.forward(request, response);
					} else {
						// 用户名可用
						userService
								.registUser(new User(null, username, password, email));//保存数据到User对象中
						// 跳到注册成功页面
						/**
						 * 转发中的斜杠表示http://ip:port/工程名/ ====>>>> 映射到代码的WebContent目录
						 */
						request.getRequestDispatcher("/pages/user/regist_success.jsp")
								.forward(request, response);
					}
				} else {
					// 验证码错误
					System.out.println("验证码错误：" + code);
					
					//第三阶段：把错误信息，以及回显信息保存到request域中
					request.setAttribute("msg",	"验证码不正确！");
					request.setAttribute("username", username);
					request.setAttribute("password", password);
					request.setAttribute("email", email);
					
					/**
					 * 转发中的斜杠表示http://ip:port/工程名/ ====>>>> 映射到代码的WebContent目录
					 */
					request.getRequestDispatcher("/pages/user/regist.jsp").forward(
							request, response);
				}
	}
	/*
	 * 注销登录
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//注销登录功能，只需要销毁Session
		request.getSession().invalidate();//就会马上超时（Session中的数据全部没有）
		//转发到首页
		response.sendRedirect(request.getContextPath());
	}
	/*
	 * 登录
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1、获取请求的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		2、调用userService.login()
		User loginUser = userService.login(new User(null, username, password, null));
//		3、根据返回的结果判断用户是否登录成功
		if (loginUser == null) {
//			失败
//				跳回登录页面
			//把错误信息，以及回显信息保存到request域中
			request.setAttribute("msg", "用户名或密码错误！");
			request.setAttribute("username", username);
			
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
//			成功 保存用户的信息到Session域中
			request.getSession().setAttribute("user", loginUser);
//				跳到登录成功页面
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
		}
	}
}
