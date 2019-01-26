package com.lxk.JFSystem.web.servlets;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.service.StuService;
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
			response.sendRedirect(request.getContextPath()+"/site/index.jsp");
			return null;
		}else {
			request.setAttribute("msg", "密码错误");
			
			return  "/site/index.jsp";
		}
	}
	
	
	public String stuLogout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.getSession().invalidate();
		
		response.sendRedirect(request.getContextPath()+"/site/index.jsp");
		return null;
	}
}
