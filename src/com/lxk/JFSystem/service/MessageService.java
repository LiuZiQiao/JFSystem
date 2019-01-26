package com.lxk.JFSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.lxk.JFSystem.dao.MessageDao;
import com.lxk.JFSystem.domain.Message;
import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.utils.PageModel;

public class MessageService {

		public PageModel findMessageWithPage(int currentPage, Student student) throws SQLException {
			MessageDao mdDao = new MessageDao();
			int totalRecords = mdDao.findTotalMessageById(student.getStuId());
			PageModel pageModel = new PageModel(currentPage, totalRecords, 5);

			List<Message> list=mdDao.findMessageWithPage(pageModel.getStartIndex(),pageModel.getPageSize(),student);
			
			pageModel.setList(list);
			pageModel.setUrl("MessageServlet?method=findMessageWithPage");
			return pageModel;
		}

		public void addMessage(Message message) throws SQLException {
			MessageDao md = new MessageDao();
			md.addMessage(message);
		}

		public Message findMessageWithId(int id) throws SQLException {
			MessageDao messageDao = new MessageDao();
			return  messageDao.findMessageWithId(id);
		}
}
