package com.project.pan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pan.entity.PanCard;



public interface PanCardRepository extends JpaRepository<PanCard, Long> {

	
	PanCard findByPanNumber(String panNumber);
	
	
}
