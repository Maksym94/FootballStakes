package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.TournamentGameModelImpl;
import models.TournamentStageModelImpl;
import tournamentPlay.Tournament;
import tournamentPlay.TournamentGame;
import tournamentPlay.TournamentStage;

@Controller
public class AdminNewTournamentStageContr {
	
	@Autowired
	private TournamentGame tournamentGameImpl;
	
	@Autowired
	private Tournament tournamentImpl;
	
	@Autowired
	private TournamentStage tournamentStageImpl;
	
	@RequestMapping(value = "/new-tournament-stage", method = RequestMethod.GET)
	public String name(Model model) {
		model.addAttribute("tournaments",tournamentImpl.getTournaments());
		model.addAttribute("tournamentGames",tournamentGameImpl.getAllGames() );
		model.addAttribute("tournamentStage",new TournamentStageModelImpl());
		return "newTournamentStage";
	}
	
	@RequestMapping(value = "/new-tournament-stage", method = RequestMethod.POST)
	public String name(@ModelAttribute("tournamentStage") TournamentStageModelImpl 
			tournamentStageModel,@ModelAttribute("tournamentGames") 
	List<TournamentGameModelImpl> tournamentGames, @ModelAttribute("idTournament") 
	int idTournament) {
		if(tournamentStageModel.getTournament()!=null){
	System.out.println("id tournament "+tournamentStageModel.getTournament().getIdTournament());
		}
		//tournamentStageModel.setIdTournamentStage(idTournament);
		tournamentStageModel.setTournamentGames(tournamentGames);
        if(tournamentStageImpl.createStage(tournamentStageModel)){
        	return "redirect:/show-tournament-stage/"+ tournamentStageModel.getIdTournamentStage();
        }
		return "redirect:/new-tournament-stage";
	}

}
