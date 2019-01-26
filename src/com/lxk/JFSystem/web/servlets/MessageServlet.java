package com.lxk.JFSystem.web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxk.JFSystem.domain.Message;
import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.service.MessageService;
import com.lxk.JFSystem.utils.PageModel;
import com.lxk.JFSystem.web.base.BaseServlet;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class MessageServlet extends BaseServlet{

	public  String findMessageWithPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		int currentPage = Integer.parseInt(request.getParameter("num"));
		
		Student student= (Student)(request.getSession().getAttribute("stu"));
		System.out.println(student);
		MessageService ms = new MessageService();
		PageModel pageModel = ms.findMessageWithPage(currentPage,student);
		
		request.setAttribute("page",pageModel);
		
		return "/site/message/messageAll.jsp";
	}
	
	public String addMessageUI(HttpServletRequest request, HttpServletResponse response) {
		
		return "/site/message/messageAdd.jsp";
	}
	
public String addMessage(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String content  = request.getParameter("content");
		Student student = (Student)request.getSession().getAttribute("stu");
		Message message = new  Message();
		message.setContent(content);
		message.setStuId(student.getStuId());
		SimpleDateFormat  sdf  = new SimpleDateFormat("yyyy-MM-dd");
		message.setLeaveWordTime(sdf.format(new Date()));
		
		MessageService ms = new MessageService();
		ms.addMessage(message);
		response.sendRedirect(request.getContextPath()+"/MessageServlet?method=findMessageWithPage&num=1");
//		return "/MessageServlet?method=findMessageWithPage&num=1";
		return null;
	}

	public String  findMessageWithId(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		MessageService ms = new MessageService();
		Message message = new Message();
		message = ms.findMessageWithId(id);
		request.setAttribute("message", message);
		return "/site/message/messageDetial.jsp";
	}
}
