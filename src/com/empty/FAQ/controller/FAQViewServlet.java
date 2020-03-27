package com.empty.FAQ.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.FAQ.model.vo.FAQ;
import com.empty.FAQ.service.FAQService;

/**
 * Servlet implementation class FAQViewServlet
 */
@WebServlet("/FAQ/FAQView")
public class FAQViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no=Integer.parseInt(request.getParameter("no"));
		Cookie[] cookies=request.getCookies();
		String cookieVal="";
		boolean hasRead=false;
		if(cookies!=null) {
			for(Cookie c:cookies) {
				String name=c.getName();
				String value=c.getValue();
				if("FAQCookie".equals(name)) {
					cookieVal=value;
					if(value.contains("|"+no+"|")) {
						hasRead=true;
						break;
					}
				}
			}
		}
		
		if(!hasRead) {
			Cookie c=new Cookie("FAQCookie",cookieVal+"|"+no+"|");
			c.setMaxAge(-1);
			response.addCookie(c);
		}
		
		FAQ f=new FAQService().selectFAQ(no,hasRead);
		request.setAttribute("FAQ", f);
		
		
		request.getRequestDispatcher("/views/FAQ/FAQView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
