package com.empty.reservation.model.dao;

import static com.empty.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReservationDao {

	Properties prop = new Properties();
	
	public ReservationDao() {
		try {
			String path = ReservationDao.class.getResource("/sql/reservation/reservation.properties").getPath();
			prop.load(new FileReader(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int userPay(Connection conn, String userId, int pay) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("userPay");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, pay);
			pstmt.setString(3, userId);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public String seatList(Connection conn, String storeId) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("seatList");
		ResultSet rs = null;
		String seats = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seats = rs.getString("SEAT_CHECK");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return seats;
	}
	
	public int inputSeat(Connection conn, String storeId, String seats) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("useSeat");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seats);
			pstmt.setString(2, storeId);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePayUse(Connection conn, String storeName, String userId, int pay, String storeId) {
		PreparedStatement pstmt = null;
		int result=0;
		String sql=prop.getProperty("updatePayUse");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeName);
			pstmt.setString(2, userId);
			pstmt.setInt(3, pay);
			pstmt.setString(4, storeId);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
		
	}
	
	
}
