package TaskTwo.Logick;

import TaskTwo.Unil.ArrayList_Currency;

public class Converter {
    public static String convert(String currencyNameBase, String currencyNameSwap, double size) {
        double priceCurrencyBase = ArrayList_Currency.currencies.get(currencyNameBase).getPrice();
        double priceCurrencyToSwap = ArrayList_Currency.currencies.get(currencyNameSwap).getPrice();

        return String.valueOf((priceCurrencyBase * size) / priceCurrencyToSwap);

    }

    private Converter() {
    }
}
