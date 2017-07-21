package com.haley.myboard.domain;

import java.sql.Date;

// 데이터베이스 연동 DTO 클래스 
public class BoardVO {

	// 1. 테이블 컬럼 이름과 동일한 인스턴스 변수 선언
	private int bno;
	private String title;
	private String content;
	private String id;
	private Date regdate;
	private int readcnt;
	private String ip;

	// 2. getter setter 함수 구현
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	// 3. toString 함수 재정의
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", id=" + id + ", regdate="
				+ regdate + ", readcnt=" + readcnt + ", ip=" + ip + "]";
	}

}
