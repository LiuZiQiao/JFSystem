package com.lxk.JFSystem.service;

import java.sql.SQLException;

import com.lxk.JFSystem.dao.AdminDao;
import com.lxk.JFSystem.domain.Admin;

public class AdminService {

	public Admin adminLogin(String um, String up) throws SQLException {
		AdminDao adminDao = new AdminDao();
		return adminDao.adminLogin(um, up);
	}

}
