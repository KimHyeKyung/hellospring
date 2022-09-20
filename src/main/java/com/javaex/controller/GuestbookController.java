package com.javaex.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	// GuestbookDao guestbookDao = new GuestbookDao();으로 원래 객체생성을 했지만
	// DI(객체 주입)으로인해 @Autowired로 자동으로 new키워드로 객체생성을 한것처럼 작동한다.
	@Autowired
	GuestbookDao guestbookDao;

	@RequestMapping("/getGuestbookList")
	public ModelAndView getGuestbookList(ModelAndView mav) {
		System.out.println(">>> " + this.getClass() + " 호출됨!");
		mav.addObject("guestbookList", guestbookDao.getList());
		mav.setViewName("/WEB-INF/views/getGuestbookList.jsp");
		
		return mav;
	}
	
	//삽입
	@RequestMapping(value = "/addGuestbook", method = RequestMethod.POST)
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println(guestbookVo);
		guestbookDao.insert(guestbookVo);
		
		return "redirect:/getGuestbookList";
	}
	
	//삭제확인폼 이동
	@RequestMapping(value = "/gbDeleteConfirm/{no}", method = RequestMethod.GET)
	public String deleteConfirm(@PathVariable("no") int no) {
		
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	//삭제
	@RequestMapping(value = "/gbDelete", method = RequestMethod.POST)
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		int result = guestbookDao.delete(vo);
		
		if(result > 0) {
			return "redirect:/getGuestbookList";
		}else {
			return "/WEB-INF/views/deleteError.jsp";
		}
		
	}
	
	
	
}