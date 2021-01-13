package microservices.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CharacterValidator implements Validator {

	@Autowired private CharacterService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Character.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "Empty name");
		
		Character character = (Character) target;
		if(!service.isHouseValid(character.getHouse()))
			errors.reject("house", "house.invalid");
	}

}
