package com.empty.notice.model.dao;

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

import com.empty.notice.model.vo.Notice;

public class NoticeDao {

	private Properties prop = new Properties();

	public NoticeDao() {
		try {
			String path = NoticeDao.class.getResource("/sql/notice/notice.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<Notice> searchNotice(Connection conn, int cPage, int numPerPage){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = prop.getProperty("searchNotice");
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM (SELECT * FROM NOTICE ORDER BY NOTICE_NO DESC)A) WHERE RNUM BETWEEN ? AND ?";
		List<Notice> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(2, cPage * numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rs.getInt("NOTICE_NO"));
				n.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				n.setNoticeWriter(rs.getString("NOTICE_WRITER"));
				n.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				n.setNoticeDate(rs.getDate("NOTICE_DATE"));
				n.setNoticeCount(rs.getInt("NOTICE_COUNT"));
				list.add(n);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int noticeCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("noticeCount");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertNotice");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Notice selectNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectNotice");
		Notice n = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				n = new Notice();
				n.setNoticeNo(rs.getInt("NOTICE_NO"));
				n.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				n.setNoticeWriter(rs.getString("NOTICE_WRITER"));
				n.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				n.setNoticeDate(rs.getDate("NOTICE_DATE"));
				n.setNoticeCount(rs.getInt("NOTICE_COUNT"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return n;
	}

	public Notice selectNotice(Connection conn, int no, boolean hasRead) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectNotice");
		Notice n = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				n = new Notice();
				n.setNoticeNo(rs.getInt("NOTICE_NO"));
				n.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				n.setNoticeWriter(rs.getString("NOTICE_WRITER"));
				n.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				n.setNoticeDate(rs.getDate("NOTICE_DATE"));
				n.setNoticeCount(rs.getInt("NOTICE_COUNT"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return n;
	}

	public int updateCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateNotice(Connection conn, int no, String title, String content) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateNotice");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteNotice");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}