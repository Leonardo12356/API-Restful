package org.serratec.java2backend.projeto02.controller;

import java.util.List;

import org.serratec.java2backend.projeto02.model.PetShop;
import org.serratec.java2backend.projeto02.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

	@Autowired
	PetService petService;

	@RequestMapping("/pets")
	public List<PetShop> getPetShop(){
		return petService.listaPetShop();
		}
}
