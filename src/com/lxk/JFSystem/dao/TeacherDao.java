package com.lxk.JFSystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.domain.Teacher;
import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.utils.JDBCUtils;

public class TeacherDao {

	public Teacher teaLogin(String um, String up) throws SQLException {
		String sql = "select * from t_tea where loginName=? And loginPwd=? ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Teacher teacher = qr.query(sql, new BeanHandler<Teacher>(Teacher.class),um,up);
		return teacher;
	}

	public List<Teacher> findMessageWithPage(int startIndex, int pageSize) throws SQLException {
		String sql = "select* from t_tea where del = 'no' limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Teacher>(Teacher.class),startIndex,pageSize);
	}

	public int findTotalTeacher() throws SQLException {
		String sql = "select count(*) from t_tea ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num =(Long)qr.query(sql,new ScalarHandler());
		return num.intValue();
	}
	public void delTeacherById(String id)throws SQLException{
		String sql = "UPDATE t_tea SET del = 'yes' WHERE teaId=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, id);//执行SQL语句
	}
	public   int addTeacher(Teacher teacher) throws SQLException {
		String sql = "insert into t_tea(teaNum,teaRealName,teaSex,teaAge,loginName,loginPwd,del) value(?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] pargam = {teacher.getTeaNum(),teacher.getTeaRealName(),teacher.getTeaSex(),teacher.getTeaAge(),teacher.getLoginName(),teacher.getLoginPwd(),teacher.getDel()};
		return qr.update(sql,pargam);
	}
}
