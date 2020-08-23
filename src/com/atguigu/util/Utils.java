package com.atguigu.util;

import java.util.Map;


import org.apache.commons.beanutils.BeanUtils;


public class Utils {
	/**
	 * 当前的这个API的设计有严重的代码耦合，已经修正。
	 * @param request
	 * @param bean
	 */
	
	@SuppressWarnings("rawtypes")
	public static <T> T copyParamToBean(Map param,T bean) {
		try {
			/**
			 * populate把map的值注入到User对象中
			 * Map中的值是请求的参数。<br/>
			 * key = value
			 * 刚好是
			 * name = value
			 * 要求请求的参数名必须和javaBean的属性名一致！！
			 * 今天使用的BeanUtils工具类给bean对象赋值的时候，走的是写方法setXxx()
			 */
			BeanUtils.populate(bean, param);
			System.out.println(bean);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return bean;
	}
	
	public static Integer parseInt(String strInt,Integer defaultValue) {
		
			try {
				return Integer.parseInt(strInt);
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}	
		return defaultValue;
	}
}
