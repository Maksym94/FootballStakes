package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.TournamentModelImpl;
import tournamentPlay.Tournament;

@Controller
public class AdminEditTournamentContr {
	
	@Autowired
	private Tournament tournamentImpl;

	@RequestMapping(value = "/show-tournament", method = RequestMethod.GET)
	public String name(Model model) {
		TournamentModelImpl lastTournament= tournamentImpl.getLastTournament();
		/*System.out.println("Amount of Stages "+lastTournament.getMaxAmountOfStages());
		for (int i = 0; i < lastTournament.getMaxAmountOfStages(); i++) {
			System.out.println("pow index "+ i+" value " +Math.pow(2, i));
		}*/
		
        model.addAttribute("tournament", lastTournament);
		return "showTournament";
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.POST)
	public String name() {

		return "";
	}*/
}
