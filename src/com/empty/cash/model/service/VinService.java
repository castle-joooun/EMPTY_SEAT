package com.empty.cash.model.service;

import static com.empty.common.JDBCTemplate.close;
import static com.empty.common.JDBCTemplate.commit;
import static com.empty.common.JDBCTemplate.getConnection;
import static com.empty.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.empty.cash.model.dao.VinDao;
import com.empty.member.model.vo.Member;

public class VinService {
	
	private VinDao vd=new VinDao();
	
	public int insertCash(int money, Member m) {
		Connection conn=getConnection();
		int result = vd.insertCash(conn, money, m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public Member selectUser(Member m) {
		Connection conn=getConnection();
		m = vd.selectUser(conn,m);
		close(conn);
		return m;
	}
	public int payCharge(Member m, int money) {
		Connection conn=getConnection();
		int result = vd.payCharge(conn, m, money);
	}
}
