package io.smth.validation;

public class NumberValidator implements Validator {
    private final static int NUM_OF_DIGITS = 12;

    @Override
    public boolean validate(String s) {
        if (!isNullEmptyLength(s)) {
            return false;
        }
        s = s.trim();
        if (!isFirstPlus(s)) {
            return false;
        }
        if (!areOnlyDigitsAndNotOnlyZeros(s)) {
            return false;
        }
        return validateNumberLength(s);
    }

    private boolean isNullEmptyLength(String s) {
        if (s == null || s.length() < 8) {
            System.out.println("Length of number must be >=5");
            return false;
        }
        return true;
    }

    private boolean isFirstPlus(String s) {
        if (!s.startsWith("+")) {
            System.out.println("""
                    The phonenumber must start from +
                    Please input correct number""");
            return false;
        }
        return true;
    }

    private boolean areOnlyDigitsAndNotOnlyZeros(String s) {
        int indicatorZero = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                System.out.println("Number must contain only digits >= 0");
                return false;
            }
            if (s.charAt(i) == '0') {
                indicatorZero++;
            }
        }
        if (indicatorZero == s.length() - 1) {
            System.out.println("Number must not contain only zeros");
            return false;
        }
        return true;
    }

    private boolean validateNumberLength(String s) {
        if (NUM_OF_DIGITS < (s.length() - 1)) {
            System.out.println("The number must contain not more than " + NUM_OF_DIGITS + " digits");
            return false;
        }
        return true;
    }
}


