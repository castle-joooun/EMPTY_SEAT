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

import com.empty.mypage.model.vo.InputMoneyList;
import com.empty.mypage.service.MyPageService;
import com.google.gson.Gson;

/**
 * Servlet implementation class MyPagePayServlet
 */
@WebServlet("/mypagePay")
public class MyPagePayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPagePayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cPage2;
		try {
			cPage2=Integer.parseInt(request.getParameter("cPage2"));
		}catch(NumberFormatException e) {
			cPage2=1;
		}
		int numPerPage2;
		try {
			numPerPage2=Integer.parseInt(request.getParameter("numPerPage2"));
		}catch(NumberFormatException e) {
			numPerPage2=0;
		}
		String userId2=request.getParameter("userId2");
		List<InputMoneyList> list2=new MyPageService().searchPayCharge(userId2,cPage2,numPerPage2);
		
		JSONArray ja2=new JSONArray();
		if(list2.size()>0) {
			int totalCharge2=new MyPageService().payChargeCount(userId2);
			int totalPage2=(int)Math.ceil((double)totalCharge2/numPerPage2);
			int pageBarSize2=5;
			int pageNo2=((cPage2-1)/pageBarSize2)*pageBarSize2+1;
			int pageEnd2=pageNo2+pageBarSize2-1;
			String pageBar2="";
			
			if(pageNo2==1) {
				pageBar2+="<span class='nextBtn2'> 이전 </span>";
			}else {
				pageBar2+="<a href='javascript:void(0);' onclick='requestData2("+(pageNo2-1)+","+numPerPage2+");'> 이전 </a>";
				pageBar2+="<a href='javascript:void(0);' onclick='requestData2("+1+","+numPerPage2+";'> 1 </a>";
				pageBar2+="<span>...</span>";
			}
			while(!(pageNo2>pageEnd2||pageNo2>totalPage2)) {
				if(pageNo2==cPage2) {
					pageBar2+="<span class='cPage2' style='color:#ff7531'>"+pageNo2+"</span>";
				}else {
					pageBar2+="<a href='javascript:void(0)'; onclick='requestData2("+pageNo2+","+numPerPage2+");'> "+pageNo2+" </a>";
				}pageNo2++;
			}
			
			if(pageNo2>totalPage2) {
				pageBar2+="<span class='nextBtn2'> 다음 </span>";
			}else {
				pageBar2+="<span>...</span>";
				pageBar2+="<a href='javascript:void(0);' onclick='requestData2("+totalPage2+","+numPerPage2+")'> "+totalPage2+" </a>";
				pageBar2+="<a href='javascript:void(0);' onclick='requestData2("+pageNo2+","+numPerPage2+")'> 다음 </a>";
			}
			for(InputMoneyList iml:list2) {
				JSONObject jo2=new JSONObject();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
				String date=sdf.format(iml.getIpdate());
				jo2.put("userId",iml.getUser_id());
				jo2.put("inputNum",iml.getInput_num());
				jo2.put("ipDate",date);
				jo2.put("ipMoney",iml.getIpmoney());
				jo2.put("afterIm",iml.getAfter_im());
				ja2.add(jo2);
			}
			JSONObject obj2=new JSONObject();
			obj2.put("pageBar2",pageBar2);
			ja2.add(obj2);
			
			
		}else {
			JSONObject obj2=new JSONObject();
			obj2.put("msg2","충전한 내역이 없습니다.");
			ja2.add(obj2);
		}
		
		
		response.setContentType("application/json;charset=UTF-8");
		new Gson().toJson(ja2,response.getWriter());
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
