package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import models.TournamentModelImpl;
import models.TournamentStageModelImpl;
import tournamentPlay.Tournament;
import tournamentPlay.TournamentStage;

@Controller
public class AdminEditTournamentContr {
	
	@Autowired
	private Tournament tournamentImpl;
	
	@Autowired
	private TournamentStage tournamentStageImpl;

	@RequestMapping(value = "/show-tournament", method = RequestMethod.GET)
	public String name(Model model) {
		TournamentModelImpl lastTournament= tournamentImpl.getLastTournament();
        model.addAttribute("tournament",lastTournament);
		return "showTournament";
	}
	
	@RequestMapping(value = "/edit-tournament", method = RequestMethod.POST)
	public String confirmEditTournament(@ModelAttribute("tournament") TournamentModelImpl 
			tournamentModel,@RequestParam(name="prevAmountCommands", required=false) 
	int prevAmountCommands, @RequestParam(name="existedStages", required=false) 
	int[] existedStages) {
		 if(existedStages!=null&& prevAmountCommands==tournamentModel.getMaxAmountOfCommands()){
			List<TournamentStageModelImpl> stages = new ArrayList<>();
			for (int i = 0; i < existedStages.length; i++) {
				stages.add(tournamentStageImpl.getStage(existedStages[i]));
			}
			tournamentModel.setTournamentStages(stages);
		}
		else if(prevAmountCommands!=tournamentModel.getMaxAmountOfCommands()){
			if(existedStages!=null){
			for (int i = 0; i < existedStages.length; i++) {
				tournamentStageImpl.deleteStage(tournamentStageImpl.getStage(existedStages[i]));
			}
			}
			tournamentImpl.editTournament(tournamentModel, true);
			return "redirect:/show-tournament";
		}
	
         tournamentImpl.editTournament(tournamentModel, false);
		return "redirect:/show-tournament";
	}
	
	@RequestMapping(value = "/edit-tournament/{id}")
	public String editTournament(Model model, @PathVariable("id") int id) {
		model.addAttribute("tournament", tournamentImpl.getTournament(id));
		return "editTournament";
	}
	
	@RequestMapping(value = "/delete-tournament/{id}")
	public String deleteTournament(Model model, @PathVariable("id") int id) {
		tournamentImpl.deleteTournament(tournamentImpl.getTournament(id));
		return "redirect:/show-tournament";
	}
}
