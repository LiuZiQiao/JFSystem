package com.lxk.JFSystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
	
	public List<Student> findMessageWithPage(int startIndex, int pageSize) throws SQLException {
		String sql = "select* from t_stu  where del = 'no' limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Student>(Student.class),startIndex,pageSize);
	}

	public int findTotalStudent() throws SQLException {
		String sql = "select count(*) from t_stu ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num =(Long)qr.query(sql,new ScalarHandler());
		return num.intValue();
	}
	public void delStudentById(String id)throws SQLException{
		String sql = "UPDATE t_stu SET del = 'yes' WHERE stuId=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, id);//执行SQL语句
	}
	public   int addStudent(Student student) throws SQLException {
		String sql = "insert into t_stu(stuNum,stuRealname,stuSex,stuAge,loginPw,status,del) value(?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] pargam = {student.getStuNum(),student.getStuRealname(),student.getStuSex(),student.getStuAge(),student.getLoginPw(),student.getStatus(),student.getDel()};
		return qr.update(sql,pargam);
	}

}
