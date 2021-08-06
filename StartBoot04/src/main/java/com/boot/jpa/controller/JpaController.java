package com.boot.jpa.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.JpaDao;
import com.boot.jpa.model.dto.JpaDto;

@Controller
@RequestMapping("/member")
public class JpaController {

	@Autowired
	private JpaDao dao;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		
		model.addAttribute("list", dao.findAll(Sort.by(Sort.Direction.DESC, "myno")));
		
		return "jpalist";
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		return "jpainsert";
	}
	
	@PostMapping("/insertres")
	public String insertRes(JpaDto dto) {
		
		dto.setMydate(new Date());
		dao.save(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto", dao.findByMyno(myno));
		
		return "jpadetail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(Model model, int myno) {
		
		model.addAttribute("dto", dao.findByMyno(myno));
		
		return "jpaupdate";
	}
	
	@PostMapping("/updateres")
	public String updateRes(JpaDto dto) {
		
		dao.saveAndFlush(dto);
		
		return "redirect:detail?myno="+dto.getMyno();	
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		
		dao.deleteByMyno(myno);
		
		return "redirect:list";
	}
	
}
