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

import models.RegularCommandModelImpl;
import regularPlay.RegularCommand;
import systemServices.FileUploadPath;

@Controller

public class AdminNewRegularCommandContr {
	
	private File regularCommandPhotoPath;
	
	@Autowired
	public AdminNewRegularCommandContr(FileUploadPath regularUploadPath) {
		regularCommandPhotoPath = new File(regularUploadPath.getUploadDirectory());
	}
	
	@Autowired
	private RegularCommand regularCommandImpl;

	@RequestMapping(value = "/regular-command", method = RequestMethod.GET)
	public String createRegularCommand(Model model) {
		RegularCommandModelImpl regularCommand = new RegularCommandModelImpl();
		model.addAttribute("regularCommand", regularCommand);
		return "regularCommand";
	}
    
	@RequestMapping(value="/regular-command", method=RequestMethod.POST)
	public String confirmCreatingRegularCommand(Model model,@ModelAttribute("regularCommand") 
	RegularCommandModelImpl regularCommandModel,
	@RequestPart("regularCommandPicture") MultipartFile regularCommandPicture ) {
		if(!regularCommandPhotoPath.exists()){
			regularCommandPhotoPath.mkdirs();
		}
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
		
		regularCommandModel.setPhotoPath(savePicture.getAbsolutePath());
		if (regularCommandImpl.createCommand(regularCommandModel,
				regularCommandPhotoPath.getAbsolutePath())) {
			model.addAttribute("regularCommand", regularCommandModel);
			return"redirect:/show-regular-command/"+regularCommandModel.getIdRegularCommand();
		}
		}
		else{
		regularCommandModel.setPhotoPath(null);
		if (regularCommandImpl.createCommand(regularCommandModel,
				null)) {
			model.addAttribute("regularCommand", regularCommandModel);
			return"redirect:/show-regular-command/"+regularCommandModel.getIdRegularCommand();
		}
		}
		
		return "regularCommand";
	}
}
