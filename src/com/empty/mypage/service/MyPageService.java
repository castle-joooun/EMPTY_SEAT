package com.empty.mypage.service;

import java.sql.Connection;

import com.empty.mypage.model.dao.MyPageDao;
import com.empty.member.model.vo.Member;
import static com.empty.common.JDBCTemplate.close;
import static com.empty.common.JDBCTemplate.commit;
import static com.empty.common.JDBCTemplate.rollback;
import static com.empty.common.JDBCTemplate.getConnection;

public class MyPageService {

	private MyPageDao dao=new MyPageDao();
	
	public int updateMember(Member m) {
		Connection conn=getConnection();
		int result=dao.updateMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteMember(String userId,String password) {
		Connection conn=getConnection();
		int result=dao.deleteMember(conn,userId,password);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
}
