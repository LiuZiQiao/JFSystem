package com.lxk.JFSystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lxk.JFSystem.domain.Teacher;
import com.lxk.JFSystem.utils.JDBCUtils;

public class TeacherDao {

	public Teacher teaLogin(String um, String up) throws SQLException {
		String sql = "select * from t_tea where loginName=? And loginPwd=? ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Teacher teacher = qr.query(sql, new BeanHandler<Teacher>(Teacher.class),um,up);
		return teacher;
	}

	public List<Teacher> findMessageWithPage(int startIndex, int pageSize) throws SQLException {
		String sql = "select* from t_tea  limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Teacher> list = qr.query(sql, new BeanListHandler<Teacher>(Teacher.class));
		return list;
	}

	public int findTotalTeacher() throws SQLException {
		String sql = "select count(*) from t_tea ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num =(Long)qr.query(sql,new ScalarHandler());
		return num.intValue();
	}

}
