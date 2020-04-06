package com.empty.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.event.service.EventService;

@WebServlet("/event/eventUpdateEnd")
public class EventUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventUpdateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int result = new EventService().updateEvent(no, title, content);
		
		String msg = "";//사용자에게 띄울 메세지 내용

		if(result > 0) {
			msg = "게시물을 수정하였습니다.";
		}else {
			msg = "게시물 수정에 실패하였습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/event");
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
