package com.empty.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.empty.reservation.service.ReservationService;
import com.google.gson.Gson;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String storeId = request.getParameter("storeId");
		int seat = Integer.parseInt(request.getParameter("seat")) - 1;
		int pay = Integer.parseInt(request.getParameter("pay"));

		// 1. 유저 캐시 빼준다.
		// member cash 빼주는 기능
		int userPay = new ReservationService().userPay(userId, pay);
		if (userPay > 0) {
			System.out.println("유저 돈 깍임!");
		}
		// 2. 유저 캐시 리로드 해줄꺼 반할 로직 짜준다.
		int userCash = new ReservationService().userCash(userId);
		if(userCash > 0) {
			System.out.println("돈 가져왔어! : " + userCash);
		}
		
		// 3. 스토어 해당 자리를 변경해준다.
//		int changeSeatUse = new ReservationService().changeSeatUse(userId, storeId, seat);
//		if(changeSeatUse > 0) {
//			System.out.println("자리 바꼈어!");
//		}

		// store_seat seat_check 불러오기
		String seats = new ReservationService().seatList(storeId);
		if (seats.equals("")) {
			System.out.println("시트리스트 불어왔어!");
		}

		String[] list = seats.split(",");
		list[seat] = "1";
		String tranSeats = "";

		for (int i = 0; i < list.length; i++) {
			if (i == list.length - 1) {
				tranSeats += list[i];
			} else {
				tranSeats += list[i] + ",";
			}
		}

		// store_seat seat_check 반환하기 (1=사용중)
		int useSeat = new ReservationService().inputSeat(storeId, tranSeats);
		if (useSeat > 0) {
			System.out.println("자리 예약됌!");
		}

		System.out.println("실행됐어!!");

		
		JSONObject jo = new JSONObject();
		jo.put("userCash", userCash);
		new Gson().toJson(userCash,response.getWriter());
		
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
