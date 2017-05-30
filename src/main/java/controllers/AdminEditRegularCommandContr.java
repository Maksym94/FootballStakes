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

import models.RegularCommandModelImpl;
import regularPlay.RegularCommand;
import systemServices.FileUploadPath;

@Controller
public class AdminEditRegularCommandContr {
	
	
private File regularCommandPhotoPath;
	
	@Autowired
	public AdminEditRegularCommandContr(FileUploadPath regularUploadPath) {
		regularCommandPhotoPath = new File(regularUploadPath.getUploadDirectory());
	}
    
	@Autowired
	private RegularCommand regularCommand;
	
	@RequestMapping(value="/edit-regular-command/{id}")
	public String editRegularCommand(@PathVariable("id") int id, Model model){
		model.addAttribute("regularCommand", regularCommand.getCommandById(id));
		return "editRegularCommand";
	}
	@RequestMapping(value="/edit-regular-command", method=RequestMethod.POST)
	public String confirmEditRegularCommand(@ModelAttribute("regularCommand") 
	RegularCommandModelImpl regularCommandModel,@RequestPart("regularCommandPicture") 
	MultipartFile regularCommandPicture){
		if(!regularCommandPicture.getOriginalFilename().isEmpty()){
			File savePicture = new File(regularCommandPhotoPath.getAbsolutePath()+"/"
			+regularCommandPicture.getOriginalFilename());
			if(!savePicture.exists()&&!savePicture.isDirectory()){
				try {
					regularCommandPicture.transferTo(savePicture);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			/*File pictureToDelete=new File(regularCommandModel.getPhotoPath());
			if(pictureToDelete.exists()){
				pictureToDelete.delete();
			}*/
			regularCommandModel.setPhotoPath(savePicture.getAbsolutePath());
			regularCommand.updateCommand(regularCommandModel, 
					regularCommandPhotoPath.getAbsolutePath());
			}
		else{
		regularCommand.updateCommand(regularCommandModel, 
				"");
		}
		return "redirect:/show-regular-command/"+regularCommandModel.getIdRegularCommand();
	}
	
	@RequestMapping(value="/show-regular-commands", method=RequestMethod.GET)
	public String showRegularCommands(Model model){
		model.addAttribute("regularCommands", regularCommand.getCommands());
		return "showRegularCommands";
	}
	@RequestMapping(value="/show-regular-command/{id}")
	public String showRegularCommand(@PathVariable("id") int id, Model model){
		model.addAttribute("regularCommand", regularCommand.getCommandById(id));
		return "showRegularCommand";
	}
	@RequestMapping(value="/delete-regular-command/{id}")
	public String deleteRegularCommand(@PathVariable("id") int id){
		regularCommand.deleteCommand(regularCommand.getCommandById(id));
		return "redirect: /show-regular-commands";
	}
}
