package com.empty.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.empty.reservation.service.ReservationService;
import com.google.gson.Gson;

/**
 * Servlet implementation class ReservationCheckServlet
 */
@WebServlet("/reservationCheck")
public class ReservationCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String storeId = request.getParameter("storeId");

		long now = System.currentTimeMillis();
		
//		--------------------------------------

		// store_seat_check에서 seat_yn의 값이 1인것만 가져온 것.
		List reSeats = new ReservationService().bringSeat(storeId, now);
		if (reSeats.size() != 0) {
			System.out.println("reSeats 가져옴!");
		}

//		JSONObject jo = new JSONObject();
//		jo.put("seats", seats);
		new Gson().toJson(reSeats, response.getWriter());
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
