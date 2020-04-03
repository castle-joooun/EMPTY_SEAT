package com.empty.store.model.dao;

import static com.empty.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.empty.admin.model.dao.AdminDao;
import com.empty.store.model.vo.StoreSales;

public class StoreDao {
Properties prop = new Properties();
	
	public StoreDao() {
		try {
			String path = AdminDao.class.getResource("/sql/store/storeSales.properties").getPath();
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List selectStoreSales(Connection conn, String id, String date) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectStoreSales");
		List<StoreSales> list = new ArrayList();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, date);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StoreSales s = new StoreSales();
				s.setStoreId(rs.getString("STORE_ID"));
				s.setStoreName(rs.getString("STORE_NAME"));
				s.setEnDate(rs.getDate("EN_DATE"));
				s.setDayOfWeek(rs.getString("DAY_OF_WEEK").charAt(0));
				s.setCustomer(rs.getInt("CUSTOMER"));
				s.setNetProfit(rs.getInt("NET_PROFIT"));
				s.setTax(rs.getInt("TAX"));
				s.setTotalProfit(rs.getInt("TOTAL_PROFIT"));
				list.add(s);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}

		return list;
		
	}
	
	
	
	
	
	
}
