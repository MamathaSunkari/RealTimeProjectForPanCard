package com.project.pan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pan.entity.PanCard;
import com.project.pan.service.PanCardService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pan")
@Validated
public class PanCardController {
	
	@Autowired
	PanCardService panCardService;
	
	@PostMapping("/submit")
	public String submitPanApplication(@Valid @RequestBody PanCard panCard) {
		
		return  panCardService.submitPanApplication(panCard) ;
	
	}
	@GetMapping("/status/{id}")
	public PanCard getPanStatus(@PathVariable Long id) {
		  return panCardService.getPanStatus(id);
		
	}
	@PostMapping("/save")
	public PanCard savePanCard(@RequestBody PanCard panCard) {
		return panCardService.savePanCard(panCard);
	
	}
	@GetMapping("/list")
	public List<PanCard> getAllPanCards() {
		List<PanCard> list = panCardService.getAllPanCards();
		return list;
		
	}
	@GetMapping("/number/{panNumber}")
	public PanCard getPanCardByNumber( @PathVariable String panNumber) {
		return panCardService.getPanCardByNumber(panNumber);
	}
	@DeleteMapping("/delete/{id}")
	public void deletePanCard(@PathVariable Long id) {
		panCardService.deletePanCard(id);
	}
	
	
}
