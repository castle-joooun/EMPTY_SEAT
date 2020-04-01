package com.empty.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.event.model.vo.Event;
import com.empty.event.service.EventService;

@WebServlet("/event/eventUpdate")
public class EventUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		Event e = new EventService().selectEvent(no);
		request.setAttribute("Event", e);
		request.getRequestDispatcher("/views/event/eventUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
