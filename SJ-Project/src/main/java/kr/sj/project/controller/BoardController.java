package kr.sj.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.sj.project.domain.board.BoardFreeDTO;
import kr.sj.project.domain.board.Criteria;
import kr.sj.project.domain.board.PageDTO;
import kr.sj.project.service.board.FreeBoardService;
import lombok.extern.log4j.Log4j2;



@Log4j2
@RestController
@RequestMapping("/board")
public class BoardController {

	
	@Autowired
	FreeBoardService service;
	
	@GetMapping("/freelist")
	public ModelAndView FreeList(Criteria cri) { 
		log.info("-----자유게시판 리스트");
		log.info(cri);
		ModelAndView mav = new ModelAndView();
		mav.addObject("freelist", service.FreegetList(cri));
		mav.addObject("pageMaker", new PageDTO(cri,service.gettotalcount(cri)));
		mav.setViewName("/board/freelist");
		
		return mav;
	}
	
	@GetMapping("/freeregister")
	public ModelAndView FreeRegisterGET() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/freeregister");
		return mav;
	}
	
	@PostMapping("/freeregister")
	public ModelAndView FreeRegister(BoardFreeDTO freeboard) {
		log.info("freeboard" + freeboard);
		service.register(freeboard);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", freeboard.getIDX());
		mav.setViewName("redirect:/board/freelist");
		return mav;
	}
	
	
	
	@GetMapping("/freeget")
	public ModelAndView Freeget(@RequestParam("IDX") Long IDX, @ModelAttribute("cri") Criteria cri) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("freegettt", service.get(IDX));
		mav.addObject("freelist", service.FreegetList(cri));
		mav.addObject("pageMaker", new PageDTO(cri, service.gettotalcount(cri)));
		
		return mav;
	}
	
	
	@GetMapping("/freemodify")
	public ModelAndView FreegetModify(@RequestParam("IDX") Long IDX, @ModelAttribute("cri") Criteria cri) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("freegettt", service.get(IDX));
		mav.addObject("freelist", service.FreegetList(cri));
		
		return mav;
	}
	
	@PostMapping("/freemodify")
	public ModelAndView FreeModify(BoardFreeDTO freeboard, Criteria cri) {
		service.modify(freeboard);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/freelist");
		mav.addObject("pageNum", cri.getPageNum());
		mav.addObject("amount", cri.getAmount());
		mav.addObject("type", cri.getType());
		mav.addObject("keyword", cri.getKeyword());
		return mav;
	}
	
	@PostMapping("/freeremove")
	public ModelAndView FreeRemove(@RequestParam("IDX") Long IDX) {
		log.info("------삭제----");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/freelist");
		mav.addObject("/freeremove", service.remove(IDX));
		return mav;
	}
	
}
