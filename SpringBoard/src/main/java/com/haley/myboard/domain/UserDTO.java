package com.haley.myboard.domain;

import org.springframework.web.multipart.MultipartFile;

// ȸ�� ���� form�� �����͸� �����ϴ� Ŭ����

public class UserDTO {

	// 1. ���� ����
	private String id;
	private String pw;
	private String name;
	// �̹��� �ڷ����� MultipartFile�� �޴� ����
	private MultipartFile image;

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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	// 3. toString()
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", image=" + image + "]";
	}

}
