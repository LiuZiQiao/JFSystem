package com.lxk.JFSystem.web.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.lxk.JFSystem.domain.Document;
import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.service.DocService;
import com.lxk.JFSystem.service.VedioService;
import com.lxk.JFSystem.utils.DownLoadUtils;
import com.lxk.JFSystem.utils.PageModel;
import com.lxk.JFSystem.web.base.BaseServlet;

public class VedioServlet extends BaseServlet{
			private static final  long serialVersionUID =1L;
			public String findPrevVedio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				//调用业务层功能，返回存储着vedio对象的集合
				VedioService vedioService = new VedioService();
				List list = vedioService.findPrevVedio();
				//将集合放入request域对象内
				request.setAttribute("list", list);
				//转发到/site/vedio/vedioPrev.jsp
//				return "/site/vedio/vedioPrev.jsp";
				response.sendRedirect(request.getContextPath()+"/site/vedio/vedioPrev.jsp");
				return null;
			}
			
			
			public String findVedioWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				//接收当前页参数
				int num=Integer.parseInt(request.getParameter("num"));
				//调用业务层功能，返回PageModel
				//	PageModel：分页查询，查询当前页中的视频信息，
				//   							还需要分页参数
				VedioService vedioService = new VedioService();
				PageModel pm = vedioService.findVedioWithPage(num);
				//将PageModel放入request域对象内
				request.setAttribute("page", pm);
			
				for (int i = 0; i <pm.getList().size(); i++) {
					System.out.println("i="+i+pm.getList().get(i));
				}
				//转发到/site/vedio/vedioAll.jsp
				return "/site/vedio/vedioAll.jsp";
			}
			public String findVedioByVid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
					String  vedioId = request.getParameter("id");
					VedioService vedioService = new VedioService();
					Vedio vedio = vedioService.findVedioByVid(vedioId);
					request.setAttribute("vedio", vedio);
					return "/site/vedio/vedioDetail.jsp";
			}

			
			public String playVedioById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				String  vedioId = request.getParameter("id");
				VedioService vedioService = new VedioService();
				Vedio  vedio = vedioService.findVedioByVid(vedioId);
					
				request.setAttribute("vedio", vedio);
				return "/play/playVedio.jsp";
		}
			
			public String DownDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				String  docId = request.getParameter("id");
				DocService docService = new DocService();
				Document  document = docService.findDocByVid(docId);
				//找到视频的绝对路径
				String realPath = getServletContext().getRealPath("/upload/");
				//实例一个file对象，表示下载的视频
				File file = new File(realPath,document.getDocAttachment());
				//通过response对象设置一对消息头
//				response.setHeader("Content-disposition", "attachment;filename="+vedio.getVedioAttachment());
				DownLoadUtils.setConentType(request, document.getDocAttachment(), response);
				//通过file获取输入流
				InputStream is = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				IOUtils.copy(is, os);
				IOUtils.closeQuietly(is);
				IOUtils.closeQuietly(os);
				return null;
			}
}
	
