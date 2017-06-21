package controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import models.TournamentCommandModelImpl;
import systemServices.FileUploadPath;
import tournamentPlay.TournamentCommand;

@Controller
public class AdminEditTournamentCommandContr {
	
private File tournamentCommandPhotoPath;
	
	@Autowired
	public AdminEditTournamentCommandContr(FileUploadPath tournamentUploadPath) {
		tournamentCommandPhotoPath = new File(tournamentUploadPath.getUploadDirectory());
	}
    
	@Autowired
	TournamentCommand tournamentCommand;
	
	@RequestMapping(value="/edit-tournament-command/{id}")
	public String editTournamentCommand(@PathVariable("id") int id, Model model){
		model.addAttribute("tournamentCommand", tournamentCommand.getCommandById(id));
		return "editTournamentCommand";
	}
	
	@RequestMapping(value="/edit-tournament-command", method=RequestMethod.POST)
	public String confirmEditTournamentCommand(Model model, 
			@ModelAttribute("tournamentCommand")TournamentCommandModelImpl tournamentModel,
			@RequestPart("tournamentCommandPicture")MultipartFile tournamentCommandPicture){

		if (!tournamentCommandPicture.getOriginalFilename().isEmpty()) {
			File file = new File(tournamentCommandPhotoPath.getAbsolutePath() + "/"
					+ tournamentCommandPicture.getOriginalFilename());
			if (!file.exists() && !file.isDirectory()) {
				try {
					tournamentCommandPicture.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			tournamentModel.setPhotoPath(file.getAbsolutePath());
			tournamentCommand.updateCommand(tournamentModel, tournamentCommandPhotoPath
					.getAbsolutePath());
		}

		else {
			tournamentCommand.updateCommand(tournamentModel, "");
		}
		return "redirect:/show-tournament-command/" + tournamentModel.getIdTournamentCommand();
	}
	
	@RequestMapping(value="/show-tournament-commands", method=RequestMethod.GET)
	public String showTournamentCommands(Model model){
		model.addAttribute("tournamentCommands", tournamentCommand.getAllCommands());
		return "showTournamentCommands";
	}
	@RequestMapping(value="/show-tournament-command/{id}")
	public String showTournamentCommand(@PathVariable("id") int id, Model model){
		model.addAttribute("tournamentCommand", tournamentCommand.getCommandById(id));
		return "showTournamentCommand";
	}
	@RequestMapping(value="/delete-tournament-command/{id}")
	public String deleteTournamentCommand(@PathVariable("id") int id){
		tournamentCommand.deleteCommand(tournamentCommand.getCommandById(id));
		return "redirect:/show-tournament-commands";
	}
}
