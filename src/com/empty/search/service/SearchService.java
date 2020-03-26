package com.empty.search.service;

import static com.empty.common.JDBCTemplate.close;
import static com.empty.common.JDBCTemplate.commit;
import static com.empty.common.JDBCTemplate.rollback;


import static com.empty.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.empty.search.model.dao.SearchDao;
import com.empty.search.model.vo.Store;
import com.empty.search.model.vo.StoreSeat;

public class SearchService {

	private SearchDao dao = new SearchDao();
	
	public List<Store> totalSearch(String searchBox) {
		Connection conn = getConnection();
		List<Store> list = dao.totalSearch(conn, searchBox);
		close(conn);
		System.out.println("서비스" + list);
		return list;
	}
	
	public Store store(String id) {
		Connection conn = getConnection();
		Store s = dao.store(conn, id);
		close(conn);
		System.out.println("스토어 : " + s);
		return s;
	}
	
	public List<String> storeImgs(String id) {
		Connection conn = getConnection();
		List<String> imgs = dao.storeImgs(conn, id);
		close(conn);
		return imgs;
	}
	
	public StoreSeat storeSeat(String id) {
		Connection conn = getConnection();
		StoreSeat ss = dao.storeSeat(conn, id);
		close(conn);
		return ss;
	}
	
	public int storeFavoriteInsert(String userId, String storeId) {
		Connection conn = getConnection();
		int result = dao.storeFavoriteInsert(conn, userId, storeId);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
	
	public int storeFavoriteDelete(String userId, String storeId) {
		Connection conn = getConnection();
		int result = dao.storeFavoriteInsert(conn, userId, storeId);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
}
