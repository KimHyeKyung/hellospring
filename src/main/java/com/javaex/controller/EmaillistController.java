package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaex.dao.EmaillistDao;
import com.javaex.vo.EmaillistVo;

@Controller
public class EmaillistController {

	// EmaillistDao emaillistDao = new EmaillistDao();으로 원래 객체생성을 했지만
	// DI(객체 주입)으로인해 @Autowired로 자동으로 new키워드로 객체생성을 한것처럼 작동한다.
	@Autowired
	EmaillistDao dao;

	@RequestMapping("/getEmailList")
	public ModelAndView getEmailList(ModelAndView mav) {
		System.out.println(">>> " + this.getClass() + " 호출됨!");

		mav.addObject("emailList", dao.getList());
		mav.setViewName("/WEB-INF/views/getEmailList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute EmaillistVo emaillistVo) {
		System.out.println("add");
		System.out.println(emaillistVo);
		dao.insert(emaillistVo);
		
		return "redirect:/getEmailList";
	}
	
	//방법1. controller @PathVariable활용, getEmailList.jsp에서 href="/hellospring/delete/${email.no}"형태
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
	public String delete(@PathVariable("no") int no) {
		System.out.println("delete");
		dao.delete(no);
		
		return "redirect:/getEmailList";
	}
	
	//방법2. controller @RequestParam활용, getEmailList.jsp에서 href="/hellospring/delete?no=${email.no}"형태
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String delete(@RequestParam("no") int no) {
//		System.out.println("delete");
//		dao.delete(no);
//		
//		return "redirect:/getEmailList";
//	}
}