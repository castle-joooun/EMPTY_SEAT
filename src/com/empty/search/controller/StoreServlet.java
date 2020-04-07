package com.empty.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.reservation.service.ReservationService;
import com.empty.search.model.vo.Store;
import com.empty.search.model.vo.StoreSeat;
import com.empty.search.service.SearchService;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/storeView")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreServlet() {
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

		String storeId = request.getParameter("storeId");
		String userId = request.getParameter("userId");
		System.out.println("storeId : " + storeId);
		Store store = new SearchService().store(storeId);
		String searchText = request.getParameter("searchText");
		
		// getParameter로 받는거 3개.
		// storeId, userId, searchText
	    
		List<String> imgs = new SearchService().storeImgs(storeId);
		System.out.println("imgs : " + imgs);
		
		long now = System.currentTimeMillis();

		// 시간의 차이가 -거나 0인것들은 emptySeat로 돌리기 위해
		// store_seat_check에서 seat_yn의 값을 0으로 수정.
		// 1. 받아오기
		List<String> checkYN = new ReservationService().checkYN(storeId, now);
		if (checkYN.size() != 0) {
			System.out.println("YN바뀌는 거 있음");
		}

		// 2-1. store_seat_check에 값 바꿔주기.
		int changeYN1 = new ReservationService().changeYN1(storeId, checkYN);
		if (changeYN1 > 0) {
			System.out.println("store_seat_check 값 바꿈쓰");
		}

		// 2-2.
		// store_seat seat_check 불러오기
		String seats = new ReservationService().seatList(storeId);
		if (seats != null) {
			System.out.println("시트리스트 불어왔어! : " + seats);
		}

		String[] list = seats.split(",");
		
		for(int i=0; i<checkYN.size(); i++) {
			int seatNum = Integer.parseInt(checkYN.get(i));
			list[seatNum - 1] = "0";
		}
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
			System.out.println("자리 비워줌!!");
		}
		
		StoreSeat ss = new SearchService().storeSeat(storeId);
		System.out.println("storeSeat : " + ss);
		
		// 즐겨찾기 되어 있는지 확인
		String favoriteUrl = new SearchService().storeFavoriteCheck(userId, storeId);
		if(favoriteUrl.equals("image/favorite-use.png")) {
			System.out.println("해당 스토어에 즐겨찾기 등록되어 있음");			
		} else {
			System.out.println("해당 스토어에 즐겨찾기 등록되어 있지 않음");		
		}
		
		if (store != null && ss != null) {
			System.out.println("스토어 " + store);
			request.setAttribute("store", store);
			request.setAttribute("imgs", imgs);
			request.setAttribute("storeSeat", ss);
			request.setAttribute("searchText", searchText);
			request.setAttribute("url", favoriteUrl);
			request.getRequestDispatcher("/views/search/store.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/search/noneSearch.jsp").forward(request, response);
		}

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
