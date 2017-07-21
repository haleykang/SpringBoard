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

	@Inject // @Autowired와 같은 기능
	private DataSource ds;

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void testSql() throws Exception {

		try {
			System.out.println(sqlSession);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test // 테스트를 위한 코드임을 선언
	public void testConnection() throws Exception {
		Connection con = null;
		try {

			con = ds.getConnection();
			System.out.println(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
