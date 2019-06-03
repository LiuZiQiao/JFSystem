package com.lxk.JFSystem.web.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.lxk.JFSystem.domain.Document;
import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.service.DocService;
import com.lxk.JFSystem.service.StuService;
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
				return "/site/vedio/vedioPrev.jsp";
//				response.sendRedirect(request.getContextPath()+"/site/vedio/vedioPrev.jsp");
//				return null;
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
				System.out.println("playvedio"+vedio);
				request.setAttribute("vedio", vedio.getVedioAttachment());
//				response.sendRedirect(request.getContextPath()+"/play/playVedio.jsp");
				System.out.println("response");
				return "/play/playVedio.jsp";
			}
			public String downloadVedio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				String  vedioId = request.getParameter("id");
				VedioService vedioService= new VedioService();
				Vedio  vedio= vedioService.findVedioByVid(vedioId);
				//找到视频的绝对路径
				String realPath = getServletContext().getRealPath("/upload/");
				//实例一个file对象，表示下载的视频
				File file = new File(realPath,vedio.getVedioAttachment());
				//通过response对象设置一对消息头
				response.setHeader("Content-disposition", "attachment;filename="+vedio.getVedioAttachment());
				response.setContentType("multipart/form-data");
				//				DownLoadUtils.setConentType(request, vedio.getAttachmentOldName(), response);
				
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
			       
//				//通过file获取输入流
//				InputStream is = new FileInputStream(file);
//				OutputStream os = response.getOutputStream();
//				IOUtils.copy(is, os);
//				IOUtils.closeQuietly(is);
//				IOUtils.closeQuietly(os);
				return null;
			}

			
			public String uploadVedio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				
				String savePath=getServletContext().getRealPath("/upload");
				File file = new File(savePath);
				System.out.println(savePath+"目录不存在..，需要创建");
				if (!file.exists() && !file.isDirectory()) {
					System.out.println(savePath+"目录不存在，需要创建");
					file.mkdir();
				}
				
				String message ="";
				try {
					//使用Apache文件上传组件处理文件上传步骤：
					DiskFileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(factory);
					upload.setHeaderEncoding("UTF-8");//防止上传文件名的中文乱码
					if (!ServletFileUpload.isMultipartContent(request)) {
						return  null;
					}
					
					/*
					 * 使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List集合，每一个FileItem对应一个form表单的输入项
					 */
					List<FileItem> list = upload.parseRequest(request);
					List<String>  filenamelist = new ArrayList<>();
					String filename = null; //文件上传是的名字
					//遍历表单
					for (FileItem item : list) {
						if (item.isFormField()) {
							String name = item.getFieldName();
							String value = item.getString("UTF-8");
							filenamelist.add(value);
						}else{	//如果fileitme 中封装的是上传文件，拿到上传文件名
							filename = item.getName();
							System.out.println(filename);
							if (filename ==null || filename.trim().equals("")) {
								continue;
							}
							
							filename = filename.substring(filename.lastIndexOf("\\")+1);
							InputStream in = item.getInputStream();
							FileOutputStream out = new FileOutputStream(savePath+"\\"+filename);
							byte buffer[] = new byte[1024];
							int len = 0;
							
		
							
							while((len = in.read(buffer))>0){
								out.write(buffer,0,len);
							}
							in.close();
							out.close();
							item.delete();
							message = "文件上传成功";
							}
						}
					
					
					//数据库插入视频信息
					System.out.println("filenamelist"+filenamelist);
					String vedioName = filenamelist.get(0);
					String vedioPro =filenamelist.get(1);
					String attachmentOldName = filenamelist.get(2);
					String attachmentName = filename;
					Vedio vedio = new Vedio();
					vedio.setVedioName(vedioName);
					vedio.setVedioPro(vedioPro);
					
					String update = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,   Locale.CHINESE).format(new java.util.Date());
					vedio.setUploadTime(update);
					vedio.setVedioAttachment(filename);
					vedio.setAttachmentOldName(attachmentName);
					vedio.setDel("no");
					VedioService vedioService = new VedioService();
					
					vedioService.uploadVedio(vedio);
					
					System.out.println(vedio);

				} catch (Exception e) {
					message = "文件上传失败";
					e.printStackTrace();
				}
				response.getWriter().write("<script language=javascript>alert('上传成功');</script>");
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
			public String delVedioById(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
				String vedioId = request.getParameter("vedioId");
				int currentPage = Integer.parseInt(request.getParameter("num"));
				
				VedioService ms = new VedioService();
				PageModel pageModel = ms.delVedioById(currentPage,vedioId);
				
				request.setAttribute("page",pageModel);
				return "/atea/vedioMana.jsp";
			}
			
}
	
