package com.empty.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.notice.service.NoticeService;

@WebServlet("/notice/noticeDelete")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		int result = new NoticeService().deleteNotice(no);
		
		String msg = "";
		
		if(result > 0) {
			msg = "공지사항을 삭제하였습니다.";
		}else {
			msg = "공지사항 삭제에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/notice");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
