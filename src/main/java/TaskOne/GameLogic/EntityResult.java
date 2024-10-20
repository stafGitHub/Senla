package TaskOne.GameLogic;

import TaskOne.Entity.User;
import TaskOne.Entity.Word;
import TaskOne.Util.TextReader;

import java.util.Arrays;
import java.util.stream.Stream;

public class EntityResult {
    public static void latterCheck(Word word, User user, String symbol) {
        char[] text = word.getText().toCharArray();
        boolean flag = false;
        for (int i = 0; i < text.length; i++) {
            if (text[i] == symbol.charAt(0)) {
                word.getOpenSymbolmap().put(i, symbol.charAt(0));
                flag = true;
            }
        }

        word.getUsedSymbol().add(symbol.charAt(0));

        if (!flag) {
            user.setLive(user.getLive() -1);
        }

    }

    public static void win(Word word){
        if (word.getOpenSymbolmap().size()==word.getText().length()) {
            System.out.println(TextReader.reader("src/main/resources/TaskOne/win.txt").toString().formatted(word.getText()));
        }
    }

    public static boolean lose(User user){
        if (user.getLive()==0){
            System.out.println(TextReader.reader("src/main/resources/TaskOne/lose.txt"));
            return true;
        }else return false;
    }


    private EntityResult() {
    }
}
