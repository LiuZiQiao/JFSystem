package com.lxk.JFSystem.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lxk.JFSystem.domain.Admin;
import com.lxk.JFSystem.utils.JDBCUtils;

public class AdminDao {

	public Admin adminLogin(String um, String up) throws SQLException {
		String sql = "select * from t_admin where userName=? and userPw=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Admin>(Admin.class),um,up);
		
	}

}
