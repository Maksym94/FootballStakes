package controllers;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import models.RegularGameModelImpl;
import regularPlay.RegularCommand;
import regularPlay.RegularGame;


@Controller
public class AdminNewRegularGameContr {
	private static final DateTimeFormatter FORMATTER = DateTimeFormat
			.forPattern("dd-MM-yyyy HH:mm");
	@Autowired
	private RegularGame regularGame;
	
	@Autowired
	private RegularCommand regularCommand;
	
	@RequestMapping(value="/new-regular-game", method=RequestMethod.GET)
	public String createRegularGame(Model model){
		model.addAttribute("allCommands", regularCommand.getCommands());
		model.addAttribute("regularGameModel", new RegularGameModelImpl());
		return "newRegularGame";
	}
	
	@RequestMapping(value="/new-regular-game", method=RequestMethod.POST)
	public String confirmCreatingRegularGame(Model model, @ModelAttribute("regularGameModel") 
	RegularGameModelImpl regularGameModel,
	@RequestParam("datetime") String datetime){
		
		 regularGameModel.setStartGameDate(DateTime.parse(datetime,FORMATTER));   
		if(regularGame.createGame(regularGameModel)){
			model.addAttribute("regularGameModel", regularGameModel);
			return "redirect:/show-regular-game/"+regularGameModel.getIdRegularGame();
		}
		return "newRegularGame";
	}

}
