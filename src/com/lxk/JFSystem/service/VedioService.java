package com.lxk.JFSystem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lxk.JFSystem.dao.StuDao;
import com.lxk.JFSystem.dao.VedioDao;
import com.lxk.JFSystem.domain.Student;
import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.utils.PageModel;

public class VedioService {

	public List<Vedio> findPrevVedio() throws SQLException {
		VedioDao vedioDao = new VedioDao();
		return  vedioDao.findPrevVedio();
	}

	public PageModel findVedioWithPage(int  num) throws SQLException {
		VedioDao vedioDao = new VedioDao();
		int totalRecords = vedioDao.findTotalRecords();
		PageModel pm=new PageModel(num, totalRecords, 5);
		
		//查询当前页中视频信息 
		List<Vedio> list = vedioDao.findVedioWithPage((num-1)*5,5);
		
		pm.setList(list);
		pm.setUrl("VedioServlet?method=findVedioWithPage");
		return  pm;
	}

	public Vedio findVedioByVid(String vedioId) throws SQLException {
		VedioDao vedioDao = new VedioDao();
		return vedioDao.findVedioByVid(vedioId);
	}

	public int uploadVedio(Vedio vedio) throws SQLException {
		VedioDao vedioDao = new VedioDao();
		return vedioDao.uploadVedio(vedio);
	}
	
	public PageModel delVedioById(int currentPage,String id) throws SQLException {
		VedioDao vedioDao = new VedioDao();
		vedioDao.delVedioById(id);
		int totalRecords = vedioDao.findTotalRecords();
		PageModel pageModel = new PageModel(currentPage, totalRecords, 5);

		List<Vedio> list=vedioDao.findVedioWithPage(pageModel.getStartIndex(),pageModel.getPageSize());
		
		pageModel.setList(list);
		pageModel.setUrl("StuServlet?method=findVedioWithPage");
		return pageModel;
	}
}
