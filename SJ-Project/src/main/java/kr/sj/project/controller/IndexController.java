package kr.sj.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/*")
public class IndexController {

	@GetMapping
	public ModelAndView index() { 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}
