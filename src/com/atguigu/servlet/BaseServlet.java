package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 通过反射可以省去后面大量的if-elseif代码。
		 * 而且在后续添加的功能当中，我们只需要关注功能方法即可。
		 */
		
		
		//解决请求的中文乱码
		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		
		
		//获取请求参数action的值
		String action = request.getParameter("action");
	//	UserServlet userServlet = new UserServlet();
		
		/**
		 * getClass()通过类的对象获取class类
		 * getDeclaredMethod通过反射的方式获取action业务鉴别字符串所对应的业务方法对象
		 * 第一个参数是方法的名称  <br/>
		 * 第二个参数是方法的参数类型列表<br/>
		 */
		try {
			Method method = getClass().getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//通过反射调用业务方法
			method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
//		//判断
//		if ("login".equals(action)) {
//			//是登录
//	//		System.out.println("是登录过来了");
//			login(request, response);
//			
//		}else if ("regist".equals(action)) {
//			//是注册
//	//		System.out.println("是注册过来了");
//			regist(request, response);
//		} 
	}
}
