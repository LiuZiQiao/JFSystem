package com.lxk.JFSystem.web.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxk.JFSystem.domain.Teacher;
import com.lxk.JFSystem.service.TeacherService;
import com.lxk.JFSystem.web.base.BaseServlet;

public class TeacherServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public String teaLogin(HttpServletRequest request, HttpServletResponse response) throws IOException,SQLException
	{
		String um = request.getParameter("userName");
		String up = request.getParameter("userPw");
		System.out.println(um+":"+up);
		TeacherService teacherService = new TeacherService();
		Teacher teacher = teacherService.teaLogin(um,up);
		System.out.println(teacher);
		if (teacher == null) {
			request.setAttribute("msg", "用户账号密码错误");
			return "/login.jsp";
		}else {
			request.getSession().setAttribute("teacher", teacher);
			response.sendRedirect(request.getContextPath()+"/atea/index.jsp");
			return null;
		}
	}
}
