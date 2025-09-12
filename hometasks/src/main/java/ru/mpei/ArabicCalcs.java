package ru.mpei;

public class ArabicCalcs extends Calculations {
    @Override
    protected String addition(String str) {
        String[] AB = str.split("[+]");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        if (A > 10 || B > 10) {
            return "Неверный ввод";
        }
        return Integer.toString(A + B);
    }

    @Override
    protected String subtraction(String str) {
        String[] AB = str.split("[-]");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        if (A > 10 || B > 10) {
            return "Неверный ввод";
        }
        return Integer.toString(A - B);
    }

    @Override
    protected String division(String str) {
        String[] AB = str.split("[/]");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        if (A > 10 || B > 10) {
            return "Неверный ввод";
        }
        return Integer.toString(A / B);
    }

    @Override
    protected String multiplication(String str) {
        String[] AB = str.split("[*]");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        if (A > 10 || B > 10) {
            return "Неверный ввод";
        }
        return Integer.toString(A * B);
    }
}
