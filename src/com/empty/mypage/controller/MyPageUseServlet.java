package com.empty.mypage.controller;

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

import com.empty.member.model.vo.Member;
import com.empty.mypage.model.vo.PayUse;
import com.empty.mypage.service.MyPageService;
import com.google.gson.Gson;

/**
 * Servlet implementation class MyPageUseServlet
 */
@WebServlet("/mypageUse")
public class MyPageUseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		JSONArray ja=new JSONArray();
//		List<com.empty.payuse.model.vo.PayUse> list=new ArrayList();
//		for(com.empty.payuse.model.vo.PayUse p1:list) {
//			ja.put("storeName",p.getStore_name());
//			
//		}
		
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		int numPerPage;
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		}catch(NumberFormatException e) {
			numPerPage=0;
		}
		String userId=request.getParameter("userId");
		List<PayUse> list=new MyPageService().searchPayUse(userId,cPage,numPerPage);
		
		
		JSONArray ja=new JSONArray();
		if(list.size()>0) {
			int totalUse=new MyPageService().payUseCount(userId);
			System.out.println(totalUse);
			int totalPage=(int)Math.ceil((double)totalUse/numPerPage);
			int pageBarSize=5;
			int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
			int pageEnd=pageNo+pageBarSize-1;
			String pageBar="";
			
			if(pageNo==1) {
				pageBar+="<span class='nextBtn'> 이전 </span>";
			}else {
				pageBar+="<a href='javascript:void(0);' onclick='requestData("+(pageNo-1)+","+numPerPage+");'> 이전 </a>";
				pageBar+="<a href='javascript:void(0);' onclick='requestData("+1+","+numPerPage+";'> 1 </a>";
				pageBar+="<span>...</span>";
						
						
			}
			
			while(!(pageNo>pageEnd||pageNo>totalPage)) {
				if(pageNo==cPage) {
					pageBar+="<span class='cPage' style='color:#ff7531'> "+pageNo+" </span>";
				}else {
					pageBar+="<a href='javascript:void(0);' onclick='requestData("+pageNo+","+numPerPage+");'> "+pageNo+" </a>";
				}pageNo++;
			}
			if(pageNo>totalPage) {
				pageBar+="<span class='nextBtn'> 다음 </span>";
			}else {
				pageBar+="<span>....</span>";
				pageBar+="<a href='javascript:void(0);' onclick='requestData("+totalPage+","+numPerPage+")'> "+totalPage+" </a>";
				pageBar+="<a href='javascript:void(0);' onclick='requestData("+pageNo+","+numPerPage+")'> 다음 </a>";
			}
			for(PayUse p:list) {
				JSONObject jo=new JSONObject();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
				String date=sdf.format(p.getStime());
				jo.put("userId",p.getUser_id());
				jo.put("storeName",p.getStore_name());
				jo.put("payMoney",p.getPaymoney());
				jo.put("sTime",date);
				ja.add(jo);
			}
			JSONObject obj=new JSONObject();
			obj.put("pageBar",pageBar);
			ja.add(obj);
			
			
		}else {
			JSONObject obj=new JSONObject();
			obj.put("msg","사용한 내역이 없습니다.");
			ja.add(obj);
		}
		
		
		
		
		
		response.setContentType("application/json;charset=UTF-8");
//		response.getWriter().print(ja);
		new Gson().toJson(ja,response.getWriter());
		
		
		
		
		
		
		
		
		
		
		
		
		
//		request.getRequestDispatcher("/views/mypage/mypageUse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
