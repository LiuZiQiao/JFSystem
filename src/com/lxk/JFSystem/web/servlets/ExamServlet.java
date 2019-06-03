package com.lxk.JFSystem.web.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.lxk.JFSystem.domain.Exam;
import com.lxk.JFSystem.service.ExamService;
import com.lxk.JFSystem.utils.DownLoadUtils;
import com.lxk.JFSystem.utils.PageModel;
import com.lxk.JFSystem.web.base.BaseServlet;


public class ExamServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	
	public String findPrevExam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//调用业务层功能，返回存储着exam对象的集合
		ExamService examService = new ExamService();
		List<Exam> list = examService.findPrevExam();
		//将集合放入request域对象内
		request.setAttribute("list", list);
		//转发到/site/timu/examPrev.jsp
		System.out.println("FindPreve:--------------");
		return "/site/timu/examPrev.jsp";
	}
	
	
	public String findExamWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//接收当前页参数
		int num=Integer.parseInt(request.getParameter("num"));
		//调用业务层功能，返回PageModel
		//	PageModel：分页查询，查询当前页中的视频信息，
		//   							还需要分页参数
		ExamService examService = new ExamService();
		PageModel pm = examService.findExamWithPage(num);
		//将PageModel放入request域对象内
		request.setAttribute("page", pm);
	
		for (int i = 0; i <pm.getList().size(); i++) {
			System.out.println("i="+i+pm.getList().get(i));
		}
		//转发到/site/timu/examAll.jsp
		return "/site/timu/examAll.jsp";
	}
	public String findExamByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String  t_examId = request.getParameter("id");
			ExamService examService = new ExamService();
			Exam exam = examService.findExamByid(t_examId);
			request.setAttribute("exam", exam);
			return "/site/timu/examDetail.jsp";
	}
	
	public String downloadExam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String  ExamId = request.getParameter("id");
		ExamService examService = new ExamService();
		Exam  exam = examService.findExamByid(ExamId);
		//找到文件的绝对路径
		String realPath = getServletContext().getRealPath("/upload/");
		//实例一个file对象，表示下载的资料
		File file = new File(realPath,exam.getExamAttachment());
		//通过response对象设置一对消息头
		response.setHeader("Content-disposition", "attachment;filename="+exam.getExamAttachment());
		
		//设置文件ContentType类型，这样设置，会自动判断下载文件类型  
		response.setContentType("multipart/form-data");
		
//		DownLoadUtils.setConentType(request, exam.getExamAttachment(), response);
		
		InputStream in = new FileInputStream(file);  
	       OutputStream out = response.getOutputStream();  
	         
	       //写文件  
	       int b;  
	       while((b=in.read())!= -1)  
	       {  
	           out.write(b);  
	       }  
	         
	       in.close();  
	       out.close();  
		
		//通过file获取输入流
//		InputStream is = new FileInputStream(file);
//		OutputStream os = response.getOutputStream();
//		IOUtils.copy(is, os);
//		IOUtils.closeQuietly(is);
//		IOUtils.closeQuietly(os);
		System.out.println("success download");
		return null;
	}


}
