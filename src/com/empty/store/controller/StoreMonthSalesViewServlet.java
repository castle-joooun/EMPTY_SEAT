package com.empty.store.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StoreMonthSalesViewServlet
 */
@WebServlet("/store/monthSalesView")
public class StoreMonthSalesViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreMonthSalesViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String year;
		String month;
		try {
			String day = request.getParameter("month");
			String str[]=day.split("-");
			year=str[0];
			month=str[1];
			
		}catch(Exception e){
			Date d = new Date();
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
			SimpleDateFormat sdf2= new SimpleDateFormat("MM");
			
			year = sdf.format(d);
			month = sdf2.format(d);
		}
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.getRequestDispatcher("/views/storesales/monthSales.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
