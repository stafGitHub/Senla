package TaskTwo.Unil;

import TaskTwo.Entity.Currency;
import TaskTwo.Logick.ImageFormater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayList_Currency {
    public static Map<String,Currency> currencies = new HashMap<>();

    public static void parseText(String text, Map<String,Currency> currencies) {
        String[] line = text.split("\n");

        ArrayList<String> parseText = new ArrayList<>(Arrays.asList(line));

        for (int i = 0; i < parseText.size(); i++) {
            Currency currency = Currency.builder()
                    .name(parseText.get(i).split("--")[0])
                    .price(Double.parseDouble(parseText.get(i).split("--")[1]))
                    .build();
            currencies.put(currency.getName(), currency);
        }
    }

    public static void init(){
        parseText(TextReader.reader("src/main/resources/TaskTwo/currency.txt").toString(), currencies);
    }
}
