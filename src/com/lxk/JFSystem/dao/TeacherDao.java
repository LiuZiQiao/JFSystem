package com.lxk.JFSystem.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lxk.JFSystem.domain.Teacher;
import com.lxk.JFSystem.utils.JDBCUtils;

public class TeacherDao {

	public Teacher teaLogin(String um, String up) throws SQLException {
		String sql = "select * from t_tea where loginName=? And loginPwd=? ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Teacher teacher = qr.query(sql, new BeanHandler<Teacher>(Teacher.class),um,up);
		return teacher;
	}

}
