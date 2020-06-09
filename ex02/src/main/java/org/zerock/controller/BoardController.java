package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	//서비스 객체
	private BoardService service;
	
	// 게시물 목록 얻기
	@GetMapping("/list")
	public  void list(Model model) { //자동으로 주입된다.  스프링이  알아서 넣어줌.
		log.info("게시물 목록  얻기 . . .");
		model.addAttribute("list",service.getList()); // key, value
		// return xxx;  xxx는 뷰이름
	}
	
	// 게시물 등록하기
	@GetMapping("/register")
	public void  register() {
		//  뷰이름은  자동으로 register.jsp
	}
	@PostMapping("/register")
	public String register(BoardVO  board,RedirectAttributes rttr) {
		log.info("게시글 등록 . . ."+board);
		service.register(board);
		// redirect할 곳에 결과를 전해줌
		rttr.addFlashAttribute("result",board.getBno());
		// 게시글 등록 후 목록 보여줌
		return "redirect:/board/list"; // 클라이언트에게 목록페이지를 요청하라고 요청함.
	}
	
	// 게시글 수정하기
	@PostMapping("/modify")
	public String modify(BoardVO board,RedirectAttributes rttr) {
		log.info("modify:" + board); 
		if (service.modify(board)) { 
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	// 게시글 삭제하기 -> 삭제후 리스트가 보여지도록
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,RedirectAttributes rttr) {
		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		} 
		return "redirect:/board/list";
	}

}
