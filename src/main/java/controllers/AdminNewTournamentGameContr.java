package controllers;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import models.TournamentGameModelImpl;
import tournamentPlay.TournamentCommand;
import tournamentPlay.TournamentGame;

@Controller
public class AdminNewTournamentGameContr {
	private static final DateTimeFormatter FORMATTER = DateTimeFormat
			.forPattern("dd-MM-yyyy HH:mm");
	
	@Autowired
	private TournamentCommand tournamentCommand;
	
	@Autowired
	private TournamentGame tournamentGame;
	
	@RequestMapping(value = "/new-tournament-game", method = RequestMethod.GET)
	public String name(Model model) {
        model.addAttribute("tournamentGame", new TournamentGameModelImpl());
        model.addAttribute("tournamentCommands", tournamentCommand.getAllCommands());
		return "newTournamentGame";
	}
	
	@RequestMapping(value = "/new-tournament-game", method = RequestMethod.POST)
	public String name(@ModelAttribute("tournamentGame") 
	TournamentGameModelImpl tournamentGameModel, @RequestParam("startDate") String date) 
	 {
		tournamentGameModel.setStartGameDate(FORMATTER.parseDateTime(date));
        if(tournamentGame.createGame(tournamentGameModel)){
        	return "/show-tournament-game/"+tournamentGameModel.getIdTournamentGame();
        }
		return "newTournamentGame";
	}

}
