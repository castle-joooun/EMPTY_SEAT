package com.empty.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.admin.model.service.AdminService;

/**
 * Servlet implementation class RequestStoreApprServlet
 */
@WebServlet("/admin/store/requestAppr")
public class RequestStoreApprServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestStoreApprServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		int result = new AdminService().updateAppr(userId);
		if(result>0) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");
		}
		request.setAttribute("msg", userId+" 유저의 스토어 승인이 완료되었습니다.");
		request.setAttribute("loc", "/admin/store/requestStoreList");
		request.setAttribute("locstr", "목록으로");
		request.getRequestDispatcher("/views/admincommon/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
