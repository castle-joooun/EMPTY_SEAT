package com.empty.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.admin.model.service.AdminService;

/**
 * Servlet implementation class RequestStoreListApprServlet
 */
@WebServlet("/admin/store/requestStoreListAppr")
public class RequestStoreListApprServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestStoreListApprServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ids = request.getParameter("userid");
		String [] userid = ids.split(", ");
		for(String s : userid) {
			System.out.println("아이디: "+s);
		}
		int result = new AdminService().updateAppr(userid);
		
		request.setAttribute("msg", result+"개의 스토어가 승인처리 되었습니다.");
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
