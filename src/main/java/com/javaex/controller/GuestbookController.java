package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaex.dao.GuestbookDao;

@Controller
public class GuestbookController {

	// GuestbookDao guestbookDao = new GuestbookDao();으로 원래 객체생성을 했지만
	// 의존성주입으로인해 @Autowired로 자동으로 new키워드로 객체생성을 한것처럼 작동한다.
	@Autowired
	GuestbookDao guestbookDao;

	@RequestMapping("/getGuestbookList")
	public ModelAndView getGuestbookList(ModelAndView mav) {
		System.out.println(">>> " + this.getClass() + " 호출됨!");

		//mav = new ModelAndView(); 

		mav.addObject("guestbookList", guestbookDao.getList());
		mav.setViewName("/WEB-INF/views/getGuestbookList.jsp");
		// mav.setViewName( "getGuestbookList" ); ->spring-servlet.xml에 주석되어있음(기본 뷰 리졸버)
		return mav;
	}

}