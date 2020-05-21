package org.zerock.persistence;

import static org.junit.Assert.fail;
import java.sql.DriverManager;
import java.sql.Connection;
import org.junit.Test;
import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	// 지연: jdbc 드라이버 로드 : 오라클 접속을 도와주는 모듈
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		try(Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE","book_ex","1111"				
				)){
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
