package com.empty.search.model.dao;

import static com.empty.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.empty.search.model.vo.Store;
import com.empty.search.model.vo.StoreSeat;


public class SearchDao {
	
	Properties prop = new Properties();
	
	public SearchDao() {
		try {
			String path = SearchDao.class.getResource("/sql/search/search.properties").getPath();
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Store> totalSearch(Connection conn, String searchBox) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM STORE WHERE(STORE_NAME LIKE '%" + searchBox + "%' OR STORE_INFO LIKE '%" + searchBox + 
				"%' OR STORE_FACILITY LIKE '%" + searchBox + "%' OR STORE_ADDRESS LIKE '%" + searchBox + "%')";
		List<Store> list = new ArrayList();
		Store s = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				s = new Store(
						rs.getString("store_id"),
						rs.getString("store_name"),
						rs.getString("store_phone"),
						rs.getString("store_time"),
						rs.getString("store_info"),
						rs.getString("store_facility"),
						rs.getString("store_address"),
						rs.getString("store_logo")
						);
				
				System.out.println("스토어 아이디" + rs.getString("store_id"));
				
				list.add(s);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		System.out.println("다오 " + list);
		return list;
	}
	
	public Store store(Connection conn, String id) {
		PreparedStatement pstmt = null;
		Store s = null;
		ResultSet rs = null;
		String sql = prop.getProperty("store");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				s = new Store(
						rs.getString("store_id"),
						rs.getString("store_name"),
						rs.getString("store_phone"),
						rs.getString("store_time"),
						rs.getString("store_info"),
						rs.getString("store_facility"),
						rs.getString("store_address"),
						rs.getString("store_logo")
						);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return s;
	}
	
	public List<String> storeImgs(Connection conn, String id) {
		PreparedStatement pstmt = null;
		List<String> imgs = new ArrayList();
		ResultSet rs = null;
		String sql = prop.getProperty("storeImgs");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				imgs.add(rs.getString("store_img"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return imgs;
	}
	
	public StoreSeat storeSeat(Connection conn, String id) {
		PreparedStatement pstmt = null;
		StoreSeat ss = null;
		ResultSet rs = null;
		String sql = prop.getProperty("storeSeat");
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ss = new StoreSeat();
				ss.setStoreId(rs.getString("store_id"));
				ss.setCol(rs.getInt("store_col"));
				ss.setRow(rs.getInt("store_row"));
				ss.setStoreCheck(rs.getString("store_check"));
				System.out.println("다오에 있니? ");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return ss;
	}
	
	public int storeFavoriteInsert(Connection conn, String userId, String storeId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("storeFavoriteInsert");
		System.out.println("userID : " + userId);
		System.out.println("storeID : " + storeId);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, storeId);
			pstmt.setString(3, storeId);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int storeFavoriteDelete(Connection conn, String userId, String storeId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("storeFavoriteDelete");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, storeId);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int storeFavoriteCheck(Connection conn, String userId, String storeId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("storeFavoriteCheck");
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, storeId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
		
	}
	
}





















