package com.lxk.JFSystem.domain;

public class Message {
	private int messageId;
	private String content;
	private String leaveWordTime;
	private int stuId;
	private String replay;
	private String replayTime;
	
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLeaveWordTime() {
		return leaveWordTime;
	}
	public void setLeaveWordTime(String leaveWordTime) {
		this.leaveWordTime = leaveWordTime;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getReplay() {
		return replay;
	}
	public void setReplay(String replay) {
		this.replay = replay;
	}
	public String getReplayTime() {
		return replayTime;
	}
	public void setReplayTime(String replayTime) {
		this.replayTime = replayTime;
	}
	
	
}
