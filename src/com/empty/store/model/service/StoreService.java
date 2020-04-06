package com.empty.store.model.service;

import java.util.List;
import static com.empty.common.JDBCTemplate.close;
import static com.empty.common.JDBCTemplate.commit;
import static com.empty.common.JDBCTemplate.getConnection;
import static com.empty.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.empty.search.model.vo.Store;
import com.empty.store.model.dao.StoreDao;

public class StoreService {
	
	StoreDao dao = new StoreDao();
	

	public List selectStoreSales(String id, String date) {
		Connection conn = getConnection();
		List list = dao.selectStoreSales(conn,id,date);
		close(conn);
		return list;
	}

	
	
	
}
