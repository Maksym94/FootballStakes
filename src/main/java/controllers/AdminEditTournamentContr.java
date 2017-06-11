package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tournamentPlay.Tournament;

@Controller
public class AdminEditTournamentContr {
	
	@Autowired
	private Tournament tournamentImpl;

	@RequestMapping(value = "/show-tournament", method = RequestMethod.GET)
	public String name(Model model) {
        model.addAttribute("tournament", tournamentImpl.getLastTournament());
		return "showTournament";
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.POST)
	public String name() {

		return "";
	}*/
}
