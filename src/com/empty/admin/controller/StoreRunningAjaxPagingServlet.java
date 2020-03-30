package com.empty.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty.admin.model.service.AdminService;
import com.google.gson.Gson;

/**
 * Servlet implementation class StoreRunningAjaxPagingServlet
 */
@WebServlet("/admin/store/runningStoreAjax")
public class StoreRunningAjaxPagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreRunningAjaxPagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		int numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		List list = new AdminService().selectStore(cPage,numPerPage);
		
		if(list.size()>0) {
			int totalMember = new AdminService().selectStore();
			int totalPage = (int)Math.ceil((double)totalMember/numPerPage);
			int pageBarSize = 5;
			int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
			int pageEnd = pageNo+pageBarSize-1;
			String pageBar = "";
			if(pageNo==1) {
				pageBar+="<span class='nextBtn'style='color:grey'> ◀ 이전 </span>";
			}else {
				pageBar+="<a href='javascript:void(0);' onclick='requestStore("+(pageNo-1)+","+numPerPage+");'> ◀ 이전 </a>";
				pageBar+="<a href='javascript:void(0);' onclick='requestStore("+1+","+numPerPage+");'>  1  </a>";
				pageBar+="<span> ... </span>";
			}
			while(!(pageNo>pageEnd||pageNo>totalPage)) {
				if(pageNo==cPage) {
					pageBar+="<span class='cPage' style='color:#ff7531'> "+pageNo+" </span>";
				}else {
					pageBar+="<a href='javascript:void(0);' onclick='requestStore("+pageNo+","+numPerPage+");'> "+pageNo+" </a>";
					
				}
				pageNo++;
			}
			if(pageNo>totalPage) {
				pageBar+="<span class='nextBtn'style='color:grey'> 다음 ▶ </span>";
			}else {
				pageBar+="<span> ... </span>";
				pageBar+="<a href='javascript:void(0);' onclick='requestStore("+totalPage+","+numPerPage+")'> "+totalPage+" </a>";
				pageBar+="<a href='javascript:void(0);' onclick='requestStore("+pageNo+","+numPerPage+")'> 다음 ▶ <a>";
			}
			list.add(totalMember);
			list.add(pageBar);
			
		}else {
			list.add("검색된 결과가 없습니다.");
		}
		response.setContentType("application/json;charset=UTF-8");
		new Gson().toJson(list,response.getWriter());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
