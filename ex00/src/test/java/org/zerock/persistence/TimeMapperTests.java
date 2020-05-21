package org.zerock.persistence;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;
import org.zerock.sample.HotelTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
//테스트 시 사용할 클래스지정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	@Setter(onMethod_= {@Autowired})
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("=======지연_Mapper 인터페이스시작=====");
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
		log.info("=======지연_Mapper 인터페이스 끝======");
	}
	@Test
	public void testGetTime2() {
		log.info("=======지연_xml과 Mapper 인터페이스시작=====");
		log.warn("getTime2");
		log.info(timeMapper.getTime2());
		log.info("=======지연_xml과 Mapper 인터페이스 끝======");
	}
}
