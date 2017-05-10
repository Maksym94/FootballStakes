package controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import models.TournamentCommandModelImpl;
import systemServices.FileUploadPath;
import tournamentPlay.TournamentCommand;

@Controller
public class AdminNewTournamentCommandContr {
	private File tournamentCommandPath;
	
	@Autowired
	private TournamentCommand tournamentCommandImpl;
	
	@Autowired
public AdminNewTournamentCommandContr(FileUploadPath tournamentUploadPath) {
		tournamentCommandPath= new File(tournamentUploadPath.getUploadDirectory());
}
	
	@RequestMapping(value="/tournament-command", method= RequestMethod.GET)
	public String createTournamentCommand(Model model){
		model.addAttribute("tournamentCommand",new TournamentCommandModelImpl());
		return "tournament";
	}
	
	@RequestMapping(value="/tournament-command", method=RequestMethod.POST)
	public String confirmCreatingTournamentCommand(Model model, 
			@ModelAttribute("tournamentCommand")TournamentCommandModelImpl tournamentModel,
			@RequestPart("tournamentCommandPicture")MultipartFile tournamentCommandPicture){
		if(!tournamentCommandPath.exists()){
			tournamentCommandPath.mkdirs();
		}
		if(!tournamentCommandPicture.getOriginalFilename().isEmpty()){
			File file = new File(tournamentCommandPath.getAbsolutePath()+"/"+
		tournamentCommandPicture.getOriginalFilename());
			if(!file.exists()&&!file.isDirectory()){
				try {
					tournamentCommandPicture.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			tournamentModel.setPhotoPath(file.getAbsolutePath());
			if(tournamentCommandImpl.createCommand(tournamentModel, 
					tournamentCommandPath.getAbsolutePath())){
				model.addAttribute("tournamentCommand", tournamentModel);
				return "confirm-tournament";
			}
		}
		
		if(tournamentCommandImpl.createCommand(tournamentModel, 
				null)){
			model.addAttribute("tournamentCommand", tournamentModel);
			return "confirm-tournament";
		}
		
		
		return "tournament";
	}
}
