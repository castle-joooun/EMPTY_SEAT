package com.semi.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.semi.model.dao.VinDao;
import com.semi.model.vo.VinUser;

public class VinService {
	
	private VinDao vd=new VinDao();
	
	public int insertCash(int money, VinUser v) {
		Connection conn=getConnection();
		int result = vd.insertCash(conn, money, v);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public VinUser selectUser(VinUser v) {
		Connection conn=getConnection();
		v = vd.selectUser(conn,v);
		close(conn);
		return v;
	}
}
