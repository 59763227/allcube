package com.gl.allcube.cube.test.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import com.gl.allcube.cube.common.datasource.DataSourceFactory;
import com.gl.allcube.cube.test.mybatis.dao.UserDao;
import com.gl.allcube.cube.test.mybatis.vo.User;

public class SimpleMybatisTest {
	static String TEST_USER_OID = "0";
	
	@Test
	public void testBuildSqlSessionFactoryFromXml() throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  User user = (User) session.selectOne("com.gl.allcube.cube.test.mybatis.dao.UserDao.selectUserByOid", TEST_USER_OID);
		  
		  System.out.println("from xml:"+user);
		} finally {
		  session.close();
		}
		
	}
	
	@Test
	public void testBuildSqlSessionFactoryFromCode() {
		DataSource dataSource = new DataSourceFactory().getDruidDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(UserDao.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  User user = (User) session.selectOne("com.gl.allcube.cube.test.mybatis.dao.UserDao.selectUserByOid", TEST_USER_OID);
		  
		  System.out.println("from code:"+user);
		} finally {
		  session.close();
		}
	}
	
	
}
