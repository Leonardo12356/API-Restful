package org.serratec.java2backend.projeto02.service;

import java.util.Arrays;
import java.util.List;
import org.serratec.java2backend.projeto02.model.PetShop;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	private List<PetShop> pets = Arrays.asList(new PetShop("Frajola", "gato", 4.5),
			new PetShop("Labrador", "cachorro", 15.5), 
			new PetShop("Maltes", "cachorro", 10.5));

	public List<PetShop> listaPetShop() {
		return this.pets;
	}
}
