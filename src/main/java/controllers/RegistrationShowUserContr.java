package controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import models.LoginModelImpl;
import models.UserModelImpl;
import user.UserManage;
import validators.UserValidator;

@Controller
@SessionAttributes("user")
public class RegistrationShowUserContr {
	
	@Autowired
	private UserManage userManageImpl;
	
	@Autowired
	private UserValidator validator;

	@RequestMapping(value = {"/register", "/registration"}, method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("credentials", new LoginModelImpl());
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String confirmRegistration(@ModelAttribute("credentials") LoginModelImpl credentials
			, BindingResult result) {
		validator.validate(credentials, result);
		if(result.hasErrors()){
			return "registration";
		}
		if(userManageImpl.createUser(credentials)){
			return "redirect:/";
		}
		return "redirect:/register"; 
	}
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String name(Model model, String error, Principal principal,
			@ModelAttribute("user") UserModelImpl user) {
		if(error!=null){
			model.addAttribute("error", "login or password is incorrect");
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		//System.out.println(login);
		//String login = principal.getName();
		if(login!=null&&!login.equals("anonymousUser")&& user.getUsername()==null){
			model.addAttribute("user", userManageImpl.getUserByName(login));
		}

		return "index";
	}
	
	@RequestMapping(value = "/show-user/{id}")
	public String showUser(@PathVariable("id") int index, Model model,
			@ModelAttribute("user") UserModelImpl user) {
		if(user.getUsername()==null){
			return "redirect:/";
		}
	    //model.addAttribute("user", userManageImpl.getUserById(index));	
		return "showUser";
	}
	
	@ModelAttribute("user")
	public UserModelImpl pass(){
		UserModelImpl user= new UserModelImpl();
		return user;
	}
}
