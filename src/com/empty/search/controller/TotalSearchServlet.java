package com.empty.search.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.search.model.vo.Store;
import com.empty.search.service.SearchService;

/**
 * Servlet implementation class MainSearchServlet
 */
@WebServlet("/totalSearch")
public class TotalSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String searchBox = request.getParameter("searchBox");
		List<Store> list = null;
		
		/* 검색어가 비어있으면 안넘기는거 연구하기
		 * if(searchBox.equals("") && searchBox==null) {
		 * request.getRequestDispatcher("/noneSearch.jsp").forward(request, response); }
		 */
		
		
		try {
			list = new SearchService().totalSearch(searchBox);
		} catch(NullPointerException e) {
			request.getRequestDispatcher("/noneSearch.jsp").forward(request, response);
		}
		
		System.out.println("서블릿 " + list);

		request.setAttribute("list", list);
		request.setAttribute("searchText", searchBox);
		request.getRequestDispatcher("/totalSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
