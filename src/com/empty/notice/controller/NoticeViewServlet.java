package com.empty.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.notice.model.vo.Notice;
import com.empty.notice.service.NoticeService;

@WebServlet("/notice/noticeView")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		Cookie[] cookies = request.getCookies();
		String cookieVal = "";
		boolean hasRead = false;
		if(cookies != null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				if("NoticeCookie".equals(name)) {
					cookieVal = value;
					if(value.contains("|" + no + "|")) {
						hasRead = true;
						break;
					}
				}
			}
		}
		
		if(!hasRead) {
			Cookie c = new Cookie("NoticeCookie",cookieVal + "|" + no + "|");
			c.setMaxAge(-1);
			response.addCookie(c);
		}
		
		Notice n = new NoticeService().selectNotice(no,hasRead);
		request.setAttribute("Notice", n);
		
		
		request.getRequestDispatcher("/views/notice/noticeView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
