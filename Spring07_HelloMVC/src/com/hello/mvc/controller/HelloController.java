package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

@Controller
public class HelloController {
	
	@Autowired
	private HelloBiz biz;
	
	// TODO : 03. handlerMapping(/hello.do) 을 통해 해당 컨트롤러의 메소드로 request 전달
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		// Model : 모델 객체를 만든 적이 없는데 어디서 났어? 스프링이 알아서 객체 만들어서 우리한테 줬어
		
		
		// TODO : 04. biz(@Service) 호출
		model.addAttribute("message", biz.getHello());
		
		// TODO : 08. return 받은 값을 model 객체에 담아서, ModelAndView 객체를 전달
		// String으로 리턴하면 ModelAndView 객체를 전달, 이걸 다시 hello-servlet.xml(DispatcherServlet의 설정파일)에게 준다.
		return "/WEB-INF/views/hello.jsp";		// ViewName  (어떤 view를 response해줄건지를 return)
	}
	
	// TODO : 10. HandlerMapping(/bye.do)
	// 옛날 방식임!
	@RequestMapping("/bye.do")
	public ModelAndView getBye(@RequestParam("name") String name) {   //@RequestParam("name") 생략 가능
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "Bye, " + name);
		mav.setViewName("/WEB-INF/views/bye.jsp");
		
		return mav;
	}

}
