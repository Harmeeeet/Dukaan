package com.dukaan.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
   private boolean isLogged=false;
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("homepage");
		List<ItemModel> list=tservice.listAll();
		mv.addObject("listofitems", list);
		mv.addObject("isLogged",isLogged);
		return mv;
	}
	
		

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView("login");
	
		mv.addObject("loginuser", new DukaanModel());
		isLogged=false;
		return mv;
	}
	
	@RequestMapping("/checkuser")
	public ModelAndView checkuser(@ModelAttribute("loginuser") DukaanModel duk) {
		
		
		String modelid=duk.getUser_id();
		if(service.checkuser(duk)==true) {
			DukaanModel newuser=service.get(modelid);
			ModelAndView mv=new ModelAndView("redirect:/");
			mv.addObject("user",newuser);
			isLogged=true;
			mv.addObject("isLogged",isLogged);
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
		i.setName(i.getBrand()+" "+i.getColor());
		tservice.save(i);
		return "redirect:/additem";
	}
	List<ItemModel> item_ids=new ArrayList<>();
	@RequestMapping("/addtocart/{item_id}")
	public String addtocart(@PathVariable("item_id") int i) {
		//ModelAndView mv=new ModelAndView("");
		
		item_ids.add(tservice.getByid(i));
		return "redirect:/";
	}
	
	@RequestMapping("/gotocart")
	public ModelAndView cart() {
		ModelAndView mv=new ModelAndView("cart");
		mv.addObject("listofitems", item_ids);
		return mv;
	}
}
