package com.empty.cash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.empty.cash.model.service.VinService;
import com.empty.member.model.vo.Member;

/**
 * Servlet implementation class Test111111111
 */
@WebServlet("/test.do")
public class ChargeMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member m = new Member();
		int amount = Integer.parseInt(request.getParameter("amount")); //결제금액 변수
		String pay = request.getParameter("pay");   //결제수단 변수
		String userId = request.getParameter("userId");   //결제제 아이디 변수
		
		m = new VinService().selectUser(m, userId); //내정보 불러오기
		new VinService().insertCash(amount, m); //내 계정 db에 캐시 증가
		new VinService().payCharge(m, amount, pay);   //충전내역 db에 저장
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
