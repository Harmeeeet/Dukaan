package com.dukaan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dukaan.demo.model.DukaanModel;
import com.dukaan.demo.service.DukaanService;

@Controller
public class DukaanController {

	@Autowired
	DukaanService service;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("loginuser", new DukaanModel());
		return mv;
	}
	
	@RequestMapping("/checkuser")
	public ModelAndView checkuser(@ModelAttribute("loginuser") DukaanModel duk) {
		
		if(service.checkuser(duk)==true) {
			DukaanModel newuser=service.get(duk);
			ModelAndView mv=new ModelAndView("homepage");
			mv.addObject("user",newuser);
			return mv;
		}
		else {
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("invaliduser","Invalid Username or Password");
			return mv;
		}
	}
	
}
