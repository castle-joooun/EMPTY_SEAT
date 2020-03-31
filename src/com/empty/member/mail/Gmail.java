package com.empty.member.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("qkrejrgus4713@gmail.com", "ejrgus4512+-");
	}
}
