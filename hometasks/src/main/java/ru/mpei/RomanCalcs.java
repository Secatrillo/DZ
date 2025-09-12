package ru.mpei;

public class RomanCalcs extends Calculations {
    @Override
    protected String addition(String str) {
        String[] AB = str.split("[+]");
        int A = this.RomanToArabic(AB[0]);
        int B = this.RomanToArabic(AB[1]);
        if (A < 0 || B < 0) {
            return "Неверный ввод";
        }
        return ArabicToRoman(A + B);
    }

    @Override
    protected String subtraction(String str) {
        String[] AB = str.split("[-]");
        int A = this.RomanToArabic(AB[0]);
        int B = this.RomanToArabic(AB[1]);
        if (A < 0 || B < 0) {
            return "Неверный ввод";
        }
        return ArabicToRoman(A - B);
    }

    @Override
    protected String division(String str) {
        String[] AB = str.split("[/]");
        int A = this.RomanToArabic(AB[0]);
        int B = this.RomanToArabic(AB[1]);
        if (A < 0 || B < 0) {
            return "Неверный ввод";
        }
        return ArabicToRoman(A / B);
    }

    @Override
    protected String multiplication(String str) {
        String[] AB = str.split("[*]");
        int A = this.RomanToArabic(AB[0]);
        int B = this.RomanToArabic(AB[1]);
        if (A < 0 || B < 0) {
            return "Неверный ввод";
        }
        return ArabicToRoman(A * B);
    }

    private int RomanToArabic(String roman) {
        return switch (roman) {
            case "I"    -> 1;
            case "II"   -> 2;
            case "III"  -> 3;
            case "IV"   -> 4;
            case "V"    -> 5;
            case "VI"   -> 6;
            case "VII"  -> 7;
            case "VIII" -> 8;
            case "IX"   -> 9;
            case "X"    -> 10;
            default     -> -1;
        };
    }

    private String ArabicToRoman(int arabic) {
        if (arabic < 0) {
            return "Получен отрицательный ответ";
        }
        String out = "";
        int handreds = arabic / 100;
        int decimals = (arabic % 100) / 10;
        int ones = (arabic % 100) % 10;
        if (handreds == 1) {
            out = out.concat("C");
        }
        out = switch (decimals) {
            case 9 -> out.concat("XC");
            case 8 -> out.concat("LXXX");
            case 7 -> out.concat("LXX");
            case 6 -> out.concat("LX");
            case 5 -> out.concat("L");
            case 4 -> out.concat("XL");
            case 3 -> out.concat("XXX");
            case 2 -> out.concat("XX");
            case 1 -> out.concat("X");
            default-> "";
        };
        out = switch (ones) {
            case 9 -> out.concat("IX");
            case 8 -> out.concat("VIII");
            case 7 -> out.concat("VII");
            case 6 -> out.concat("VI");
            case 5 -> out.concat("V");
            case 4 -> out.concat("IV");
            case 3 -> out.concat("III");
            case 2 -> out.concat("II");
            case 1 -> out.concat("I");
            default -> "";
        };
        return out;
    }
}
