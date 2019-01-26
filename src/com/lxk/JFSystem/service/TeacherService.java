package com.lxk.JFSystem.service;

import java.sql.SQLException;

import com.lxk.JFSystem.dao.TeacherDao;
import com.lxk.JFSystem.domain.Teacher;

public class TeacherService {

	public Teacher teaLogin(String um, String up) throws SQLException {
		TeacherDao teacherdao = new TeacherDao();
		return teacherdao.teaLogin(um,up);
	}

}
