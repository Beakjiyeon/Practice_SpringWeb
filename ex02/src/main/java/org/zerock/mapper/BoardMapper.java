package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	// 게시물 목록 얻기
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList(); 
	
	// 게시물 삽입
	public void insert(BoardVO board); 
	public Integer insertSelectKey(BoardVO board); // key 반환
	
	// 게시글 조회
	public BoardVO read(Long bno); 
	
	// 게시물 삭제
	public int delete(Long bno);// 삭제된 글 갯수 반환

}
