package com.empty.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.member.mail.SHA256;
import com.empty.member.model.service.MemberService;
import com.empty.member.model.vo.Member;

@WebServlet("/checkEmailAuthentication")
public class CheckEmailAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckEmailAuthenticationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = null;
		if (request.getParameter("code") != null) {
			code = request.getParameter("code");
		}

		String userId = (String) request.getParameter("userId");
		String email = (String) request.getParameter("email");
		Member m = new MemberService().findId(email);

		String sha256 = SHA256.getSHA256(email);

		boolean isRight = (sha256.equals(code)) ? true : false;
		if(isRight == true) {


			RequestDispatcher rd = request.getRequestDispatcher("/views/member/findPwResult.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}