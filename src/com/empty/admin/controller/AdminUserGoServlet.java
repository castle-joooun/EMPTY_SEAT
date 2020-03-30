package com.empty.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.empty.admin.model.service.AdminService;
import com.empty.member.model.vo.Member;

/**
 * Servlet implementation class AdminUserServlet
 */
@WebServlet("/admin/manageUser")
public class AdminUserGoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserGoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		관리자일때만 접속이 가능하도록 로직처리하기 
		
		
		//json 자바 객체를 js에서 객체로서 활용할수있게 하는 것
		//JSONObject jo = new JSONObject();
		//jo에 key value형식으로 값을 넣으면 자바스크립트 객체로 프론트단에서 받을 수 있음
		//프론트에서 에이작스로 보낸 데이터받기 
	
		//페이징처리
		
		request.getRequestDispatcher("/views/admin/manageUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
