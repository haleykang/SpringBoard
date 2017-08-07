package com.haley.myboard;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class TestBoard {

	// 1. �����ͺ��̽� ���� �׽�Ʈ
	@Inject // @Autowired�� ���� ���
	private DataSource ds;

	@Test // �׽�Ʈ�� ���� �ڵ����� ����
	public void testConnection() throws Exception {
		Connection con = null;
		try {

			con = ds.getConnection();
			System.out.println(con); // �ܼ� â�� �ؽ��ڵ� ��� �� ����

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2. SqlSession ���� �׽�Ʈ
	@Autowired
	private SqlSession sqlSession;

	@Test
	public void testSql() throws Exception {

		try {
			System.out.println(sqlSession); // �ܼ� â�� �ؽ��ڵ� ��� �� ����

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
