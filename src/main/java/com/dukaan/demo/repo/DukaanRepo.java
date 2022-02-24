package com.dukaan.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dukaan.demo.model.DukaanModel;

public interface DukaanRepo extends JpaRepository<DukaanModel,String>{

}
