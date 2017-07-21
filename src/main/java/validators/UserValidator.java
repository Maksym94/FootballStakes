package validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import models.LoginModelImpl;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return LoginModelImpl.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginModelImpl login = (LoginModelImpl) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "Required");
		
		if(login.getLogin().length()<6||login.getLogin().length()>32){
			errors.rejectValue("login", "Size.credentials.login");
		}
		if(login.getPassword().length()<6){
			errors.rejectValue("password", "Size.credentials.password");
		}
		if(!login.getPassword().equals(login.getConfirmPassword())){
			errors.rejectValue("confirmPassword","Different.credentials.password");
		}
		
	}

	

}
