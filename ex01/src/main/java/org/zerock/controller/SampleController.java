package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.ToDoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	//@RequestMapping("/basic")
	//@RequestMapping(value="/basic2",method= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping("/basic3")
	public void basic() {
		log.info("basic...");
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		return "ex01";
		
	}
	@GetMapping("/ex02")
	public String  ex02(@RequestParam("name1") String name,@RequestParam("age1") int age) {
		log.info("name: "+name);
		log.info("age: "+age);
		return "ex02";
	}
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : "+ids);
		return "ex02List";
	}
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids :"+Arrays.toString(ids));
		return "ex02Array";
	}
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList  list) {
		log.info("list dtos: "+list );
		return "ex02bean";
	}
	@GetMapping("/ex03")
	public String ex03(ToDoDTO todo) {
		log.info("todo :"+todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
		log.info("dto :"+dto);
		log.info("page:"+page);
		return "/sample/ex04"; // view 호출.SampleDTO는 자동으로 전달되지만, PAGE는 INT형이라 전달X
	}
	@GetMapping("/ex05")
	public void ex05() {
		
	}
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/EX06...");
		SampleDTO dto=new SampleDTO();
		dto.setAge(10);
		dto.setName("bjy");
		return dto;
	}

}
