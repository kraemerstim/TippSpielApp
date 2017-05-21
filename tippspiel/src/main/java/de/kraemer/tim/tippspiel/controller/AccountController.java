package de.kraemer.tim.tippspiel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.kraemer.tim.tippspiel.Entities.Account;
import de.kraemer.tim.tippspiel.Entities.Player;
import de.kraemer.tim.tippspiel.Entities.Room;
import de.kraemer.tim.tippspiel.repositories.AccountRepository;
import de.kraemer.tim.tippspiel.repositories.PlayerRepository;
import de.kraemer.tim.tippspiel.repositories.RoomRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/account") // This means URL's start with /demo (after Application path)
public class AccountController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private AccountRepository accountRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Account account = new Account();
		account.setName(name);
		account.setPassword(password);
		accountRepository.save(account);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Account> Accounts() {
		// This returns a JSON or XML with the users
		return accountRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Account GetAccountByID(@PathVariable int id) {
		return accountRepository.findOne(id);
	}
	
	@GetMapping(path="/{id}/createPlayer")
	public @ResponseBody Player CreateNewPlayer(@PathVariable int id, @RequestParam int roomID)
	{
		Account account = accountRepository.findOne(id);
		Room room = roomRepository.findOne(roomID);
		
		Player player = new Player();
		player.setRoom(room);
		player.setAccount(account);
		playerRepository.save(player);
		return player;
	}
}