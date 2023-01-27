package io.smth.validation;

import java.util.regex.Pattern;

public class SurnameValidator implements Validator {
    @Override
    public boolean validate(String s) {
        if (!isNullEmptyLength(s)) {
            return false;
        }
        s = s.trim();
        return isOnlyLetters(s);

    }

    private boolean isNullEmptyLength(String s) {
        if (s == null || s.length() < 1 || s.length() > 15) {
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

