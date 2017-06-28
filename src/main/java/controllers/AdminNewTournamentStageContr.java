package controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		model.addAttribute("tournamentGames",tournamentGameImpl.getAllAvailableGames());
		model.addAttribute("tournamentStage",new TournamentStageModelImpl());
		//model.addAttribute("indexesOfSelectedGames",new ArrayList<Integer>());
		return "newTournamentStage";
	}
	
	@RequestMapping(value = "/new-tournament-stage", method = RequestMethod.POST)
	public String name(@ModelAttribute("tournamentStage") TournamentStageModelImpl 
			tournamentStageModel,@RequestParam(name="idTournament",required=false) 
	int idTournament, @RequestParam(name="selectedGames",required=false) int[] selectedGames) {
		List<TournamentGameModelImpl> chosenGames = new ArrayList<>();
		if(selectedGames!=null){
			for (int i = 0; i < selectedGames.length; i++) {
				chosenGames.add(tournamentGameImpl.getGame(selectedGames[i]));
			}
		}
		tournamentStageModel.setTournament(tournamentImpl.getTournament(idTournament));
		tournamentStageModel.setTournamentGames(chosenGames);
        if(tournamentStageImpl.createStage(tournamentStageModel)){
        	return "redirect:/show-tournament-stage/"+ tournamentStageModel.getIdTournamentStage();
        }
		return "redirect:/new-tournament-stage";
	}

}
