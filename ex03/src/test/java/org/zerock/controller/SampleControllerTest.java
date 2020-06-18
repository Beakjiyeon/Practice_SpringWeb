package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.domain.Ticket;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;
//테스트 시 사용할 클래스지정
@RunWith(SpringJUnit4ClassRunner.class)
//Test for Controller 
@WebAppConfiguration
@ContextConfiguration({ 
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class SampleControllerTest {
	@Test 
	public void testConvert() throws Exception {
		Ticket ticket = new Ticket(); 
		ticket.setTno(123); 
		ticket.setOwner("Admin"); 
		ticket.setGrade("AAA");
		String jsonStr = new Gson().toJson(ticket); 
		// Java 객체를 JSON 문자열로 변환 log.info( jsonStr);
		/*
		mockMvc.perform(post("/sample/convert")
				.contentType(MediaType.APPLICATION_JSON) 
				.content( jsonStr))
				.andExpect(status().is(200));
					*/	
		}

}
