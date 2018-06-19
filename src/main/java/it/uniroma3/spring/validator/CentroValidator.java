package it.uniroma3.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.spring.model.Centro;

@Component
public class CentroValidator implements Validator {

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required.centro.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required.centro.indirizzo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.centro.email");
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Centro.class.equals(aClass);
	}
}
