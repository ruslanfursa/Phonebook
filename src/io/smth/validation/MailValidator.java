package io.smth.validation;

import java.util.regex.Pattern;

public class MailValidator implements Validator{
    @Override
    public boolean validate(String s) {
       if(!isNullEmptyLength(s)){
           return false;
       }
        return AreAllSignsCorrect(s);
    }
    private boolean isNullEmptyLength(String s){
        if(s == null || s.length() < 8 || s.length() > 25){
            System.out.println("Email must contain min 8 signs, max 26 signs and must be not null");
            return false;
        }
        return true;
    }
    private boolean AreAllSignsCorrect(String s) {
        if (!Pattern.matches("^[a-zA-Z+_0-9.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]+$", s)) {
            System.out.println("Incorrect email");
            return false;
        }
        return true;
    }
}
