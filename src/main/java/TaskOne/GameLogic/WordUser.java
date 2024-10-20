package TaskOne.GameLogic;

import TaskOne.Entity.Word;
import TaskOne.Util.Random;

public class WordUser {
    public static void wordUser(Word word) {
        char[] showSymbol = word.getText().toCharArray();

        int random = Random.random(0, showSymbol.length);
        char symbol = showSymbol[random];

        int i = 0;
        if (checkUniq(showSymbol, symbol)) {
            for (char c : showSymbol) {
                if (c == symbol) {
                    word.getOpenSymbolmap().put(i, c);
                }
                i++;
            }
        } else {
            word.getOpenSymbolmap().put(random, symbol);
        }


    }

    private static boolean checkUniq(char[] mas, char s) {
        int count = 0;
        for (char ma : mas) {
            if (ma == s) {
                count++;
            }
        }
        return count > 1;
    }
}