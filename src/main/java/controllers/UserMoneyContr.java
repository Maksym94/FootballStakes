package controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import models.UserModelImpl;
import models.UserOperationModelImpl;
import user.UserManage;
import user.UserMoney;
import validators.UserMoneyValidator;

@Controller
@SessionAttributes("user")
public class UserMoneyContr {
	
	@Autowired
	private UserMoneyValidator validator;
	
	@Autowired
	private UserManage userManageImpl;
	
	@Autowired
	private UserMoney userMoneyImpl;
	
	@RequestMapping(value = "/add-money", method = RequestMethod.GET)
	public String addMoney(Model model) {
		model.addAttribute("action", "Add");
		model.addAttribute("operation", new UserOperationModelImpl());
		return "userMoneyAction";
	}

	@RequestMapping(value = "/get-money", method = RequestMethod.GET)
	public String getMoney(Model model) {
		model.addAttribute("action", "Get");
		model.addAttribute("operation", new UserOperationModelImpl());
		return "userMoneyAction";
	}
	
	@RequestMapping(value = "/add-money", method = RequestMethod.POST)
	public String confirmAddingMoney(@ModelAttribute("user") UserModelImpl user, 
			 /*@ModelAttribute("amount") String moneyAmount,*/
			@ModelAttribute("operation") UserOperationModelImpl operation,
			BindingResult result,
			Model model) {
		validator.validate(operation, result);
		if(result.hasErrors()){
			model.addAttribute("action", "add");
			return "userMoneyAction";
		}
		operation.setAmount(new BigDecimal(operation.getRawAmount()));
		if(userMoneyImpl.addMoney(user, operation)){
			model.addAttribute("user", userManageImpl.getUserById(user.getIdUser()));
			return "redirect:/show-user/"+ user.getIdUser();
		}
		model.addAttribute("action", "Add");
		return "userMoneyAction";
		
	}
	
	@RequestMapping(value = "/get-money", method = RequestMethod.POST)
	public String confirmGettingMoney(@ModelAttribute("user") UserModelImpl userModel, 
			 /*@ModelAttribute("amount") String moneyAmount,*/
			@ModelAttribute("operation") UserOperationModelImpl operation,
			BindingResult result,
			Model model) {
		validator.validate(operation, result);
		if(result.hasErrors()){
			model.addAttribute("action", "Get");
			return "userMoneyAction";
		}
		operation.setAmount(new BigDecimal(operation.getRawAmount()));
		if(userMoneyImpl.getMoney(userModel, operation)){
			model.addAttribute("user", userManageImpl.getUserById(userModel.getIdUser()));
			return "redirect:/show-user/"+ userModel.getIdUser();
		}
		model.addAttribute("notEnough","not enough money no get");
		model.addAttribute("action", "Get");
		return "userMoneyAction";
	}
	
	@RequestMapping(value = "/delete-operation", method = RequestMethod.POST)
	public String deleteOperation(@ModelAttribute("user") UserModelImpl userModel,
			@RequestParam(name="indexOperation") int index, Model model) {
		userMoneyImpl.deleteOperation(userModel, userMoneyImpl.getOperationById(index));
		model.addAttribute("user", userManageImpl.getUserById(userModel.getIdUser()));
		return "redirect:/show-user"+ userModel.getIdUser();
	}
	
	@ModelAttribute("user")
	public UserModelImpl pass(){
		UserModelImpl user= new UserModelImpl();
		return user;
	}
}
