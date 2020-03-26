package com.empty.search.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.search.service.SearchService;

/**
 * Servlet implementation class StroeFavoriteServlet
 */
@WebServlet("/favorite")
public class StroeFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StroeFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String check = request.getParameter("check");
		String userId = request.getParameter("userId");
		String storeId = request.getParameter("storeId");
		
		int result = 0;

		if(check.equals("true")) {
			result = new SearchService().storeFavoriteInsert(userId, storeId);
		} else if(check.equals("false")){
			result = new SearchService().storeFavoriteDelete(userId, storeId);
		}
		
		if(result>0) {
			System.out.println("즐겨찾기 추가/삭제 성공");
		} else {
			System.out.println("즐겨찾기 추가 실패");
		}
		
		request.setAttribute("result", result);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
