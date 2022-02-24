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
	public boolean checkuser(DukaanModel duk) {
		
		if(repo.existsById(duk.getUser_id())) {
			DukaanModel user=repo.getById(duk.getUser_id());
			if(user.getPassword()==(duk.getPassword())) {
			return true;
			}
		}
	
			return false;
		
	}
	public DukaanModel get(DukaanModel duk) {
		return repo.getById(duk.getUser_id());
	}
}
