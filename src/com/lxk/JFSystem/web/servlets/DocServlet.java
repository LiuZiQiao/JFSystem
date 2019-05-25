package com.lxk.JFSystem.web.servlets;

import com.lxk.JFSystem.domain.Document;
import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.service.DocService;
import com.lxk.JFSystem.service.VedioService;
import com.lxk.JFSystem.utils.DownLoadUtils;
import com.lxk.JFSystem.utils.PageModel;
import com.lxk.JFSystem.web.base.BaseServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class DocServlet extends BaseServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public String findPrevDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//调用业务层功能，返回存储着Doc对象的集合
		DocService docService = new DocService();
		List<Document> list = docService.findPrevDoc();
		//将集合放入request域对象内
		request.setAttribute("list", list);
		return "/site/doc/docPrev.jsp";
	}
	
	
	public String findDocWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//接收当前页参数
		int num=Integer.parseInt(request.getParameter("num"));
		//调用业务层功能，返回PageModel
		//	PageModel：分页查询，查询当前页中的视频信息，
		//   							还需要分页参数
		DocService DocService = new DocService();
		PageModel pm = DocService.findDocWithPage(num);
		//将PageModel放入request域对象内
		request.setAttribute("page", pm);
	
		for (int i = 0; i <pm.getList().size(); i++) {
			System.out.println("i="+i+pm.getList().get(i));
		}
		//转发到/site/Doc/DocAll.jsp
		return "/site/doc/docAll.jsp";
	}
	public String findDocByVid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String  DocId = request.getParameter("id");
			System.out.println("DocServlet.findDocByVid():"+DocId);
			DocService DocService = new DocService();
			Document doc = DocService.findDocByVid(DocId);
			request.setAttribute("doc", doc);
			System.out.println("DocServlet.findDocByVid():"+doc);
			return "/site/doc/docDetail.jsp";
	}
	public String ViewContext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String  DocId = request.getParameter("id");
		DocService DocService = new DocService();
		Document doc = DocService.findDocByVid(DocId);
		System.out.println("DocServlet.ViewContext():"+doc);
		request.setAttribute("doc", doc);
		return "/site/doc/docView.jsp";
	}
	
	
	public String downloadDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String  vedioId = request.getParameter("id");
		VedioService vedioService = new VedioService();
		Vedio  vedio = vedioService.findVedioByVid(vedioId);
		//找到视频的绝对路径
		String realPath = getServletContext().getRealPath("/upload/");
		//实例一个file对象，表示下载的视频
		File file = new File(realPath,vedio.getVedioAttachment());
		//通过response对象设置一对消息头
//		response.setHeader("Content-disposition", "attachment;filename="+vedio.getVedioAttachment());
		DownLoadUtils.setConentType(request, vedio.getVedioAttachment(), response);
		//通过file获取输入流
		InputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		IOUtils.copy(is, os);
		IOUtils.closeQuietly(is);
		IOUtils.closeQuietly(os);
		return null;
	}
}
