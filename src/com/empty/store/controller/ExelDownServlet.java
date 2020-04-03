package com.empty.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.empty.store.model.service.StoreService;
import com.empty.store.model.vo.StoreSales;

/**
 * Servlet implementation class ExelDownServlet
 */
@WebServlet("/exelDown.do")
public class ExelDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExelDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("date");
		String id = request.getParameter("storeId");
		List<StoreSales> list=new StoreService().selectStoreSales(id,date);
		//워크북생성
		Workbook wb = new HSSFWorkbook();

	    Sheet sheet =wb.createSheet(date+id);
	    Row row = null;
	    Cell cell = null;
	    int rowNo = 0;

	    // 테이블 헤더용 스타일
	    CellStyle headStyle = wb.createCellStyle();

	    // 가는 경계선을 가집니다.
	    headStyle.setBorderTop(BorderStyle.THIN);
	    headStyle.setBorderBottom(BorderStyle.THIN);
	    headStyle.setBorderLeft(BorderStyle.THIN);
	    headStyle.setBorderRight(BorderStyle.THIN);


	    // 배경색은 노란색입니다.
	    //headStyle.setFillForegroundColor(HSSFColor.YELLOW.getIndexHash());
	   // headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	    // 데이터는 가운데 정렬합니다.
	    headStyle.setAlignment(HorizontalAlignment.CENTER);

	    // 데이터용 경계 스타일 테두리만 지정
	    CellStyle bodyStyle = wb.createCellStyle();
	    bodyStyle.setBorderTop(BorderStyle.THIN);
	    bodyStyle.setBorderBottom(BorderStyle.THIN);
	    bodyStyle.setBorderLeft(BorderStyle.THIN);
	    bodyStyle.setBorderRight(BorderStyle.THIN);



	    // 헤더 생성

	    row = sheet.createRow(rowNo++);

	    cell = row.createCell(0);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("일자");
	    cell = row.createCell(1);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("요일");
	    cell = row.createCell(2);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("객수");
	    cell = row.createCell(3);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("공급가액");
	    cell = row.createCell(4);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("부가세");
	    cell = row.createCell(5);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("합계액");
	    // 데이터 부분 생성

	    int cusnum=0;
	    int net=0;
	    int tax=0;
	    int total=0;
	    for(StoreSales vo : list) {

	        row = sheet.createRow(rowNo++);
	        cell = row.createCell(0);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(vo.getEnDate());
	        
	        cell = row.createCell(1);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(vo.getDayOfWeek());
	        
	        cell = row.createCell(2);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(vo.getCustomer());
	        cusnum+=vo.getCustomer();
	        
	        cell = row.createCell(3);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(vo.getNetProfit());
	        net+=vo.getNetProfit();
	        
	        cell = row.createCell(4);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(vo.getTax());
	        tax+=vo.getTax();
	        
	        cell = row.createCell(5);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(vo.getTotalProfit());
	        total+=vo.getTotalProfit();
	        

	    }
	    row = sheet.createRow(rowNo++);
	    
	    //셀 병합
	    sheet.addMergedRegion(new CellRangeAddress(0,1,rowNo,rowNo)); 
	    //열시작, 열종료, 행시작, 행종료 (자바배열과 같이 0부터 시작)
	    cell = row.createCell(0);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("합계");
	    cell = row.createCell(1);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue(cusnum);
	    cell = row.createCell(2);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue(net+"원");
	    cell = row.createCell(3);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue(tax+"원");
	    cell = row.createCell(4);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue(total+"원");
	    cell = row.createCell(5);
	    cell.setCellStyle(headStyle);



	    // 컨텐츠 타입과 파일명 지정
	    response.setContentType("ms-vnd/excel");
	    response.setHeader("Content-Disposition", "attachment;filename=매출.xls");

	    // 엑셀 출력
	    wb.write(response.getOutputStream());
	    wb.close();

	}



	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
