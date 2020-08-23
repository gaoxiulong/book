package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.atguigu.pojo.User;


public class ManagerFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		//设置response中文乱码的问题
		response.setContentType("text/html;charset=UTF-8");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		User user = (User) httpRequest.getSession().getAttribute("user");
		
		System.out.println(user);
		
		if (user == null) {
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else if ("admin".equals(user.getUsername())) {
			//放行，超级管理员admin放行
			chain.doFilter(httpRequest, response);
		}else {
			//普通用户登录后提示不是管理员身份
			response.getWriter().write("只有管理员才可以进入，您不是管理员。");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
