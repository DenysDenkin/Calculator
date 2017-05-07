package com.denkin;

import org.apache.wicket.validation.CompoundValidator;
import org.apache.wicket.validation.validator.PatternValidator;
import org.apache.wicket.validation.validator.StringValidator;

public class CalcInputValidator extends CompoundValidator<String>{

	public CalcInputValidator() {

		//Match characters and symbols in the list, a-z, 0-9, underscore, hyphen
		add(new PatternValidator("^(0|[1-9]\\d*)(,(\\d+))?$"));
	
	}
	
}
