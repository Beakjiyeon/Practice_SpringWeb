package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.Setter;
import lombok.extern.log4j.Log4j;

//테스트 시 사용할 클래스지정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	@Setter(onMethod_= {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_= {@Autowired})
	private  SqlSessionFactory  sqlSessionFactory;
	
	@Test
	public void  testConnection() {
		try(Connection con=dataSource.getConnection()){
			log.info("=====지연_hikari 커넥션 풀 시작=====");
			log.info(con);
			log.info("=====지연_hikari 커넥션 풀 끝=====");
		}catch(Exception e) {
			fail(e.getMessage());
		}	
	}
	
	// mybatis 테스트위해
	@Test
	public  void testMyBatis() {
		try(SqlSession session=sqlSessionFactory.openSession();
				Connection con=session.getConnection();){
			log.info("=====지연_mybastis 테스트 시작=====");
			log.info(session);
			log.info(con);
			log.info("=====지연_mybastis 테스트 끝=====");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
