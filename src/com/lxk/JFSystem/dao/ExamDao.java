package com.lxk.JFSystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lxk.JFSystem.domain.Exam;
import com.lxk.JFSystem.utils.JDBCUtils;

public class ExamDao {
	//查询前5条
		public List<Exam> findPrevExam() throws SQLException {
			String sql = "select *from t_exam order by uploadTime desc limit 0,5";
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			List<Exam> list = qr.query(sql, new BeanListHandler<Exam>(Exam.class));
			return list;
		}
		
		//总查询
		public int findTotalRecords() throws SQLException {
			String sql = "select count(*) from t_exam";
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			Long num = (Long)qr.query(sql, new ScalarHandler());
			return num.intValue();
		}
		
		//分页查询
		public List<Exam> findExamWithPage(int i, int j) throws SQLException {
			String sql = "select *from t_exam limit ? ,?";
			QueryRunner qr  = new QueryRunner(JDBCUtils.getDataSource());
			return qr.query(sql, new BeanListHandler<Exam>(Exam.class),i,j);
		}
		
		//id查询
		public Exam findExamByid(String vedioId) throws SQLException {
			String sql = "select *from t_exam where examId =?";
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			 return qr.query(sql, new BeanHandler<Exam>(Exam.class),vedioId);
		}
}
