package de.kraemer.tim.tippspiel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.kraemer.tim.tippspiel.Entities.Card;
import de.kraemer.tim.tippspiel.repositories.CardRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/card") // This means URL's start with /demo (after Application path)
public class CardController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private CardRepository cardRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Card> Cards() {
		// This returns a JSON or XML with the users
		return cardRepository.findAll();
	}
}