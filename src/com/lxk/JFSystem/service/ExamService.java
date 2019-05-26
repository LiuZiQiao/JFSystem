package com.lxk.JFSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.lxk.JFSystem.dao.ExamDao;
import com.lxk.JFSystem.domain.Exam;
import com.lxk.JFSystem.utils.PageModel;

public class ExamService {
	public List<Exam> findPrevExam() throws SQLException {
		ExamDao examDao = new ExamDao();
		return  examDao.findPrevExam();
	}

	public PageModel findExamWithPage(int  num) throws SQLException {
		ExamDao examDao = new ExamDao();
		int totalRecords = examDao.findTotalRecords();
		PageModel pm=new PageModel(num, totalRecords, 5);
		
		//查询当前页中视频信息 
		List<Exam> list = examDao.findExamWithPage((num-1)*5,5);
		
		pm.setList(list);
		pm.setUrl("ExamServlet?method=findExamWithPage");
		return  pm;
	}

	public Exam findExamByid(String t_examId) throws SQLException {
		ExamDao examDao = new ExamDao();
		return examDao.findExamByid(t_examId);
	}
}
