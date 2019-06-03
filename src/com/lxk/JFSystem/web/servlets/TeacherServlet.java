package com.lxk.JFSystem.web.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.domain.Teacher;

import com.lxk.JFSystem.service.TeacherService;
import com.lxk.JFSystem.utils.PageModel;
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
	
	public String  teaLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
	{
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return null;
	}
	
	public String  findTeacherWithPage(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		
		int currentPage = Integer.parseInt(request.getParameter("num"));
		TeacherService ms = new TeacherService();
		PageModel pageModel = ms.findTeacherWithPage(currentPage);
		System.out.println(pageModel);
		request.setAttribute("page",pageModel);
		
		return "/admin/adminMana.jsp";
	}
	
	public String delTeacherById(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String teacherId = request.getParameter("teaId");
		int currentPage = Integer.parseInt(request.getParameter("num"));
		
		TeacherService ms = new TeacherService();
		PageModel pageModel = ms.delTeacherById(currentPage,teacherId);
		
		request.setAttribute("page",pageModel);
		return "/admin/adminMana.jsp";
	}
	public String addTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		int currentPage = Integer.parseInt(request.getParameter("num"));
		Teacher teacher = new Teacher();
		
		teacher.setTeaNum(new String(request.getParameter("teaNum").getBytes("iso-8859-1"),"utf-8"));
		teacher.setTeaRealName(request.getParameter("teaRealName"));
		teacher.setTeaSex(request.getParameter("teaSex"));
		teacher.setTeaAge(new String(request.getParameter("teaAge").getBytes("iso-8859-1"),"utf-8"));
		teacher.setLoginName(request.getParameter("loginName"));
		teacher.setLoginPwd(new String(request.getParameter("loginPwd").getBytes("iso-8859-1"),"utf-8"));
		teacher.setDel("no");
		TeacherService ms = new TeacherService();
		System.out.println(teacher);
		PageModel pageModel = ms.addTeacher(currentPage, teacher);
		
		request.setAttribute("page",pageModel);
		return "/admin/adminMana.jsp";
	} 
}
