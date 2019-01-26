package com.lxk.JFSystem.web.base;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseServlet extends HttpServlet {
	private static final long SerialVersionUID = 1;
	private Method method;
	private Object path;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String md = request.getParameter("method");
		String path = null;
		if (md != null) {
			Class  cla = this.getClass();
			
			try {
				 method = cla.getMethod(md, HttpServletRequest.class,HttpServletResponse.class);
				
				if (null != method) {
						path =(String) method.invoke(this,request,response);
						
						if (null != path) {
							request.getRequestDispatcher(path).forward(request, response);
						}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public String addStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		return "./success.jsp";
	}	
	
	public String delStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return null;
	}	

	public String updateStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return null;
	}	

	public String findStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return null;
	}

}
