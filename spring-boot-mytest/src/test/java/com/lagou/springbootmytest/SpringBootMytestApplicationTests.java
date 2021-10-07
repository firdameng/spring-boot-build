package com.lagou.springbootmytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMytestApplicationTests {

/*	@Autowired
	private SimpleBean simpleBean;

	@Test
	void contextLoads() {
		System.out.println(simpleBean);
	}*/


	@Autowired
	DataSource dataSource;


	@Test
	public void test1() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

}
