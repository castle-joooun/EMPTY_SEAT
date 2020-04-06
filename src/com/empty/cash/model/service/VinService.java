package com.empty.cash.model.service;

import static com.empty.common.JDBCTemplate.close;
import static com.empty.common.JDBCTemplate.commit;
import static com.empty.common.JDBCTemplate.getConnection;
import static com.empty.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.empty.cash.model.dao.VinDao;
import com.empty.member.model.vo.Member;
import com.empty.member.model.vo.outMoneyDB;

public class VinService {
	
	private VinDao vd=new VinDao();
	
	public int insertCash(int amount, Member m) {
		Connection conn=getConnection();
		int result = vd.insertCash(conn, amount, m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public Member selectUser(Member m, String userId) {
		Connection conn=getConnection();
		m = vd.selectUser(conn, m, userId);
		close(conn);
		return m;
	}
	public int payCharge(Member m, int amount, String pay) {
		Connection conn=getConnection();
		int result = vd.payCharge(conn, m, amount, pay);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public void minusCash(Member m, int money) {
		Connection conn=getConnection();
		int result = vd.minusCash(conn, m, money);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
	}
	
	public int outMoneyListDB(Member m, int money) {
		Connection conn=getConnection();
		int result= vd.outMoneyListDB(conn, m,money);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
