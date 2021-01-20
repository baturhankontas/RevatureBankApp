package dev.kontas.exceptions;

import dev.kontas.exceptions.InappropriateCharacterException;
import dev.kontas.exceptions.UsernameTooShortException;

public interface UsernameValidator {
	
	
	boolean validUsername(String username) throws InappropriateCharacterException, UsernameTooShortException;

}
