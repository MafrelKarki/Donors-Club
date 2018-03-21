package com.donorsClub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpService {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	
	public List<String> validateSignUpForm(String firstName, String lastName,String address,String contact, String email,
			String password, String confirmPassword) {

		List<String> result = new ArrayList<String>();

		if (firstName.isEmpty()) {
			result.add("First name required");
		}
		if (lastName.isEmpty()) {
			result.add("Last name required");
		}
		if (address.isEmpty()) {
			result.add("Adress required");
		}
		if (contact.isEmpty()) {
			result.add("Contact No. required");
		}
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (email.isEmpty()|| !matcher.find()) {
			result.add("E-mail required");
		}
		if (password.isEmpty() || password.length() < 6) {
			result.add("Last name required. (password must be more than 6 characters)");
		}
		if (!password.equals(confirmPassword)) {
			result.add("Your password was not confirm successfully");
		}

		return result;
	}

}
