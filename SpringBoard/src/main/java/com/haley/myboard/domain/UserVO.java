package com.haley.myboard.domain;

//Springuser 테이블의 데이터를 저장할 클래스 
public class UserVO {

	// 1. 변수 선언
	private String id;
	private String pw;
	private String name;

	// 2. get, set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 3. toString()

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}

}
