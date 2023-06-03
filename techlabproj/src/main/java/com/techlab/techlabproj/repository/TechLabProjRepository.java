package com.techlab.techlabproj.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techlab.techlabproj.model.Cadastro;

@Repository
public interface TechLabProjRepository extends JpaRepository<Cadastro, UUID>{

	
	
}
