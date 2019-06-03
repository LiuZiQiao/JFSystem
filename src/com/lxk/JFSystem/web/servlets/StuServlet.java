package com.lxk.JFSystem.web.servlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.service.StuService;
import com.lxk.JFSystem.service.TeacherService;
import com.lxk.JFSystem.service.VedioService;
import com.lxk.JFSystem.utils.PageModel;
import com.lxk.JFSystem.web.base.BaseServlet;;

public class StuServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	
	//校验用户名是否存在，由ajax发起，不需要转发
	public String checkUserExist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String um = request.getParameter("username");
		
		StuService stuService = new StuService();
		
		Student stu = stuService.checkUserExist(um);
		
		if (null == stu) {
			response.getWriter().print("no");
		}else {
			response.getWriter().print("yes");
		}
		return null;
	}
	
	public String stuLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String um = request.getParameter("userName");
		String up = request.getParameter("userPw");
		
		StuService ss = new StuService();
		Student student = ss.stuLogin(um,up);
		
		if (null != student) {
			request.getSession().setAttribute("stu", student);
			response.sendRedirect(request.getContextPath()+"/site/userlogin/userlogin.jsp");
			return null;
		}else {
			request.setAttribute("msg", "密码错误");
			
			return  "/site/userlogin/userlogin.jsp";
		}
	}
	
	
	public String stuLogout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.getSession().invalidate();
		
		response.sendRedirect(request.getContextPath()+"/site/userlogin/userlogin.jsp");
		return null;
	}
	
	public String  findStudentWithPage(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		
		int currentPage = Integer.parseInt(request.getParameter("num"));
		StuService ms = new StuService();
		PageModel pageModel = ms.findStudentWithPage(currentPage);
		System.out.println(pageModel);
		request.setAttribute("page",pageModel);
		
		return "/atea/teaMana.jsp";
	}
	
	public String delStudentById(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String studentId = request.getParameter("stuId");
		int currentPage = Integer.parseInt(request.getParameter("num"));
		
		StuService ms = new StuService();
		PageModel pageModel = ms.delStudentById(currentPage,studentId);
		System.out.println(pageModel);
		request.setAttribute("page",pageModel);
		return "/atea/teaMana.jsp";
	}
	public String addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		int currentPage = Integer.parseInt(request.getParameter("num"));
		Student student = new Student();
		student.setStuNum(new String(request.getParameter("stuNum").getBytes("iso-8859-1"),"utf-8"));
		student.setStuRealname(request.getParameter("stuRealName"));
		student.setStuSex(request.getParameter("stuSex"));
		student.setStuAge(new String(request.getParameter("stuAge").getBytes("iso-8859-1"),"utf-8"));
		student.setLoginPw(new String(request.getParameter("loginPwd").getBytes("iso-8859-1"),"utf-8"));
		student.setDel("no");
		student.setStatus("yes");
		StuService ms = new StuService();
		
		PageModel pageModel = ms.addStudent(currentPage,student);
		System.out.println(pageModel);
		request.setAttribute("page",pageModel);
		return "/atea/teaMana.jsp";
	} 
	
//	"/StuServlet?method=findVedioWithPage&num=1";
	public String findVedioWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//接收当前页参数
		int num=Integer.parseInt(request.getParameter("num"));
		//调用业务层功能，返回PageModel
		//	PageModel：分页查询，查询当前页中的视频信息，
		//   							还需要分页参数
		StuService studentService = new StuService();
		PageModel pm = studentService.findVedioWithPage(num);
		//将PageModel放入request域对象内
		request.setAttribute("page", pm);
	
		//转发到/site/vedio/vedioAll.jsp
		return "/atea/vedioMana.jsp";
	}
}
