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

import models.TournamentGameModelImpl;
import models.TournamentStageModelImpl;
import tournamentPlay.Tournament;
import tournamentPlay.TournamentGame;
import tournamentPlay.TournamentStage;

@Controller
public class AdminEditTournamentStageController {
	
	@Autowired
	private TournamentStage tournamentStageImpl;
	
	@Autowired
	private TournamentGame tournamentGameImpl;
	
	@Autowired
	private Tournament tournamentImpl;

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
	 
	 @RequestMapping(value = "/edit-tournament-stage/{id}")
	public String name(@PathVariable("id") int indexStage, Model model) {
		 model.addAttribute("tournamentStage", tournamentStageImpl.getStage(indexStage)); 
		 model.addAttribute("tournamentGames", tournamentGameImpl.getAllAvailableGames()); 
		return "editTournamentStage";
	}
	 
	 @RequestMapping(value = "/edit-tournament-stage", method = RequestMethod.POST)
	public String name(@ModelAttribute("tournamentStage") TournamentStageModelImpl 
			tournamentStageModel,@RequestParam(name="idTournament",required=false) 
	int idTournament, @RequestParam(name="selectedGames",required=false) int[] selectedGames) {

		 List<TournamentGameModelImpl> chosenGames = new ArrayList<>();
		 if(selectedGames!=null){
		 for (int i = 0; i < selectedGames.length; i++) {
			chosenGames.add(tournamentGameImpl.getGame(selectedGames[i]));
		}
		 }
		 tournamentStageModel.setTournamentGames(chosenGames);
		 if(idTournament!=0){
		 tournamentStageModel.setTournament(tournamentImpl.getTournament(idTournament));
		 }
		 if(tournamentStageImpl.editStage(tournamentStageModel)){
			 return "redirect:/show-tournament-stage/"+ tournamentStageModel
					 .getIdTournamentStage();
		 }
		return "redirect:/edit-tournament-stage/"+ tournamentStageModel.getIdTournamentStage();
	}
	 
	 @RequestMapping(value = "/delete-tournament-stage/{id}")
	public String name(@PathVariable("id") int id) {
        tournamentStageImpl.deleteStage(tournamentStageImpl.getStage(id));
		return "redirect:/show-tournament-stages";
	}
	 
	 @RequestMapping(value = "/delete-inTournament-stage/{id}")
	 public String name(@PathVariable("id") int id, @RequestParam("redirectTournament") 
	 int tournamentId) {
		 tournamentStageImpl.deleteStage(tournamentStageImpl.getStage(id));
		 if(tournamentId!=0){
			 return "redirect:/edit-tournament/"+ tournamentId;
		 }
		 return "redirect:/show-tournament-stages";
	 }
}
