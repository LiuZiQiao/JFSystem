package com.lxk.JFSystem.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lxk.JFSystem.domain.Vedio;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class JDBCUtils{
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();

	public static DataSource getDataSource()
	{
		return dataSource;
	}
	public static Connection getConnection()
	{
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void closeResource(Connection conn,Statement st, ResultSet rs) {
		closeResource(st,rs);
		closeConn(conn);
	}
	public  static void closeResource(Statement st, ResultSet rs) {
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConn(Connection conn)
	{
		if (conn != null) {
			try {
				conn.close();
				tl.remove();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//开启事物
	public static void startTransaction() throws SQLException{
		getConnection().setAutoCommit(false);
	}
	
	//事物提交并释放连接
	public static void commitAndClose()
	{
		Connection conn=null;
		try {
			conn=getConnection();
			conn.commit();
			conn.close();
			tl.remove();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 事物回滚并且释放资源
	 */
	public static void rollbackAndClose()
	{
		Connection conn = null;
		try {
			conn=getConnection();
			conn.rollback();
			conn.close();
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
