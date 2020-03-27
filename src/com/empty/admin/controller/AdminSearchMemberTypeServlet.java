package com.empty.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.admin.model.service.AdminService;
import com.empty.member.model.vo.Member;

/**
 * Servlet implementation class AdminSearchMemberTypeServlet
 */
@WebServlet("/admin/searchMemberType")
public class AdminSearchMemberTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchMemberTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("searchType");//검색 타입 , userName, gender,phone
		String keyword = request.getParameter("searchKeyword");//검색 키워드 
		System.out.println(type);
		System.out.println(keyword);
		//페이징 처리 
		int cPage;
		try{
			cPage= Integer.parseInt(request.getParameter("cPage"));//현재 페이지
		}catch(NumberFormatException e) {
			cPage=1;
		}
		int numPerPage ;
		try{
			numPerPage= Integer.parseInt(request.getParameter("numPerPage"));//페이지당 게시글 수 
		}catch(NumberFormatException e) {
			numPerPage=10;
		}
		
		List <Member> list = new AdminService().selectMember(type,keyword,cPage,numPerPage);
		
		int totalMember = new AdminService().memberCount(type,keyword);
		int totalPage = (int)Math.ceil((double)totalMember/numPerPage);
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
