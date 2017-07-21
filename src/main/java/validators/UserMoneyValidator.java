package validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import models.UserOperationModelImpl;

public class UserMoneyValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserOperationModelImpl.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserOperationModelImpl operation = (UserOperationModelImpl) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rawAmount", "Required");
		double amount;
		try{
		amount= Double.parseDouble(operation.getRawAmount());
		}
		catch(NumberFormatException ex){
			errors.rejectValue("rawAmount", "Number.wrong");
			return;
		}
		if(amount>1000){
			errors.rejectValue("rawAmount", "Money.too.much");
		}
		if(amount<=0){
			errors.rejectValue("rawAmount", "Money.less.zero");
		}
		
	}

}
