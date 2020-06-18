package org.zerock.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//테스트 시 사용할 클래스지정
@RunWith(SpringJUnit4ClassRunner.class)
//Test for Controller 
@WebAppConfiguration
@ContextConfiguration({ 
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTests {
	@Setter(onMethod_ = @Autowired) 
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	// 모든 테스트 메소드 실행전에 수행하라
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void  testList() throws Exception{
		// 요청 후  모델을  얻음
		// key=value를 찍음
		// 예시 INFO : org.zerock.controller.BoardControllerTests - {list=[BoardVO(bno=1, title=제목 수정합니다., content=텍스트 내용, writer=user00, regdate=Tue Jun 02 13:26:31 KST 2020,
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}
	@Test
	public void testRegister() throws Exception{
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders
						.post("/board/register")
						.param("title", "테스트 새글 제목")
						.param("content", "테스트 새글 내용")
						.param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	@Test
	public  void testModify() throws Exception{
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders
						.post("/board/modify")
						.param("bno", "1")
						.param("title", "수정된 테스트 새글 제목")
						.param("content", "수정된 테스트글 내용")
						.param("writer", "수정된 user00"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	@Test
	public  void testRemove() throws Exception{
		// 삭제전 데이터베이스에 게시물 번호 확인할 것 
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "1"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);
	}
}
