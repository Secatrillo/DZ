package ru.mpei;

public abstract class Calculations {
    protected abstract String addition(String str);

    protected abstract String subtraction(String str);

    protected abstract String multiplication(String str);

    protected abstract String division(String str);

    public String Calc(String str) {
        if (str.contains("-")) {
            return subtraction(str);
        }
        if (str.contains("+")) {
            return addition(str);
        }
        if (str.contains("*")) {
            return multiplication(str);
        }
        if (str.contains("/")) {
            return division(str);
        }
        return "Операция не введена";
    }
}
