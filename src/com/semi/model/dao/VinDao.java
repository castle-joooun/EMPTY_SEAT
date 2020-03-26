package com.semi.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.model.vo.VinUser;

public class VinDao {
	
	public int insertCash(Connection conn, int money, VinUser v) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="UPDATE VINUSER SET CASH =? WHERE USER_ID='ADMIN'"; 
		String sql2="UPDATE VINUSER" + 
				"   SET (CASH) = (SELECT CASH+?" + 
				"                   FROM VINUSER" + 
				"                  WHERE USER_ID='ADMIN')" + 
				" WHERE USER_ID='ADMIN'";
		try {
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, money);
			result=pstmt.executeUpdate();
//			System.out.println(v.getCash()+money);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public VinUser selectUser(Connection conn, VinUser v) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="SELECT * FROM VINUSER WHERE USER_ID = 'ADMIN'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				v=new VinUser();
				v.setUserId(rs.getString("user_id"));
				v.setPassword(rs.getString("password"));
				v.setCash(rs.getInt("cash"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return v;
	}
	
}
