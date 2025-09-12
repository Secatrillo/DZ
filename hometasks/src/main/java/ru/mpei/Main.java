package ru.mpei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите математическое выражение без пробелов:");
        String input = in.next();
        // String input = "VIII*10";
        if (NumberIdentifier.isRomanNumber(input)) {
            RomanCalcs Rcalc = new RomanCalcs();
            System.out.println(Rcalc.Calc(input));
        } else if (NumberIdentifier.isArabicNumber(input)) {
            ArabicCalcs Acalc = new ArabicCalcs();
            System.out.println(Acalc.Calc(input));
        } else {
            System.out.println("Неверный ввод");
        }
        in.close();
    }
}