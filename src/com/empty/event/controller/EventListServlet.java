package com.empty.event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty.event.model.vo.Event;
import com.empty.event.service.EventService;
import com.empty.member.model.vo.Member;

@WebServlet("/event")
public class EventListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EventListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean flag;
		try {
			Member m = (Member) session.getAttribute("loginMember");
			String id = m.getUserId();
			flag = new EventService().selectStoreId(id);
		}catch(NullPointerException e) {
			flag=false;
		}
		request.setAttribute("flag", flag);
		
		int cPage;

		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}

		int numPerPage = 5;

		List<Event> list = new EventService().searchEvent(cPage, numPerPage);

		int totalEvent = new EventService().eventCount();

		int totalPage = (int)Math.ceil((double) totalEvent / numPerPage);

		int pageBarSize = 5;
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		int pageEnd = pageNo+pageBarSize - 1;

		String pageBar = "";

		if(pageNo == 1) {
			pageBar += "<span> < 이전 </span>";
		}else {
			pageBar += "<a href='" + request.getContextPath() + "/event?cPage=" + (pageNo - 1) + "'> < 이전 </a>";					
		}

		while(!(pageNo > pageEnd||pageNo > totalPage)) {
			if(pageNo == cPage) {
				pageBar += "<span> " + pageNo + " </span>";
			}else {
				pageBar += "<a href='" + request.getContextPath() + "/event?cPage=" + (pageNo) + "'> " + pageNo + " </a>";
			}
			pageNo++;
		}

		if(pageNo > totalPage) {
			pageBar += "<span> 다음 > </span>";
		}else {
			pageBar += "<a href='"+request.getContextPath() + "/event?cPage=" + (pageNo) + "'> 다음 > </a>";					
		}
		
		
		request.setAttribute("list",list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/event/eventList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
