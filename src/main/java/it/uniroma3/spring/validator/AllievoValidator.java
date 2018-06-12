package it.uniroma3.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.spring.model.Allievo;

@Component
public class AllievoValidator implements Validator {

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiceFiscale", "required.allievo.codiceFiscale");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required.allievo.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required.allievo.cognome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataDiNascita", "required.allievo.dataDiNascita");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoDiNascita", "required.allievo.luogoDiNascita");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required.allievo.telefono");
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Allievo.class.equals(aClass);
	}
}
