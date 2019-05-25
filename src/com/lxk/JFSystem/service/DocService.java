package com.lxk.JFSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.lxk.JFSystem.dao.DocumentDao;
import com.lxk.JFSystem.dao.VedioDao;
import com.lxk.JFSystem.domain.Document;
import com.lxk.JFSystem.domain.Vedio;
import com.lxk.JFSystem.utils.PageModel;

public class DocService {
	public List<Document> findPrevDoc() throws SQLException {
		DocumentDao docDao = new DocumentDao();
		List<Document> list = docDao.findPrevDoc();
		return  list;
	}

	public PageModel findDocWithPage(int  num) throws SQLException {
		DocumentDao documentDao = new DocumentDao();
		int totalRecords = documentDao.findTotalRecords();
		PageModel pm=new PageModel(num, totalRecords, 5);
		
		//查询当前页中视频信息 
		List<Document> list = documentDao.findDocWithPage((num-1)*5,5);
		
		pm.setList(list);
		pm.setUrl("DocServlet?method=findDocWithPage");
		return  pm;
	}

	public Document findDocByVid(String docId) throws SQLException {
		DocumentDao documentDao = new DocumentDao();
		return documentDao.findDocByVid(docId);
	}
}
