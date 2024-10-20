package TaskOne.GameLogic;

//import lombok.SneakyThrows;

import TaskOne.Entity.Word;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUser {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern pattern = Pattern.compile("[а-яё]");

    public static String inputUser(Word word) {
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        if (matcher.find() && checkUsedSymbol(input, word)) {
            return input;
        } else return "Error";


    }

    public static boolean check(String symbol) {
        int symbolLength = symbol.length();
        if (symbolLength == 1) {

        } else if (symbolLength > 1) {
            return Command.broker(symbol);
        }
        return false;
    }

    public static boolean checkUsedSymbol(String symbol, Word word) {
        AtomicBoolean flag = new AtomicBoolean(true);
        word.getUsedSymbol().forEach(character -> {
            if (symbol.charAt(0) == character) {
                flag.set(false);
            }
        });

        word.getOpenSymbolmap().forEach((integer, character) -> {
            if (symbol.charAt(0) == character) {
                flag.set(false);
            }
        });

        return flag.get();
    }


    private InputUser() {
    }
}