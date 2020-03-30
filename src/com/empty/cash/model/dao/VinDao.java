package com.empty.cash.model.dao;

import static com.empty.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty.member.model.vo.Member;

public class VinDao {
	
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
		String sql="SELECT * FROM Member WHERE USER_ID = 'fgsdhi'";
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
	
	public int payCharge(Connection conn, Member m, int money) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="INSERT INTO PAY_CHARGE VALUES("+m.getUserId()+",SYSDATE,"+money+",)";
	}
}
