package com.lxk.JFSystem.service;

import java.sql.SQLException;

import com.lxk.JFSystem.dao.StuDao;
import com.lxk.JFSystem.domain.Student;

public class StuService {
	
	
	public Student checkUserExist(String um) throws SQLException {
		StuDao stuDao = new StuDao();
		return stuDao.checkUserExist(um);
	}

	public Student stuLogin(String um, String up) throws SQLException {
		StuDao stuDao = new StuDao();
		return stuDao.stuLogin(um, up);
	}

}
