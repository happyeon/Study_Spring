package com.mvc.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JdbcBiz;
import com.mvc.update.model.dto.JdbcDto;

@Controller
public class JdbcController {
	
	@Autowired
	private JdbcBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "jdbclist";
	}
	
	@RequestMapping("/select.do")
	public String selectOne(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "jdbcselect";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "jdbcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(JdbcDto dto) {
		
		if(biz.update(dto) > 0) {
			return "redirect:select.do?seq="+dto.getSeq();
		}
		
		return "redirect:updateform.do?seq="+dto.getSeq();
		
	}
	
	@RequestMapping("/delete.do")
	public String delete(int seq) {
		
		if(biz.delete(seq) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:select.do?seq="+seq;
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		return "jdbcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(JdbcDto dto) {
		
		if (biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:insertform.do";
	}

}
