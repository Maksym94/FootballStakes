package controllers;

import java.util.List;

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

import models.RegularGameModelImpl;
import regularPlay.RegularGame;

@Controller
public class AdminEditRegularGameContr {
	

	private static final DateTimeFormatter FORMATTER = DateTimeFormat
			.forPattern("dd-MM-yyyy HH:mm");
	
	@Autowired
	private RegularGame regularGame;

	@RequestMapping(value="/show-regular-games", method= RequestMethod.GET)
	public String showRegulaGamesToEdit(Model model){
		 List<RegularGameModelImpl> games= regularGame.getAllGames();
		 model.addAttribute("regularGames", games);
		return "showRegularGames";
	}
	
	@RequestMapping(value="/show-prettyRegular-games", method= RequestMethod.GET)
	public String showPrettyRegulaGamesToEdit(Model model){
		List<RegularGameModelImpl> games= regularGame.getAllGames();
		model.addAttribute("regularGames", games);
		return "showPrettyRegularGames";
	}
	
	@RequestMapping(value="/show-regular-game/{id}")
	public String showRegularGame(@PathVariable("id") int id, Model model){
		RegularGameModelImpl game = regularGame.getGame(id);
		model.addAttribute("game", game);
		model.addAttribute("startDate", game.getStartGameDate().toString(FORMATTER));
		return "showRegularGame";
	}
	
	@RequestMapping(value="/edit-regular-game/{id}")
	public String editRegularGame(@PathVariable("id") int id, Model model){
		RegularGameModelImpl game = regularGame.getGame(id);
		model.addAttribute("game", regularGame.getGame(id));
		model.addAttribute("startDate", game.getStartGameDate().toString(FORMATTER));
		return "editRegularGame";
	}
	
	@RequestMapping(value="/edit-regular-game", method=RequestMethod.POST)
	public String confirmEditRegularGame(@ModelAttribute("game") RegularGameModelImpl game,
			@RequestParam("datetime") String datetime){
		game.setStartGameDate(FORMATTER.parseDateTime(datetime));
		regularGame.updateGame(game);
		return "redirect:/show-regular-game/"+game.getIdRegularGame();
	}
	
	@RequestMapping(value="/delete-regular-game/{id}")
	public String deleteRegularGame(@PathVariable("id") int id){
		regularGame.deleteGame(regularGame.getGame(id));
		return "redirect:/show-regular-games";
	}
}
