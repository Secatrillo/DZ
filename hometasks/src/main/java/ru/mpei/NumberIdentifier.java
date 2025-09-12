package ru.mpei;

public class NumberIdentifier {
    public static boolean isArabicNumber(String number) {
        int counter = 0;
        for (int i = 0; i < number.length(); i++) {
            int num = (int) number.charAt(i);
            if (num >= 48 && num <= 57) {
                counter++;
            }
            else if (num >= 42 && num <= 47) {
                counter++;
            }

        }
        return counter == number.length() && counter > 1;

    }

    public static boolean isRomanNumber(String number) {
        int counter = 0;
        for (int i = 0; i < number.length(); i++) {
            int num = (int) number.charAt(i);
            if (num >= 65 && num <= 90) {
                counter++;
            }
            else if (num >= 42 && num <= 47) {
                counter++;
            }

        }
        return counter == number.length() && counter > 1;
    }
}
