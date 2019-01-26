package com.lxk.JFSystem.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class DownLoadUtils {
	public static String base64EncodeFileName(String filename) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
				return "=?UTF-8?B?"+new String(base64Encoder.encode(filename.getBytes("UTF-8")))+"?=";
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException();
		}
	
	}
	public static void setConentType(HttpServletRequest request, String filename, HttpServletResponse response)throws UnsupportedEncodingException {
		String agent = request.getHeader("User-Agent");
		if (agent.contains("Firefox")) {
			filename=DownLoadUtils.base64EncodeFileName(filename);
		}
		response.setHeader("Content-disposition", "attachment;filename"+filename);
	}
	
}
