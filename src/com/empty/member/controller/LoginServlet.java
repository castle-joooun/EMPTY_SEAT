package com.empty.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty.member.model.service.MemberService;
import com.empty.member.model.vo.Member;

@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("uname");
		String password = request.getParameter("psw");
		Member m = new MemberService().login(userId, password);
		System.out.println(m);
		String msg = "";
		
		if(m != null) {
			msg = "로그인 성공";
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", m);
			Cookie mem = new Cookie("loginMember", userId);
			mem.setMaxAge(7*24*60*60);
			response.addCookie(mem);
			String saveId = request.getParameter("saveId");
			System.out.println("saveId : " + saveId);
			if(saveId != null) {
				// 아이디를 쿠키에 저장하게함
				Cookie c = new Cookie("saveId", userId);
				//쿠키의 유효기간 설정
				c.setMaxAge(7*24*60*60);
				response.addCookie(c);
			}else {
				// 저장된 cookie값 지우고 check된것 해제
				Cookie c = new Cookie("saveId", userId);
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}else {
			msg = "로그인 실패";
		}
		
		request.setAttribute("msg", msg);
		String loc="/";
		request.setAttribute("loc",loc);
//		RequestDispatcher rs = request.getRequestDispatcher("/views/common/msg.jsp");
//		rs.forward(request, response);
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
