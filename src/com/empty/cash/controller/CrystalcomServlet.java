package com.empty.cash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.cash.model.service.VinService;
import com.empty.member.model.vo.Member;

/**
 * Servlet implementation class CrystalcomServlet
 */
@WebServlet("/cash/goOutMoneySV.do")
public class CrystalcomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrystalcomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member m = new Member();
		int money = Integer.parseInt(request.getParameter("money"));
		String userId = request.getParameter("userId");
		
		m = new VinService().selectUser(m, userId);	   //내정보불러오기
		new VinService().minusCash(m, money);    //내 db계정 캐시 감소
		//new VinService().payCharge(m, money );  //출금내역 db에 저장
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
