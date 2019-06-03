package com.lxk.JFSystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lxk.JFSystem.domain.Message;
import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.utils.JDBCUtils;

public class MessageDao {
	
	public List<Message> findMessageWithPage(int getStartIndex,int getPageSize,Student student) throws SQLException{
		String sql = "select* from t_message where stuId = ? order by leaveWordTime desc limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Message> list = qr.query(sql, new BeanListHandler<Message>(Message.class),student.getStuId(),getStartIndex,getPageSize);
		return list;
	}

	public int findTotalMessageById(int stuId) throws SQLException {
		String sql = "select count(*) from t_message where stuId = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num =(Long)qr.query(sql,new ScalarHandler(),stuId);
		return num.intValue();
	}

	public void addMessage(Message message) throws SQLException {
		String sql = "insert into t_message(content,leaveWordTime,stuId) value(?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] pargam = {message.getContent(),message.getLeaveWordTime(),message.getStuId()};
		qr.update(sql,pargam);
	}

	public Message findMessageWithId(int id) throws SQLException {
		String sql = "select *from t_message where messageId=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Message>(Message.class),id);
	}

	public int findTotalMessageById() throws SQLException {
		String sql = "select count(*) from t_message ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num =(Long)qr.query(sql,new ScalarHandler());
		return num.intValue();
	}

	public List<Message> findMessageWithPage(int startIndex, int pageSize) throws SQLException {
		String sql = "select* from t_message  order by leaveWordTime desc limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Message> list = qr.query(sql, new BeanListHandler<Message>(Message.class),startIndex,pageSize);
		return list;
	}
}
