package com.lxk.JFSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.lxk.JFSystem.dao.TeacherDao;
import com.lxk.JFSystem.domain.Teacher;
import com.lxk.JFSystem.utils.PageModel;

public class TeacherService {

	public Teacher teaLogin(String um, String up) throws SQLException {
		TeacherDao teacherdao = new TeacherDao();
		return teacherdao.teaLogin(um,up);
	}

	public PageModel findTeacherWithPage(int currentPage) throws SQLException {
		TeacherDao teacherDao = new TeacherDao();
		int totalRecords = teacherDao.findTotalTeacher();
		PageModel pageModel = new PageModel(currentPage, totalRecords, 5);

		List<Teacher> list=teacherDao.findMessageWithPage(pageModel.getStartIndex(),pageModel.getPageSize());
		
		pageModel.setList(list);
		pageModel.setUrl("TeacherServlet?method=findTeacherWithPage");
		return pageModel;
	}

}
