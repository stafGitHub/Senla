package TaskThree.Logic;

import java.util.regex.Pattern;

public class CheckYouPassword {
    private static final Pattern sign = Pattern.compile("[^a-zA-Zа-яА-Я0-9]");
    private static final Pattern symbol = Pattern.compile("[a-za-z]");
    private static final Pattern symbolUp = Pattern.compile("[A-ZA-Z]");
    private static final Pattern number = Pattern.compile("\\d");

    public static int error = 0;

    public static boolean check(String password) {
        boolean result = true;
        if (!sign.matcher(password).find()) {
            result = false;
        }
        if (!symbol.matcher(password).find()) {
            result = false;
        }
        if (!symbolUp.matcher(password).find()) {
            result = false;
        }
        if (!number.matcher(password).find()) {
            result = false;
        }

        if (!result) {
            error++;
        }

        return result;
    }
}
