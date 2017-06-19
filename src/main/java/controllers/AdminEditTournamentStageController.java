package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tournamentPlay.TournamentStage;

@Controller
public class AdminEditTournamentStageController {
	
	@Autowired
	private TournamentStage tournamentStageImpl;

	@RequestMapping(value = "/show-tournament-stages", method = RequestMethod.GET)
	public String showTournamentStages(Model model) {
        model.addAttribute("tournamentStages", tournamentStageImpl.getAllStages());
		return "showTournamentStages";
	}
	
	 @RequestMapping(value = "/show-tournament-stage/{id}")
	public String showTournamentStage(@PathVariable("id") int indexStage,Model model) {
		 model.addAttribute("tournamentStage", tournamentStageImpl.getStage(indexStage)); 
		return "showTournamentStage";
	}
}
