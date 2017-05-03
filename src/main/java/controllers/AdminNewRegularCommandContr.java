package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.RegularCommandModelImpl;

@Controller

public class AdminNewRegularCommandContr {

	@RequestMapping(name="regular-command", method=RequestMethod.GET)
	public String createRegularCommand(Model model){
		RegularCommandModelImpl regularCommand = new RegularCommandModelImpl();
		model.addAttribute("regularCommand", regularCommand);
		return "regular";
	}
}
