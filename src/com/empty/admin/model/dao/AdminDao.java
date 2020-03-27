package com.empty.admin.model.dao;

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

import com.empty.member.model.vo.Member;
import com.empty.search.model.dao.SearchDao;

public class AdminDao {
	Properties prop = new Properties();
	
	public AdminDao() {
		try {
			String path = AdminDao.class.getResource("/sql/admin/admin.properties").getPath();
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List selectMember(Connection conn,int cPage,int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectMemberPage");
		List<Member> list = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setUserId(rs.getString("USER_ID"));
				m.setUserDiv(rs.getBoolean("USER_DIV"));
				m.setUserName(rs.getString("USER_NAME"));
				m.setEmail(rs.getString("EMAIL"));
				m.setPhone(rs.getString("PHONE"));
				m.setAddress(rs.getString("ADDRESS"));
				m.setGender(rs.getString("GENDER"));
				m.setCash(rs.getInt("CASH"));
				m.setEnrollDate(rs.getDate("ENROLLDATE"));
				//m.setUserAppr(rs.getBoolean("USER_APPR"));
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("다오 " + list);
		return list;
	}
	
	public int memberCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("memberCount");
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
				
	}
	public List selectMember(Connection conn,String type,String keyword,int cPage,int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <Member> list = new ArrayList();
		String sql = prop.getProperty("selectMember"+type);
		System.out.println("타입: "+type);
		System.out.println("키워드: "+"%"+keyword+"%");
		System.out.println(cPage);
		System.out.println(numPerPage);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setUserId(rs.getString("USER_ID"));
				m.setUserDiv(rs.getBoolean("USER_DIV"));
				m.setUserName(rs.getString("USER_NAME"));
				m.setEmail(rs.getString("EMAIL"));
				m.setPhone(rs.getString("PHONE"));
				m.setAddress(rs.getString("ADDRESS"));
				m.setGender(rs.getString("GENDER"));
				m.setCash(rs.getInt("CASH"));
				m.setEnrollDate(rs.getDate("ENROLLDATE"));
				//m.setUserAppr(rs.getBoolean("USER_APPR"));
				list.add(m);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("검색조건다오 " + list);
		return list;
	}
	public int memberCount(Connection conn,String type,String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("memberCount"+type);
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("검색카운트다오 " + result);
		return result;
	}
}
