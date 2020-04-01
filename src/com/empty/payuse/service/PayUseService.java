package com.empty.payuse.service;

import static com.empty.common.JDBCTemplate.close;
import static com.empty.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.empty.payuse.model.vo.PayUse;
import com.empty.payuse.model.dao.*;

public class PayUseService {
	
	private PayUseDao dao=new PayUseDao();

	
	
	public List<PayUse> searchPayUse(String userId) {
		Connection conn = getConnection();
		List<PayUse> list = dao.searchPayUse(conn,userId);
		close(conn);
		return list;
		
	}
}
