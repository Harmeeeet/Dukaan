package com.dukaan.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dukaan.demo.model.DukaanModel;
import com.dukaan.demo.model.ItemModel;
import com.dukaan.demo.service.DukaanService;
import com.dukaan.demo.service.ItemService;

@Controller
public class DukaanController {

	@Autowired
	DukaanService service;
	@Autowired
	ItemService tservice;
	@RequestMapping("/")
	public String homepage() {
		return "/homepage";
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("loginuser", new DukaanModel());
		return mv;
	}
	
	@RequestMapping("/checkuser")
	public ModelAndView checkuser(@ModelAttribute("loginuser") DukaanModel duk) {
		String modelid=duk.getUser_id();
		if(service.checkuser(duk)==true) {
			DukaanModel newuser=service.get(modelid);
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
	@GetMapping("/newaccount")
		public ModelAndView newaccount() {
			ModelAndView mv=new ModelAndView("newaccount");
			DukaanModel md=new DukaanModel();
			mv.addObject("newaccount",md);
			return mv;
		}
	@PostMapping(value="/save")
	public ModelAndView save(@ModelAttribute("newaccount") DukaanModel dukaan) {
		if(service.checknewuser(dukaan))
		{
			service.save(dukaan);
			ModelAndView mv = new ModelAndView("redirect:http://localhost:8080/login");
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView("newaccount");
			mv.addObject("newaccount", dukaan);
			mv.addObject("alreadyexists","UserID already exists!");
			return mv;
		}
		
	}
	@RequestMapping("/additem")
	public ModelAndView additem(ItemModel t) {
		ModelAndView mv=new ModelAndView("items");
		t=new ItemModel();
		mv.addObject("item", t);
		return mv;
	}
	@PostMapping("/saveitem")
	public String saveitem(@ModelAttribute("item") ItemModel i) {
		tservice.save(i);
		return "redirect:/additem";
	}
	List<Integer> item_ids=new ArrayList<>();
	@RequestMapping("/addtocart")
	public String addtocart(ItemModel it) {
		//ModelAndView mv=new ModelAndView("");
		
		item_ids.add(it.getItem_id());
		return "redirect:/homepage";
	}
	@RequestMapping("/gottocart")
	public ModelAndView cart() {
		ModelAndView mv=new ModelAndView("cart");
		mv.addObject("listofitems", item_ids);
		return mv;
	}
}
