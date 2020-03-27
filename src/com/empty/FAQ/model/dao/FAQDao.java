package com.empty.FAQ.model.dao;

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

import com.empty.FAQ.model.vo.FAQ;

public class FAQDao {

	
private Properties prop=new Properties();
	
	public FAQDao() {
		try {
			String path=FAQDao.class.getResource("/sql/FAQ/FAQ-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertFAQ(Connection conn,FAQ f) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertFAQ");
		try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, f.getTitle());
				pstmt.setString(2, f.getContent());
				result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public List<FAQ> searchFAQ(Connection conn,int cPage,int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("searchFAQ");
		List<FAQ> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				FAQ f=new FAQ();
				f.setNo(rs.getInt("FAQ_NO"));
				f.setTitle(rs.getString("FAQ_TITLE"));
				f.setTime(rs.getDate("FAQ_TIME"));
				f.setCount(rs.getInt("FAQ_COUNT"));
				list.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	public int FAQCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String sql=prop.getProperty("FAQCount");
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	
	public FAQ selectFAQ(Connection conn,int no,boolean hasRead) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectFAQ");
		FAQ f=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				f=new FAQ();
				f.setNo(rs.getInt("faq_no"));
				f.setTitle(rs.getString("faq_title"));
				f.setContent(rs.getString("faq_content"));
				f.setTime(rs.getDate("faq_time"));
				f.setCount(rs.getInt("faq_count"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return f;
	}
	
	public int updateCount(Connection conn,int no) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateCount");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
}
