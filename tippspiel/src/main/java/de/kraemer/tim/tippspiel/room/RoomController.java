package de.kraemer.tim.tippspiel.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.kraemer.tim.tippspiel.ControllerExtender;
import de.kraemer.tim.tippspiel.account.Account;
import de.kraemer.tim.tippspiel.account.AccountRepository;
import de.kraemer.tim.tippspiel.player.Player;
import de.kraemer.tim.tippspiel.player.PlayerRepository;
import de.kraemer.tim.tippspiel.security.CustomUser;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/room") // This means URL's start with /demo (after Application path)
public class RoomController {
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@ModelAttribute
    public void addAttributes(Model model) {
        ControllerExtender.InsertHeaderModelAttributes(model);
    }
	
	@GetMapping(path="/list")
	public String listRooms(Model model) {
		model.addAttribute("rooms", roomRepository.findAll());
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = ((CustomUser) principal).getAccount();
		if (account != null)
			model.addAttribute("account", account);
		return "room/admin";
	}
	
	@GetMapping(path="/join")
	public String joinRoomGet(Model model) {
		model.addAttribute("roomData", new RoomData());
		model.addAttribute("rooms", roomRepository.findAll());
		return "room/join";
	}
	
	@PostMapping(path="/join")
	public String joinRoomPost(RoomData roomData) {
		//ID des angemeldeten Benutzers herausfinden
		Room room = roomRepository.findFirstByCode(roomData.getCode());
		Account account = ControllerExtender.GetLoggedInUserAccount();
		if (account != null && room != null)
		{
			Player player = new Player();
			player.setAccount(account);
			player.setRoom(room);
			playerRepository.save(player);
			
			account.getPlayers().add(player);
			accountRepository.save(account);
		}
		return "room/join";
	}
}