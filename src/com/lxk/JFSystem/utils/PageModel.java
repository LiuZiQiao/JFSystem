package com.lxk.JFSystem.utils;

import java.util.List;

public class PageModel {
	//1.分页视频集合
	private List list;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	//分页参数
	
	private int currentPageNum;  //当前页
	private int pageSize;			//每页条数
	private int totalPageNum;	//总页数
	private int prevPageNum;	// 上一页
	private int nextPageNum;	//下一页
	private int startIndex;		//起始索引，参数num
	private int totalRecords;  //总记录
	
	private int startPage; //分页的起始页码，每页存放9个页码
	private int endPage;	//分页的结束页码
	
	private String url;
	
	
	
	public PageModel(int currentPageNum,  int totalRecords,int pageSize) {
		this.currentPageNum = currentPageNum;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
		
		totalPageNum = (totalRecords % pageSize == 0)?(totalRecords / pageSize):(totalRecords / pageSize+1);
		startIndex =(currentPageNum-1)*pageSize;
		
		prevPageNum=currentPageNum-1;
		if(currentPageNum <=1)
		{
			prevPageNum = 1;
		}
		
		nextPageNum = currentPageNum+1;
		if (currentPageNum == totalPageNum) {
			nextPageNum = totalPageNum;
		}
		
		startPage = currentPageNum-4;
		endPage = currentPageNum+4;
		if (totalPageNum <= 9) {
			startPage = 1;
			endPage = totalPageNum;
		}else {
			if (startPage <1) {
				startPage = 1;
				endPage=startPage+8;
			}
			
			if (endPage > totalPageNum) {
				endPage=totalPageNum;
				startPage = totalPageNum-8;
			}
		}
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getPrevPageNum() {
		return prevPageNum;
	}

	public void setPrevPageNum(int prevPageNum) {
		this.prevPageNum = prevPageNum;
	}

	public int getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
