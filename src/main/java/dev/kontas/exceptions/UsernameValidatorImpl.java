package dev.kontas.exceptions;

import dev.kontas.exceptions.InappropriateCharacterException;
import dev.kontas.exceptions.UsernameTooShortException;
import dev.kontas.exceptions.UsernameValidator;

public class UsernameValidatorImpl implements UsernameValidator {

	public boolean validUsername(String username) throws InappropriateCharacterException, UsernameTooShortException {
		
		if(username.contains(" ")) {
			InappropriateCharacterException ice = new InappropriateCharacterException();
			throw ice;
		}
		
		if(username.length() < 6) {
			UsernameTooShortException utse = new UsernameTooShortException(username.length());
			throw utse;
		}

		return true;
	}

}
