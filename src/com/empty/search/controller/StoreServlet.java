package com.empty.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.comment.model.service.CommentService;
import com.empty.comment.model.vo.Comment;
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
	//댓글 페이징	
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
			
		}catch(NumberFormatException e) {
			cPage=1;
		}
		int numPerPage=5;
		List<Comment> commentList= new CommentService().selectComment();
		List<Comment> list = new CommentService().searchComment(cPage,numPerPage);
		int totalStore=new CommentService().commentCount();
		int totalPage=(int)Math.ceil((double)totalStore/numPerPage);
		
		//페이지 바 만들기 
		
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		String pageBar="";
		
		if(pageNo==1) {
		 	pageBar+="<span>[이전]</span>";
		 	
	}else {
		pageBar+="<a href='"+request.getContextPath()+"/store?cPage="+(pageNo-1)+"'>[이전]</a>";
				
	}
	
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
					pageBar+="<a href='"+request.getContextPath()+"/store?cPage="+(pageNo)+"'>"+pageNo+"</a>";
					
			}
			pageNo++;
		}
		
		//다음
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/store?cPage="+(pageNo)+"'>[다음]</a>";
		}
		request.setAttribute("commentList", commentList);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("list", list);
		
//댓글 페이징	
		String storeId = request.getParameter("storeId");
		String userId = request.getParameter("userId");
		System.out.println("storeId : " + storeId);
		Store store = new SearchService().store(storeId);
		String searchText = request.getParameter("searchText");
		
		// getParameter로 받는거 3개.
		// storeId, userId, searchText
	    
		List<String> imgs = new SearchService().storeImgs(storeId);
		System.out.println("imgs : " + imgs);
		
		StoreSeat ss = new SearchService().storeSeat(storeId);
		System.out.println("storeSeat : " + ss);
		
		// 즐겨찾기 되어 있는지 확인
		String favoriteUrl = new SearchService().storeFavoriteCheck(userId, storeId);
		if(favoriteUrl.equals("image/favorite-use.png")) {
			System.out.println("해당 스토어에 즐겨찾기 등록되어 있음");			
		} else {
			System.out.println("해당 스토어에 즐겨찾기 등록되어 있지 않음");		
		}
		
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
