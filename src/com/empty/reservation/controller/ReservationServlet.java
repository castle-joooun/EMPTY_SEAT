package com.empty.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.reservation.service.ReservationService;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String storeId = request.getParameter("storeId");
		int seat = Integer.parseInt(request.getParameter("seat")) -1;
		int pay = Integer.parseInt(request.getParameter("pay"));
		
		int userPay = new ReservationService().userPay(userId, pay);
		if(userPay>0) {
			System.out.println("유저 돈 깍임!");			
		}
		
		String seats = new ReservationService().seatList(storeId);
		if(seats.equals("")) {
			System.out.println("시트리스트 불어왔어!");
		}
		
		String[] list = seats.split(",");
		list[seat] = "1";
		String tranSeats = "";
		
		for(int i=0; i<list.length; i++) {
			tranSeats += list[i] + ",";
		}
		
		int useSeat = new ReservationService().inputSeat(storeId, tranSeats);
		if(useSeat>0) {
			System.out.println("자리 예약됌!");
		}
		
		System.out.println("실행됐어!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
