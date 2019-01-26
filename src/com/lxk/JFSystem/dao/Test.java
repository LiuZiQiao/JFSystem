package com.lxk.JFSystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.lxk.JFSystem.domain.Teacher;
import com.lxk.JFSystem.domain.Vedio;

public class Test {

	public static void main(String[] args) {
		
		TeacherDao  teacherDao = new TeacherDao();
		try {
			Teacher teacher = teacherDao.teaLogin("lxk", "123456");
			System.out.println( teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		VedioDao vedioDao = new  VedioDao();
//		try {
//			List<Vedio> list  = vedioDao.findPrevVedio();
//			for (int i=0;i<list.size();i++) {
//				System.out.println(list.get(i));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
