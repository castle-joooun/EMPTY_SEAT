package com.empty.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.member.model.service.MemberService;
import com.empty.member.model.vo.Member;

@WebServlet(name = "FindPwServlet", urlPatterns = "/findPw")
public class FindPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindPwServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		Member m = new MemberService().findPw(userId, email);
		if(m != null) {
			request.setAttribute("userId", m.getUserId());
		}
		RequestDispatcher rd = request.getRequestDispatcher("views/member/findPwResult.jsp");
		rd.forward(request, response);
		System.out.println(m);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
