package com.empty.common.filter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
	
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value="";
		if(name!=null && (name.equals("psw"))||(name.equals("password"))) {
			value = getSha512(super.getParameter(name));
		}else {
			value=super.getParameter(name);
		}
		return value;
	}
	
	private String getSha512(String psw) {
		String encPw = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] bytes = psw.getBytes(Charset.forName("UTF-8"));
		md.update(bytes);
		encPw = Base64.getEncoder().encodeToString(md.digest());
		return encPw;
	}
	
	

}
