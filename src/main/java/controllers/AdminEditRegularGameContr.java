package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.RegularGameModelImpl;
import regularPlay.RegularGame;

@Controller
public class AdminEditRegularGameContr {
	
	@Autowired
	private RegularGame regularGame;

	@RequestMapping(value="/edit-regular-game", method= RequestMethod.GET)
	public String showRegularCommandsToEdit(Model model){
		 List<RegularGameModelImpl> games= regularGame.getAllGames();
		 model.addAttribute("regularGames", games);
		return "editRegularGame";
	}
	
	@RequestMapping(value="/show-regular-game/{id}")
	public String showRegularGame(@PathVariable("id") int id, Model model){
		model.addAttribute("game", regularGame.getGame(id));
		return "showRegularGame";
	}
}
