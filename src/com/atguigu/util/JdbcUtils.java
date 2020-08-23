package com.atguigu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * JdbcUtils 工具类<br/>
 * 创建一个数据库连接池，提供给用户获取数据库连接，然后关闭数据库连接
 */
public class JdbcUtils {
	
	static DruidDataSource dataSource;
	//ThreadLocal可以实现类似map的存储功能
	static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static {
		
		Properties properties = new Properties();
		InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(is);
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//			System.out.println( dataSource );
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从数据库连接池中获取连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		
		Connection connection = threadLocal.get();
		
		if (connection == null) {
			
			try {
				// 从数据库连接池中获取数据库连接
				connection = dataSource.getConnection();
				//保存到ThreadLocal中，供后面操作使用
				threadLocal.set(connection);
				//设置手动管理事务
				connection.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	/**
	 * 提交事务并关闭连接
	 */
	public static void commitAndClose() {
		
		Connection connection = threadLocal.get();
		
		if (connection != null) {
			try {
				connection.commit();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//因为Tomcat底层使用了线程池，不写此代码会报错
		threadLocal.remove();
	}
	
	
	
	/**
	 * 提交事务并关闭连接
	 */
	public static void rollbackAndClose() {
		Connection connection = threadLocal.get();
		
		if (connection != null) {
			try {
				connection.rollback();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//因为Tomcat底层使用了线程池，不写此代码会报错
		threadLocal.remove();
	}
	

	/**
	 * 关闭连接，释放资源
	 * 
	 * @param conn
	
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	 */

}
