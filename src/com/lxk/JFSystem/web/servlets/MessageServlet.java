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
import com.lxk.JFSystem.service.StuService;
import com.lxk.JFSystem.utils.PageModel;
import com.lxk.JFSystem.web.base.BaseServlet;


@SuppressWarnings("serial")
public class MessageServlet extends BaseServlet{

	public  String findMessageWithPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		int currentPage = Integer.parseInt(request.getParameter("num"));
		
		Student student= (Student)(request.getSession().getAttribute("stu"));
		//未登录时查看留言需要登录
		if (student == null) {
//			request.setAttribute("msg","请登录后发布留言");
			response.getWriter().write("<script   language=javascript>alert('请登录后查看发布留言！');</script>");
		}
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
	
	public String findMsgWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//接收当前页参数
		int num=Integer.parseInt(request.getParameter("num"));
		//调用业务层功能，返回PageModel
		//	PageModel：分页查询，查询当前页中的视频信息，
		//   							还需要分页参数
		MessageService messageService = new MessageService();
		PageModel pm = messageService.findMessageWithPage(num);
		//将PageModel放入request域对象内
		request.setAttribute("page", pm);
	
		//转发到/site/vedio/vedioAll.jsp
		return "/atea/viewMessage.jsp";
	}
}
