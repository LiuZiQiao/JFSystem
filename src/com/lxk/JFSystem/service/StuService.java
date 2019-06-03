package com.lxk.JFSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.lxk.JFSystem.dao.StuDao;
import com.lxk.JFSystem.dao.VedioDao;
import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.utils.PageModel;

public class StuService {
	
	
	public Student checkUserExist(String um) throws SQLException {
		StuDao stuDao = new StuDao();
		return stuDao.checkUserExist(um);
	}

	public Student stuLogin(String um, String up) throws SQLException {
		StuDao stuDao = new StuDao();
		return stuDao.stuLogin(um, up);
	}
	
	public PageModel findStudentWithPage(int currentPage) throws SQLException {
		StuDao stuDao = new StuDao();
		int totalRecords = stuDao.findTotalStudent();
		PageModel pageModel = new PageModel(currentPage, totalRecords, 5);

		List<Student> list=stuDao.findMessageWithPage(pageModel.getStartIndex(),pageModel.getPageSize());
		
		pageModel.setList(list);
		pageModel.setUrl("StuServlet?method=findStudentWithPage");
		return pageModel;
	}
	public PageModel delStudentById(int currentPage,String id) throws SQLException {
		StuDao stuDao = new StuDao();
		stuDao.delStudentById(id);
		int totalRecords = stuDao.findTotalStudent();
		PageModel pageModel = new PageModel(currentPage, totalRecords, 5);

		List<Student> list=stuDao.findMessageWithPage(pageModel.getStartIndex(),pageModel.getPageSize());
		
		pageModel.setList(list);
		pageModel.setUrl("StuServlet?method=findStudentWithPage");
		return pageModel;
	}
	public PageModel addStudent(int currentPage,Student student) throws SQLException {
		StuDao stuDao = new StuDao();
		stuDao.addStudent(student);
		
		int totalRecords = stuDao.findTotalStudent();
		PageModel pageModel = new PageModel(currentPage, totalRecords, 5);

		List<Student> list=stuDao.findMessageWithPage(pageModel.getStartIndex(),pageModel.getPageSize());
		
		pageModel.setList(list);
		pageModel.setUrl("StuServlet?method=findStudentWithPage");
		return pageModel;
	}
	public PageModel findVedioWithPage(int  num) throws SQLException {
		VedioDao vedioDao = new VedioDao();
		int totalRecords = vedioDao.findTotalRecords();
		PageModel pm=new PageModel(num, totalRecords, 5);
		
		//查询当前页中视频信息 
		List<Vedio> list = vedioDao.findVedioWithPage((num-1)*5,5);
		System.out.println("service"+list);
		pm.setList(list);
		pm.setUrl("StuServlet?method=findVedioWithPage");
		return  pm;
	}
}
