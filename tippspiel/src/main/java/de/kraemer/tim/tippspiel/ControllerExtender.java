package de.kraemer.tim.tippspiel;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import de.kraemer.tim.tippspiel.account.Account;
import de.kraemer.tim.tippspiel.player.Player;
import de.kraemer.tim.tippspiel.room.Room;
import de.kraemer.tim.tippspiel.security.CustomUser;

public class ControllerExtender {

	public static void InsertHeaderModelAttributes(Model model) {
		Account account = GetLoggedInUserAccount();
		if (account != null) {
			// Räume hinzufügen
			Set<Room> rooms = new HashSet<Room>();
			for (Player player : account.getPlayers()) {
				rooms.add(player.getRoom());
			}

			model.addAttribute("rooms", rooms);
		}
	}

	public static Account GetLoggedInUserAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal != null && principal instanceof CustomUser) {
			return ((CustomUser) principal).getAccount();
		}

		return null;
	}
}
