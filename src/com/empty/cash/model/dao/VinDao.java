package com.empty.cash.model.dao;

import static com.empty.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.empty.member.model.vo.Member;
import com.empty.search.model.dao.SearchDao;

public class VinDao {
	
	Properties prop = new Properties();
	
	public VinDao() {
		try {
			String path = SearchDao.class.getResource("/sql/cash/cash.properties").getPath();
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertCash(Connection conn, int money, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="UPDATE VINUSER SET CASH =? WHERE USER_ID='fgsdhi'"; 
		String sql2="UPDATE MEMBER" + 
				"   SET (CASH) = (SELECT CASH+?" + 
				"                   FROM MEMBER" + 
				"                  WHERE USER_ID='fgsdhi')" + 
				" WHERE USER_ID='fgsdhi'";
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
	
	public Member selectUser(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="SELECT * FROM Member WHERE USER_ID = '?'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setUserId(rs.getString("user_id"));
				m.setCash(rs.getInt("cash"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public int payCharge(Connection conn, Member m, int money, String sudan) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql = prop.getProperty("payCharge");
		String sudany="";
		switch(sudan) {
			case "phone" :sudany="핸드폰결제";break;
			case "trans" :sudany="계좌이체";break;
			case "card" :sudany="카드결제";break;
			case "vbank" :sudany="가상계좌";break;
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setInt(2, money);
			pstmt.setString(3, sudany);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
