package com.lxk.JFSystem.domain;

public class Vedio {
	private int vedioId;  //视频编号
	private String vedioName;	//视频名称
	private String vedioPro;		//视频简介
	private String  vedioAttachment;	//视频附件名称
	private String  AttachmentOldName;		//视频附件的原始名称
	private String   uploadTime;		//视频上传时间
	private String del;	//视频是否删除
	
	public int getVedioId() {
		return vedioId;
	}

	public void setVedioId(int vedioId) {
		this.vedioId = vedioId;
	}

	public String getVedioName() {
		return vedioName;
	}

	public void setVedioName(String vedioName) {
		this.vedioName = vedioName;
	}

	public String getVedioPro() {
		return vedioPro;
	}

	public void setVedioPro(String vedioPro) {
		this.vedioPro = vedioPro;
	}

	public String getVedioAttachment() {
		return vedioAttachment;
	}

	public void setVedioAttachment(String vedioAttachment) {
		this.vedioAttachment = vedioAttachment;
	}

	public String getAttachmentOldName() {
		return AttachmentOldName;
	}

	public void setAttachmentOldName(String attachmentOldName) {
		AttachmentOldName = attachmentOldName;
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
		return "Vedio [vedioId=" + vedioId + ", vedioName=" + vedioName + ", vedioPro=" + vedioPro
				+ ", vedioAttachment=" + vedioAttachment + ", AttachmentOldName=" + AttachmentOldName + ", uploadTime="
				+ uploadTime + ", del=" + del + "]";
	}
	
	
}
