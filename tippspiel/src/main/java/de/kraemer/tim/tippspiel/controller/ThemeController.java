package de.kraemer.tim.tippspiel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.kraemer.tim.tippspiel.Entities.Theme;
import de.kraemer.tim.tippspiel.repositories.ThemeRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/theme") // This means URL's start with /demo (after Application path)
public class ThemeController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private ThemeRepository themeRepository;
		
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewTheme (@RequestParam String title, @RequestParam String description) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Theme theme = new Theme();
		theme.setDescription(description);
		theme.setTitle(title);
		themeRepository.save(theme);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Theme> Themes() {
		// This returns a JSON or XML with the users
		return themeRepository.findAll();
	}
}