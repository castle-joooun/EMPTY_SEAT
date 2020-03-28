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
				
				list.add(s);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
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
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return ss;
	}
	
	public int storeFavoriteInsert(Connection conn, String userId, String storeLogo, String storeId, String storeName) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("storeFavoriteInsert");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, storeLogo);
			pstmt.setString(3, storeId);
			pstmt.setString(4, storeName);
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
	
	public List favoriteList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		String sql = prop.getProperty("favoriteList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				List list2 = new ArrayList();
				rs.getString("USER_ID");
				list2.add(rs.getString("STORE_LOGO"));
				list2.add(rs.getString("STORE_ID"));
				list2.add(rs.getString("STORE_NAME"));
				list.add(list2);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int favoriteSize(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("favoriteList");
		int favoriteSize = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				favoriteSize++;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return favoriteSize;
	}
 	
}





















