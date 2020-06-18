package org.zerock.mapper;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.DataSourceTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
//테스트 시 사용할 클래스지정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	//
	@Setter(onMethod_= @Autowired)
	private BoardMapper  mapper;
	@Test
	public void testGetList(){
		//  board 변수는 각 게시물 하나하나를 가리킨다.
		mapper.getList().forEach(board->log.info(board)); 
	}
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO(); 
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용"); 
		board.setWriter("newbie");
		mapper.insert(board);
		
		log.info(board);
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO(); 
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key"); 
		board.setWriter("newbie");
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	@Test
	public void  testRead() {
		BoardVO  board=mapper.read(5L); // 5번 게시글 조회
		log.info(board);
	}
	@Test
	public void testDelete() {
		int count=mapper.delete(3L);  // 3번 게시물삭제
		log.info("Delete COUNT: "+count);
	}
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO(); 
		// 실행전 존재하는 번호인지 확인할 것
		board.setBno(5L); 
		board.setTitle("수정된 제목"); 
		board.setContent("수정된 내용"); 
		board.setWriter("user00");
		int count = mapper.update(board); 
		log.info("UPDATE COUNT: " + count);
	}
	
}
