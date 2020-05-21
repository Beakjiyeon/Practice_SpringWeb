package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 테스트 시 사용할 클래스지정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {
	// restaurant와 chef를 테스트
	
	@Setter(onMethod_= {@Autowired})
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void  testExist(){
		// 인자가 null이닞 확인한다.
		assertNotNull(restaurant); 
		
		// log4j 사용하기 restaurant 객체 출력 
		log.info(restaurant);
		log.info("-------------------------------------------------------------");
		
		// Restaurant 객체 호출해봄
		log.info(restaurant.getChef());
	}
}
