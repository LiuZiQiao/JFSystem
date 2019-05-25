package com.lxk.JFSystem.domain;

import java.util.Date;

public class Document {
		
		private int docId;
		private String docName;
		private String docNameOrig;
		private String docNameTrue;
		private String uploadTime;
		private String docContext;
		private String docAttachment;
		
		
		public String getDocAttachment() {
			return docAttachment;
		}
		public void setDocAttachment(String docAttachment) {
			this.docAttachment = docAttachment;
		}
		public int getDocId() {
			return docId;
		}
		public void setDocId(int docId) {
			this.docId = docId;
		}
		public String getDocContext() {
			return docContext;
		}
		public void setDocContext(String docContext) {
			this.docContext = docContext;
		}
		public int getdocId() {
			return docId;
		}
		public void setdocId(int docId) {
			this.docId = docId;
		}
		public String getDocName() {
			return docName;
		}
		public void setDocName(String docName) {
			this.docName = docName;
		}
		public String getDocNameOrig() {
			return docNameOrig;
		}
		public void setDocNameOrig(String docNameOrig) {
			this.docNameOrig = docNameOrig;
		}
		public String getDocNameTrue() {
			return docNameTrue;
		}
		public void setDocNameTrue(String docNameTrue) {
			this.docNameTrue = docNameTrue;
		}
		public String getUploadTime() {
			return uploadTime;
		}
		public void setUploadTime(String uploadTime) {
			this.uploadTime = uploadTime;
		}
		@Override
		public String toString() {
			return "Document [docId=" + docId + ", docName=" + docName + ", docNameOrig=" + docNameOrig
					+ ", docNameTrue=" + docNameTrue + ", uploadTime=" + uploadTime + ", docContext=" + docContext
					+ ", getDocId()=" + getDocId() + ", getDocContext()=" + getDocContext() + ", getdocId()="
					+ getdocId() + ", getDocName()=" + getDocName() + ", getDocNameOrig()=" + getDocNameOrig()
					+ ", getDocNameTrue()=" + getDocNameTrue() + ", getUploadTime()=" + getUploadTime()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}

		
		
}
