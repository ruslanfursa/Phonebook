package io.smth.validation;

import java.util.regex.Pattern;

public class SurnameValidator implements Validator {
    private final static int MIN_LENGTH = 1;
    private final static int MAX_LENGTH = 15;

    @Override
    public boolean validate(String s) {
        if (!isNullEmptyLength(s)) {
            return false;
        }
        s = s.trim();
        return isOnlyLetters(s);

    }

    private boolean isNullEmptyLength(String s) {
        if (s == null || s.length() < MIN_LENGTH || s.length() > MAX_LENGTH) {
            System.out.println("Surname must contain min 1 letter, max 16 letters and must be not null");
            return false;
        }
        return true;
    }

    private boolean isOnlyLetters(String s) {
        if (!Pattern.matches("[a-zA-Z\\s]+", s)) {
            System.out.println("Surname must contain only from Latin letters");
            return false;
        }
        return true;

    }
}

