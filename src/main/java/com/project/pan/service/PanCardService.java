package com.project.pan.service;

import java.util.List;

import com.project.pan.entity.PanCard;



public interface PanCardService {
	
	 String submitPanApplication(PanCard panCard);
	
      PanCard getPanStatus(Long id);
	
	 PanCard savePanCard(PanCard panCard);
	 
	 List<PanCard> getAllPanCards();
	 
	 PanCard getPanCardByNumber(String panNumber);
	 
	 void deletePanCard(Long id);
	

}
