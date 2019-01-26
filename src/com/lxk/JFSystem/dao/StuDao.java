package com.lxk.JFSystem.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.utils.JDBCUtils;

public class StuDao {

	public Student checkUserExist(String um) throws SQLException {
		String sql = "select *from t_stu where stuNum=? ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query( sql, new BeanHandler<Student>(Student.class), um);
	}

	public Student stuLogin(String um, String up) throws SQLException {
		String sql = "select *from t_stu where stuNum = ? and loginPw = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query( sql, new BeanHandler<Student>(Student.class), um,up);
	}

}
