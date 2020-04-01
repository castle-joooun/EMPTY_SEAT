package com.empty.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.search.service.SearchService;
import com.google.gson.Gson;

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
		System.out.println(keyword);
		System.out.println(cPage);
		System.out.println(numPerPage);
		List list = new SearchService().totalSearch(keyword,cPage,numPerPage);
		int totalData = new SearchService().dataCount(keyword);
		int totalPage = (int)Math.ceil((double)totalData/numPerPage);
		String pageBar = "";
		if(list.size()>0) {
			
			if(cPage<totalPage) {
				pageBar ="<div class='btnContainer'>" + 
						"<button name='moreSearch' type='button' onclick='requestData(\""+keyword+"\","+(++cPage)+","+numPerPage+");'><img src='/EMPTY/image/underArrow.png' style='cursor: pointer;'> &nbsp;&nbsp;검색결과 더보기( "+ (cPage-1)*numPerPage+" / "+totalData+" )</button>" + 
						"</div>";
			}
			list.add(pageBar);
			list.add(totalData);
		}else {
			pageBar="검색결과가 없습니다.";
			list.add(pageBar);
		}
		response.setContentType("application/json;charset=UTF-8");
		new Gson().toJson(list,response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
