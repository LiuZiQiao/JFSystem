package com.lxk.JFSystem.domain;

public class Exam {

	private int examId;
	private String examName;
	private String examPro;
	private String examAttachment;
	private String uploadTime;
	private String del;
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamPro() {
		return examPro;
	}
	public void setExamPro(String examPro) {
		this.examPro = examPro;
	}
	public String getExamAttachment() {
		return examAttachment;
	}
	public void setExamAttachment(String examAttachment) {
		this.examAttachment = examAttachment;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", examPro=" + examPro + ", examAttachment="
				+ examAttachment + ", uploadTime=" + uploadTime + ", del=" + del + "]";
	}
	
	
}
