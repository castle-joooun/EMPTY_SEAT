package com.empty.reservation.service;

import static com.empty.common.JDBCTemplate.close;
import static com.empty.common.JDBCTemplate.commit;
import static com.empty.common.JDBCTemplate.getConnection;
import static com.empty.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.empty.reservation.model.dao.ReservationDao;

public class ReservationService {

	private ReservationDao dao = new ReservationDao();
	
	public int userPay(String userId, int pay) {
		Connection conn = getConnection();
		int result = dao.userPay(conn, userId, pay);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public String seatList(String storeId) {
		Connection conn = null;
		String seats = dao.seatList(conn, storeId);
		return seats;
	}
	
	public int inputSeat(String storeId, String seats) {
		Connection conn = null;
		int result = dao.inputSeat(conn, storeId, seats);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
}
