package it.uniroma3.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.spring.model.Attivita;

@Component
public class AttivitaValidator implements Validator {

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required.attivita.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required.attivita.descrizione");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "required.attivita.data");
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Attivita.class.equals(aClass);
	}

}
