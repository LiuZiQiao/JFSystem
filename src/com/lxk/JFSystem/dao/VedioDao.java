package com.lxk.JFSystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.utils.JDBCUtils;

public class VedioDao {

	public List<Vedio> findPrevVedio() throws SQLException {
		String sql = "select *from t_vedio order by uploadTime desc limit 0,5";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Vedio> list = qr.query(sql, new BeanListHandler<Vedio>(Vedio.class));
		return list;
	}

	public int findTotalRecords() throws SQLException {
		String sql = "select count(*) from t_vedio";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long)qr.query(sql, new ScalarHandler());
		return num.intValue();
	}

	public List<Vedio> findVedioWithPage(int i, int j) throws SQLException {
		String sql = "select *from t_vedio   limit ? ,?";
		QueryRunner qr  = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Vedio>(Vedio.class),i,j);
	}

	public Vedio findVedioByVid(String vedioId) throws SQLException {
		String sql = "select *from t_vedio where vedioId =?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		 return qr.query(sql, new BeanHandler<Vedio>(Vedio.class),vedioId);
	}
	
	public int uploadVedio(Vedio vedio) throws SQLException {
		String sql = "insert into t_vedio(vedioName,vedioPro,vedioAttachment,AttachmentOIdName,uploadTime,del) value(?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] param = {vedio.getVedioName(),vedio.getVedioPro(),vedio.getVedioAttachment(),vedio.getAttachmentOldName(),vedio.getUploadTime(),vedio.getDel()};
		 return qr.update(sql, param);
	}
	public void delVedioById(String id)throws SQLException{
		String sql = "UPDATE t_vedio SET del = 'yes' WHERE vedioId=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, id);//执行SQL语句
	}

}
