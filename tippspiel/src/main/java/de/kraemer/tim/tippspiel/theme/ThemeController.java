package de.kraemer.tim.tippspiel.theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.kraemer.tim.tippspiel.ControllerExtender;
import de.kraemer.tim.tippspiel.cardtype.CardType;
import de.kraemer.tim.tippspiel.cardtype.CardTypeData;
import de.kraemer.tim.tippspiel.cardtype.CardTypeRepository;
import de.kraemer.tim.tippspiel.room.Room;
import de.kraemer.tim.tippspiel.room.RoomData;
import de.kraemer.tim.tippspiel.room.RoomRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/theme") // This means URL's start with /demo (after Application path)
public class ThemeController {
	@Autowired
	private ThemeRepository themeRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private CardTypeRepository cardTypeRepository;
	
	@ModelAttribute
    public void addAttributes(Model model) {
        ControllerExtender.InsertHeaderModelAttributes(model);
    }
	
	@GetMapping(path="/list")
	public String Rooms(Model model) {
        model.addAttribute("themeData", new ThemeData());
        model.addAttribute("roomData", new RoomData());
        model.addAttribute("cardTypeData", new CardTypeData());
		model.addAttribute("themes", themeRepository.findAll());
		return "themes";
	}
	
	@PostMapping(path="/add")
	public String addNewTheme (ThemeData themeData) {
		Theme theme = new Theme();
		theme.setDescription(themeData.getDescription());
		theme.setTitle(themeData.getTitle());
		themeRepository.save(theme);
		return "redirect:/theme/list";
	}
	
	@GetMapping(path="/{id}/show")
	public String ShowRoomByID(@PathVariable int id, Model model) {
		model.addAttribute("theme",themeRepository.findOne(id));
		return Rooms(model);
	}
	
	@PostMapping(path="/{id}/createRoom")
	public String CreateRoom(@PathVariable int id, Model model, RoomData roomData) {
		Theme theme = themeRepository.findOne(id);
		
		Room room = new Room();
		room.setTheme(theme);
		room.setName(roomData.getName());
		room.setCode(roomData.getCode());
		theme.getRooms().add(room);
		roomRepository.save(room);
		
		model.addAttribute("theme", theme);
		return Rooms(model);
	}
	
	@PostMapping(path="/{id}/createCardType")
	public String CreateCardType(@PathVariable int id, Model model, CardTypeData cardTypeData) {
		Theme theme = themeRepository.findOne(id);
		
		CardType cardType = new CardType();
		cardType.setTheme(theme);
		cardType.setTitle(cardTypeData.getTitle());
		cardType.setDescription(cardTypeData.getDescription());
		theme.getCardTypes().add(cardType);
		
		cardTypeRepository.save(cardType);
		
		model.addAttribute("theme", theme);
		return Rooms(model);
	}
}