package com.empty.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.search.service.SearchService;

/**
 * Servlet implementation class TotalSearchAjaxPagingServlet
 */
@WebServlet("/totalSearch/ajaxPaging")
public class TotalSearchAjaxPagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalSearchAjaxPagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cPage=Integer.parseInt(request.getParameter("cPage"));
		int numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		String keyword = request.getParameter("keyword");
		
		List list = new SearchService().totalSearch(keyword,cPage,numPerPage);
		int totalData = new SearchService().dataCount(keyword);
		String pageBar = "";
		if(list.size()>0) {
			
		}else {
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
