package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MYBiz;
import com.boot.jdbc.model.dto.MYDto;

@Controller
@RequestMapping("/myboard")		// 클래스에 리퀘스트 매핑했을때? 
public class MYController {
	
	@Autowired
	private MYBiz biz;

	@GetMapping("/list")
	public String selectList(Model model) {
		model.addAttribute("list", biz.selectList());
		return "myboardlist";
	}
	
	@GetMapping("/select")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardselect";
		
	}
	
	@GetMapping("/update")
	public String update(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardupdate";
	}
	
	@GetMapping("/updateres")
	public String updateRes(MYDto dto) {
		
		if(biz.update(dto) > 0) {
			return "redirect:select?myno="+dto.getMyno();
		}
		
		return "redirect:/myboard/update?myno="+dto.getMyno();
		
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		
		if(biz.delete(myno) > 0) {
			return "redirect:list";
		}
		
		return "redirect:/myboard/select?myno="+myno;
		
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		return "myboardinsert";
	}
	
	@PostMapping("/insertres")
	public String insertRes(MYDto dto) {
		
		if (biz.insert(dto) > 0) {
			return "redirect:/myboard/list";
		}
		
		return "redirect:/myboard/insertform";
	}
}
