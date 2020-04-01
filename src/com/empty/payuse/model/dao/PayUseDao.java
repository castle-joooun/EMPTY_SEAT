package com.empty.payuse.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.empty.payuse.model.vo.*;
import static com.empty.common.JDBCTemplate.close;

public class PayUseDao {

	Properties prop=new Properties();
	
	public PayUseDao() {
		try {
			String path=PayUseDao.class.getResource("/sql/payuse/payuse.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List searchPayUse(Connection conn,String userId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("searchPayUse");
		List<PayUse> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PayUse p=new PayUse();
				p.setUser_id(rs.getString("user_Id"));
				p.setEtime(rs.getDate("etime"));
				p.setStime(rs.getDate("stime"));
				p.setPaymoney(rs.getInt("paymoney"));
				p.setStore_name(rs.getString("store_name"));
				list.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
