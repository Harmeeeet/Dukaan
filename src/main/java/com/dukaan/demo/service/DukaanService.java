package com.dukaan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dukaan.demo.model.DukaanModel;
import com.dukaan.demo.repo.DukaanRepo;

@Service
public class DukaanService {

	@Autowired
	DukaanRepo repo;
	
	public void save(DukaanModel duk) {
		repo.save(duk);
	}
	public DukaanModel get(String id) {
		return repo.findById(id).get();
	}
	public boolean checkuser(DukaanModel md) {
		String mid=md.getUser_id();
		if(repo.existsById(mid)) {
			DukaanModel user=get(mid);
			System.out.print(user);
			if(user.getPassword().equals(md.getPassword())) {
			return true;
			}
		}
	
			return false;
		
	}
	
}
