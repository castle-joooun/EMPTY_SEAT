package com.empty.admin.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.empty.admin.model.service.AdminService;
import com.empty.member.model.vo.Member;

/**
 * Servlet implementation class AdminUserAjaxPageServlet
 */
@WebServlet("/admin/ajaxPaging")
public class AdminUserAjaxPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserAjaxPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cPage;
		try{
			cPage= Integer.parseInt(request.getParameter("cPage"));//현재 페이지
		}catch(NumberFormatException e) {
			cPage=1;
		}
		int numPerPage ;
		try{
			numPerPage= Integer.parseInt(request.getParameter("numPerPage"));//페이지당 게시글 수 
		}catch(NumberFormatException e) {
			numPerPage=10;
		}
		List<Member> list=new AdminService().selectMember(cPage,numPerPage);
		
		
		int totalMember = new AdminService().memberCount();
		int totalPage = (int)Math.ceil((double)totalMember/numPerPage);
		int pageBarSize = 5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar="";
		
		if(pageNo==1) {
			pageBar+="<span class='nextBtn'style='color:grey'> ◀ 이전 </span>";
		}else {
			pageBar+="<a href='javascript:void(0);' onclick='requestData("+(pageNo-1)+","+numPerPage+");'> ◀ 이전 </a>";
			pageBar+="<a href='javascript:void(0);' onclick='requestData("+1+","+numPerPage+");'> 1 </a>";
			pageBar+="<span> ... </span>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span class='cPage' style='color:#ff7531'> "+pageNo+" </span>";
			}else {
				pageBar+="<a href='javascript:void(0);' onclick='requestData("+pageNo+","+numPerPage+");'> "+pageNo+" </a>";
				//pageBar+="<span><input type='hidden' name='cPage' value='"+pageNo+"'><input type='hidden' name='numPerPage' value='"+numPerPage+"'> "+pageNo+" </span>";
				//pageBar+="<span class='pageNo' id='cPage"+pageNo+"'> "+pageNo+" </span>"; 
			}
			pageNo++;
		}
		if(pageNo>totalPage) {
			pageBar+="<span class='nextBtn'style='color:grey'> 다음 ▶ </span>";
		}else {
			pageBar+="<span> ... </span>";
			pageBar+="<a href='javascript:void(0);' onclick='requestData("+totalPage+","+numPerPage+")'> "+totalPage+" </a>";
			pageBar+="<a href='javascript:void(0);' onclick='requestData("+pageNo+","+numPerPage+")'> 다음 ▶ <a>";
		}
		
		//list를 jasonlist(배열)에 넣어 전달하기
		JSONArray ja = new JSONArray();
		
		for(Member m : list) {
			JSONObject jo = new JSONObject();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date = sdf.format(m.getEnrollDate());
			jo.put("userid",m.getUserId());
			if(!m.isUserDiv())jo.put("userdiv","일반회원" );
			jo.put("username",m.getUserName());
			jo.put("gender",m.getGender());
			jo.put("phone",m.getPhone());
			jo.put("email",m.getEmail());
			jo.put("address",m.getAddress());
			jo.put("enrolldate",date);
			ja.add(jo);
		}
		//pagebar add
		JSONObject obj=new JSONObject();
		obj.put("pageBar", pageBar);
		ja.add(obj);
		System.out.println(pageBar);
		System.out.println(ja);
		
		//request.setAttribute("list", list);
		response.setContentType("application/text/plain;charset=UTF-8");
		response.getWriter().print(ja);
//		request.setAttribute("cPage",cPage);
//		request.setAttribute("numPerPage",cPage);
//		request.getRequestDispatcher("/views/admin/pagingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
