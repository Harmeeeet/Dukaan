package com.dukaan.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dukaan.demo.model.ItemModel;

public interface ItemRepo extends JpaRepository<ItemModel,Integer> {

}
