package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.RegularCommandModelImpl;
import regularPlay.RegularCommand;

@Controller

public class AdminNewRegularCommandContr {

	@Autowired
	private RegularCommand regularCommandImpl;

	@RequestMapping(name = "regular-command", method = RequestMethod.GET)
	public String createRegularCommand(Model model) {
		RegularCommandModelImpl regularCommand = new RegularCommandModelImpl();
		model.addAttribute("regularCommand", regularCommand);
		return "regular";
	}
    
	@RequestMapping(name="regular-command", method=RequestMethod.POST)
	public String confirmCreatingNewCommand(Model model, RegularCommandModelImpl regularCommand) {
		if (regularCommandImpl.createCommand(regularCommand)) {
			return "confirm-regular";
		}
		return "regular";
	}
}
