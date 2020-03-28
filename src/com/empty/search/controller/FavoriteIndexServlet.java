package com.empty.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.empty.search.service.SearchService;
import com.google.gson.Gson;

/**
 * Servlet implementation class FavoriteIndexServlet
 */
@WebServlet("/index/favorite")
public class FavoriteIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavoriteIndexServlet() {
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

		String userId = request.getParameter("userId");
		System.out.println("즐겨찾기 인덱스 id : " + userId);

		List ftList = new SearchService().favoriteIndex(userId);
		System.out.println("ftList : " + ftList);

		JSONObject jo = new JSONObject();
		jo.put("list", ftList);

		System.out.println(userId + "는 즐겨찾기 있어!");
		new Gson().toJson(ftList,response.getWriter());

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
