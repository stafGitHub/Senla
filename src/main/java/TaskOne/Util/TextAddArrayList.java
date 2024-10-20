package TaskOne.Util;

import TaskOne.Entity.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TextAddArrayList {
    public static void parseText(String text, ArrayList<Word> list){
        String[] line = text.split("\n");

        ArrayList<String> parseText = new ArrayList<>(Arrays.asList(line));

        for (int i = 0; i < parseText.size(); i++) {
            Word word = Word.builder()
                    .text(parseText.get(i).split("--")[0].toLowerCase())
                    .Clue(parseText.get(i).split("--")[1])
                    .used(true)
                    .usedSymbol(new ArrayList<>())
                    .OpenSymbolmap(new HashMap<>())
                    .build();

            list.add(word);
        }
    }
}
