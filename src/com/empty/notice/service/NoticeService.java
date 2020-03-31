package com.empty.notice.service;
import java.sql.Connection;
import java.util.List;
import static com.empty.common.JDBCTemplate.close;
import static com.empty.common.JDBCTemplate.getConnection;
import static com.empty.common.JDBCTemplate.commit;
import static com.empty.common.JDBCTemplate.rollback;
import com.empty.notice.model.dao.NoticeDao;
import com.empty.notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDao dao = new NoticeDao();
	
	public List<Notice> searchNotice(int cPage, int numPerPage){
		Connection conn = getConnection();
		List<Notice> list = dao.searchNotice(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	
	public int noticeCount() {
		Connection conn = getConnection();
		int result = dao.noticeCount(conn);
		close(conn);
		return result;
	}
	
	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = dao.insertNotice(conn, n);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
}