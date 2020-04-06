package com.empty.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.notice.model.vo.Notice;
import com.empty.notice.service.NoticeService;

@WebServlet("/noticeWriteEnd")
public class NoticeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWriteEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(title);
		System.out.println(content);
		Notice n = new Notice(0, title, null, content, null, 0);
		
		int result = new NoticeService().insertNotice(n);
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "공지사항 등록 완료";
			loc = "/notice";
		}else {
			msg = "공지사항 등록 실패";
			loc = "/notice";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
