package com.lxk.JFSystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lxk.JFSystem.domain.Document;
import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.utils.JDBCUtils;

public class DocumentDao {

	public List<Document> findPrevDoc() throws SQLException {
		String sql = "select *from t_doc order by uploadTime desc limit 0,5";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Document> list = qr.query(sql, new BeanListHandler<Document>(Document.class));
		System.out.println("DocumentDao.findPrevDoc():"+list);
		return list;
	}

	public int findTotalRecords() throws SQLException {
		String sql = "select count(*) from t_doc";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long)qr.query(sql, new ScalarHandler());
		return num.intValue();
	}

	public List<Document> findDocWithPage(int i, int j) throws SQLException {
		String sql = "select *from t_doc limit ? ,?";
		QueryRunner qr  = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Document>(Document.class),i,j);
	}

	public Document findDocByVid(String docId) throws SQLException {
		String sql = "select *from t_doc where docId =?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		 return qr.query(sql, new BeanHandler<Document>(Document.class),docId);
	}
}
