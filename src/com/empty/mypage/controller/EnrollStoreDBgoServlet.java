package com.empty.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.member.model.service.MemberService;
import com.empty.search.model.vo.Store;


/**
 * Servlet implementation class EnrollStoreDBgoServlet
 */
@WebServlet("/enroll/store")
public class EnrollStoreDBgoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollStoreDBgoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String storeName = request.getParameter("storeName");
		String storePhone = request.getParameter("storePhone");
		String storeTimestart = request.getParameter("storeTimestart");
		String storeTimeclose = request.getParameter("storeTimeclose");
		String storeInfo = request.getParameter("storeInfo");
		String storeAddress = request.getParameter("storeAddress");
		//int storePrice = Integer.parseInt(request.getParameter("storePrice"));
		String storePrice = request.getParameter("storePrice");
		//String storeFacirity =request.getParameter("storeFacirityData");
		String userId = request.getParameter("userId");
		String[] storeFacirity = request.getParameterValues("storeFacirity");
		String fileupload = request.getParameter("fileupload");
		System.out.println(fileupload);
		System.out.println(storeName);
		System.out.println(storePhone);
		System.out.println(storeTimestart);
		System.out.println(storeTimeclose);
		System.out.println(storeInfo);
		System.out.println(storeAddress);
		System.out.println(storePrice);
		System.out.println(userId);
		String storeFaciritys="";
		for(int i=0;i<storeFacirity.length;i++) {
			storeFaciritys +=storeFacirity[i]+",";
		}
		Store s = new Store();
		s.setStoreName(storeName);
		s.setStorePhone(storePhone);
		s.setStoreTime(storeTimestart+" ~ "+storeTimeclose);
		s.setStoreInfo(storeInfo);
		s.setStoreAddress(storeAddress);
		s.setStorePrice(storePrice);
		s.setStoreId(userId);
		s.setStoreFacility(storeFaciritys);
		new MemberService().insertStore(s);
	             


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
