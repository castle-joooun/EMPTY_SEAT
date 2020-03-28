package com.empty.search.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.empty.search.model.vo.Store;
import com.empty.search.service.SearchService;
import com.google.gson.Gson;

/**
 * Servlet implementation class StroeFavoriteServlet
 */
@WebServlet("/favorite")
public class StoreFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreFavoriteServlet() {
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
		Store store = new SearchService().store(storeId);
		
		System.out.println("storeName은?? : " + store.getStoreName());
		
		// store_id, store_name, user_id, check(true, false) 다 있음!
		
		int result = 0;
//		
//		System.out.println("즐겨찾기 서블릿 userId : " + userId);
//		System.out.println("즐겨찾기 서블릿 storeId : "  + store.getStoreId());
//		System.out.println("즐겨찾기 서블릿 storeName : " + store.getStoreName());

		System.out.println("check : " + check);
		
		// 즐겨찾기 갯수 제한하기
		int favoriteSize = new SearchService().favoriteSize(userId);
		System.out.println("즐겨찾기 최대개수 : " + favoriteSize);
		
		if(favoriteSize>=6) {
			
			System.out.println("즐겨찾기 최대개수 도달 오류!");
			
		} else {
			
			if(check.equals("true")) {
				result = new SearchService().storeFavoriteInsert(userId, store.getStoreLogo(), storeId, store.getStoreName());
			} else if(check.equals("false")){
				result = new SearchService().storeFavoriteDelete(userId, storeId);
			}
			
			
			if(result>0) {
				System.out.println("즐겨찾기 추가/삭제 성공");
			} else {
				System.out.println("즐겨찾기 추가 실패");
			}
		}
		
		JSONObject jo = new JSONObject();
		jo.put("result", favoriteSize);
		new Gson().toJson(favoriteSize,response.getWriter());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
