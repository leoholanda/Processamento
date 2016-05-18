package br.com.hemocentro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/processamento")
public class IndexController {
	
	@RequestMapping("/index")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}

}
