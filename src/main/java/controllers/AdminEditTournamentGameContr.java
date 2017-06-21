package controllers;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import models.TournamentGameModelImpl;
import tournamentPlay.TournamentGame;

@Controller
public class AdminEditTournamentGameContr {
	private static final DateTimeFormatter FORMATTER = DateTimeFormat
			.forPattern("dd-MM-yyyy HH:mm");
	
	@Autowired
	private TournamentGame tournamentGame;

	@RequestMapping(value = "/edit-tournament-game/{id}")
	public String editTournamentGame(@PathVariable("id") int id,Model model) {
		TournamentGameModelImpl game =  tournamentGame.getGame(id);
		model.addAttribute("startDate", game.getStartGameDate().toString(FORMATTER));
        model.addAttribute("tournamentGame",game);
		return "editTournamentGame";
	}
	
	 @RequestMapping(value = "/edit-tournament-game", method = RequestMethod.POST)
	public String confirmEditTournamentGame(@ModelAttribute("tournamentGame") 
	TournamentGameModelImpl tournamentGameModel, @RequestParam("startDate") String date) {
		tournamentGameModel.setStartGameDate(FORMATTER.parseDateTime(date));
        tournamentGame.updateGame(tournamentGameModel);
		return "redirect:/show-tournament-game/"+tournamentGameModel.getIdTournamentGame();
	}
	 
	 @RequestMapping(value = "/delete-tournament-game/{id}")
		public String deleteTournamentGame(@PathVariable("id") int id) {
            tournamentGame.deleteGame(tournamentGame.getGame(id));
			return "redirect:/show-tournament-games/";
		}
	 
	 @RequestMapping(value = "/show-tournament-game/{id}")
	public String showTournamentCommand(@PathVariable("id") int id,Model model) {
	TournamentGameModelImpl game =  tournamentGame.getGame(id);
	if(game!=null)
		 model.addAttribute("startDate", game.getStartGameDate().toString(FORMATTER));
		 model.addAttribute("tournamentGame", game);
		return "showTournamentGame";
	}
	 @RequestMapping(value = "/show-tournament-games", method = RequestMethod.GET)
	public String showTournamentCommands(Model model) {
        model.addAttribute("tournamentGames", tournamentGame.getAllGames());
		return "showTournamentGames";
	}
}
