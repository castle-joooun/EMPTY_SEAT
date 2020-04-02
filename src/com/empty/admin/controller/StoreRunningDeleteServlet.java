package com.empty.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.admin.model.service.AdminService;

/**
 * Servlet implementation class StoreRunningDeleteServlet
 */
@WebServlet("/admin/store/deleteStore")
public class StoreRunningDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreRunningDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("userId");
		int result = new AdminService().deleteStore(id);
		
		if(result>0) {
			request.setAttribute("msg",id+"의 스토어가 삭제되었습니다.");
			
		}else {
			request.setAttribute("msg", id+"의 스토어 삭제에 실패하였습니다.");
		}
		request.setAttribute("loc", "/admin/manageStore");
		request.getRequestDispatcher("/views/admincommon/alert.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
