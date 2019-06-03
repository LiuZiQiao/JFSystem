package com.lxk.JFSystem.web.servlets;

import com.lxk.JFSystem.domain.Admin;
import com.lxk.JFSystem.service.AdminService;
import com.lxk.JFSystem.web.base.BaseServlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String  adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
	{
		String um = request.getParameter("userName");
		String up = request.getParameter("userPw");
		System.out.println(um+":"+up);
		AdminService aService = new AdminService();
		Admin admin = aService.adminLogin(um,up);
		System.out.println(admin);
		if (admin == null) {
			request.setAttribute("msg","账户密码错误");
			return "/login.jsp";
		}else {
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect(request.getContextPath()+"/admin/adminIndex.jsp");
			return null;
		}
	}
	
	public String  adminLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
	{
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return null;
	}
}
