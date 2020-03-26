package com.empty.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.search.model.vo.Store;
import com.empty.search.model.vo.StoreSeat;
import com.empty.search.service.SearchService;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/store")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String id = request.getParameter("storeId");
		System.out.println("id : " + id);
		Store store = new SearchService().store(id);
		String searchText = request.getParameter("searchText");
	    
		List<String> imgs = new SearchService().storeImgs(id);
		System.out.println("imgs : " + imgs);
		
		StoreSeat ss = new SearchService().storeSeat(id);
		System.out.println("storeSeat : " + ss);
		
		// 즐겨찾기 되어 있는지 확인
		String favoriteUrl = new SearchService().storeFavoriteCheck(id, store.getStoreId());
		
		if (store != null && ss != null) {
			System.out.println("스토어 " + store);
			request.setAttribute("store", store);
			request.setAttribute("imgs", imgs);
			request.setAttribute("storeSeat", ss);
			request.setAttribute("searchText", searchText);
			request.setAttribute("url", favoriteUrl);
			request.getRequestDispatcher("/views/search/store.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/search/noneSearch.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
