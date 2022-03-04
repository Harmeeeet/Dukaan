package com.dukaan.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dukaan.demo.model.ItemModel;
import com.dukaan.demo.repo.ItemRepo;

@Service
public class ItemService {
    @Autowired
    ItemRepo repo;
    
	ArrayList<Integer> items;
	int sum=0;
	
	public void save(ItemModel item) {
		repo.save(item);
	}
	public List<ItemModel> listAll(){
		return repo.findAll();
	}
//	public void add(ItemModel item) {
//		items.add(item.price());
//	}
	
	public void  total() {
		for(int i : items) {
			sum=sum+i;
		}
	}
	public ItemModel getByid(int i) {
		ItemModel model=repo.findById(i).get();
		return model;
	}
}
