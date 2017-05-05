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
	
	public AdminNewRegularCommandContr(FileUploadPath regularUploadPath) {
		regularCommandPhotoPath = new File(regularUploadPath.getUploadDirectory());
	}
	
	@Autowired
	private RegularCommand regularCommandImpl;

	@RequestMapping(name = "regular-command", method = RequestMethod.GET)
	public String createRegularCommand(Model model) {
		RegularCommandModelImpl regularCommand = new RegularCommandModelImpl();
		model.addAttribute("regularCommand", regularCommand);
		return "regular";
	}
    
	@RequestMapping(name="regular-command", method=RequestMethod.POST)
	public String confirmCreatingNewCommand(Model model,@ModelAttribute("regularCommand") 
	RegularCommandModelImpl regularCommand,
	@RequestPart("regularCommandPicture") MultipartFile regularCommandPicture ) {
		if(!regularCommandPhotoPath.exists()){
			regularCommandPhotoPath.mkdirs();
		}
		File savePicture = new File(regularCommandPhotoPath.getAbsolutePath()+"/"
		+regularCommandPicture.getOriginalFilename());
		if(!savePicture.exists()&&!savePicture.isDirectory()){
			try {
				regularCommandPicture.transferTo(savePicture);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		regularCommand.setPhotoPath(savePicture.getAbsolutePath());
		if (regularCommandImpl.createCommand(regularCommand)) {
			/*view.getPath().startsWith(getClass()
					.getProtectionDomain().getCodeSource().getLocation()
					.toURI().getPath()+"/resources/default.png")*/
			model.addAttribute("regularCommand", regularCommand);
			return "confirm-regular";
		}
		return "regular";
	}
}
