package com.softtwig.crm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.softtwig.crm.bo.BaseLoginBO;

import sun.security.validator.ValidatorException;

public class ValidatorUtils implements Validator {
	static String status;

	public static boolean checkName() {
		final BaseLoginBO baseLoginBO = new BaseLoginBO();
		if (baseLoginBO.getEmailAddress().isEmpty()) {
			return true;
		}
		return false;

	}

	public static String validate(Object arg2) throws ValidatorException {
		
		final String enteredName = (String) arg2;
		// Set the email pattern string
		final Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
		Pattern.compile("\\s");
		// Match the given string with the pattern
		final Matcher m = p.matcher(enteredName);
		final boolean matchFound = m.matches();
		if (!matchFound) {
			ValidatorUtils.status = "Name Should be a Character Only";
		} else {
			ValidatorUtils.status = null;
		}
		return ValidatorUtils.status;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		

	}

}
