package com.empty.FAQ.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.FAQ.model.vo.FAQ;
import com.empty.FAQ.service.FAQService;

/**
 * Servlet implementation class FAQWriteEndServlet
 */
@WebServlet("/FAQwriteEnd")
public class FAQWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		FAQ f=new FAQ(0,title,content,null,0);

		
		
		int result=new FAQService().insertFAQ(f);
		String msg="";//사용자에게 띄울 메세지 내용
		String loc="";//메세지 띄운 후 이동할 페이지
		if(result>0) {
			msg="업로드를 성공하였습니다.";
			loc="/FAQMainServlet";
		}else {
			msg="업로드를 실패하였습니다.";
			loc="/FAQwrite";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
