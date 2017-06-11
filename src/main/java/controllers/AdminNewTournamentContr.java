package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.TournamentModelImpl;
import tournamentPlay.Tournament;

@Controller
public class AdminNewTournamentContr {
	
	@Autowired
	private Tournament tournamentImpl;

	@RequestMapping(value = "/new-tournament", method = RequestMethod.GET)
	public String name(Model model) {
        model.addAttribute("tournament", new TournamentModelImpl());
		return "newTournament";
	}
	
	@RequestMapping(value = "/new-tournament", method = RequestMethod.POST)
	public String name(@ModelAttribute("tournament") TournamentModelImpl tournamentModel) {
        if(tournamentImpl.createTournament(tournamentModel)){
        	return "redirect:/show-tournament";
        }
		return "newTournament";
	}
}
