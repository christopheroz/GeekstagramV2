package ort.geekstagram_student.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author christophe
 * @class Tool
 */
public class Tool {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

        /**
         * Fontion pour valider un email
         * @param emailStr
         * @return true ou false 
         */
	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
