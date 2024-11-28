package com.project.pan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pan.entity.PanCard;
import com.project.pan.exception.PanCardException;
import com.project.pan.repository.PanCardRepository;



@Service
public class PanCardServiceImpl  implements PanCardService{
 
	
	@Autowired
	PanCardRepository panCardRepository;
	
	
	@Override
	public String submitPanApplication(PanCard panCard) {
		
		 PanCard savedPanCard = panCardRepository.save(panCard);
		 return "PAN card application submitted successfully with ID: " + savedPanCard.getId();
		 
		}

	@Override
	public PanCard getPanStatus(Long id) {
//		Optional<PanCard> panCard = panCardRepository.findById(id);
//        if (panCard.isPresent()) {
//            return panCard.get();
//        } else {
//            throw new RuntimeException("PAN card not found for id: " + id);
//        }
		
		return panCardRepository.findById(id).orElseThrow(()->new PanCardException("PanCard staus sill pending"));
	}
	
	
	@Override
	public PanCard savePanCard(PanCard panCard) {
		return panCardRepository.save(panCard);
	
	}

	@Override
	public List<PanCard> getAllPanCards() {
	    return panCardRepository.findAll();
		
	}

	@Override
	public PanCard getPanCardByNumber(String panNumber) {
	  return  panCardRepository.findByPanNumber(panNumber);
	
	}

	@Override
	public void deletePanCard(Long id) {
//		panCardRepository.deleteById(id);
		
		panCardRepository.findById(id).orElseThrow(()->new PanCardException("PanCard Accound id does not exist"));
		panCardRepository.deleteById(id);
		
	}

	
	
	
	
		
	}


