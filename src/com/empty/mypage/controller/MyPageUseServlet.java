package com.empty.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.empty.payuse.model.vo.*;
import com.empty.payuse.service.PayUseService;

import org.json.simple.JSONArray;

/**
 * Servlet implementation class MyPageUseServlet
 */
@WebServlet("/mypageUse")
public class MyPageUseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PayUse p=new PayUse();
//		JSONArray ja=new JSONArray();
//		List<com.empty.payuse.model.vo.PayUse> list=new ArrayList();
//		for(com.empty.payuse.model.vo.PayUse p1:list) {
//			ja.put("storeName",p.getStore_name());
//			
//		}
		
		String userId=request.getParameter("userId");
		List<PayUse> list=new PayUseService().searchPayUse(userId);
		
		
		request.setAttribute("list", list);
		
		
		
		
		
		
		
		
		
		
		
		
		request.getRequestDispatcher("/views/mypage/mypageUse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
