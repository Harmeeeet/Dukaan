package com.dukaan.demo.service;

import java.util.Optional;

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
	
	public boolean checkuser(DukaanModel duk) {
		
		if(repo.existsById(duk.getUser_id())) {
			DukaanModel user = repo.findById(duk.getUser_id()).get();
			if(duk.getPassword().equals(user.getPassword())) {
			System.out.print(user);

			return true;
			}
		}
	
			return false;
		
	}

	public boolean checknewuser(DukaanModel dukaan) {
		if(repo.existsById(dukaan.getUser_id()))
		return false;
		else return true;
	}
	
}
