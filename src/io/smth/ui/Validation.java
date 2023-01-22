package io.smth.ui;

public class Validation {
    private final static int NUM_OF_DIGITS = 12;
     public boolean numberValidation(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return false;
        }
        s = s.trim();
        if (!s.startsWith("+")) {
            System.out.println("""                    
                    The phonenumber must start from +
                    Please input correct number""");
            return false;
        }

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
        if(indicatorZero == s.length() - 1) {
            System.out.println("Number must not contain only zeros");
            return false;
        }
        if ((s.length() - 1) != NUM_OF_DIGITS) {
            System.out.println("The number must contain " + NUM_OF_DIGITS + " digits");
            return false;
        }
        return true;
    }
}
