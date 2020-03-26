package com.empty.FAQ.model.vo;

import java.sql.Date;

public class FAQ {

	
	private int no;
	private String title;
	private String content;
	private Date time;
	private int count;
	
	public FAQ() {
		// TODO Auto-generated constructor stub
	}

	public FAQ(int no, String title, String content, Date time, int count) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.time = time;
		this.count = count;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FAQ [no=" + no + ", title=" + title + ", content=" + content + ", time=" + time + ", count=" + count
				+ "]";
	}
}
