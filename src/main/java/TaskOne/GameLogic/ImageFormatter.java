package TaskOne.GameLogic;

import TaskOne.Entity.User;
import TaskOne.Entity.Word;

import java.util.Map;
import java.util.Optional;

public class ImageFormatter {
    public static String formatted(User user, String text, Word word, Map<Integer,Character> symbolMap) {
        int live = user.getLive();
        String wordClue = word.getClue();
        String wordText = getWordText(word, symbolMap);
        String usedSymbol = getUsedSymbol(word);

        return text.formatted(live,wordClue,wordText,usedSymbol);

    }

    private static String getWordText(Word word,Map<Integer,Character> symbolMap){
        int wordSize = word.getText().length();
        StringBuilder wordText = new StringBuilder();

        for (int i = 0; i < wordSize; i++) {
            if (Optional.ofNullable(symbolMap.get(i)).isPresent()){
                wordText.append(symbolMap.get(i)).append(" ");
            }else {
                wordText.append("_").append(" ");
            }
        }
        return wordText.toString().toLowerCase();
    }

    private static String getUsedSymbol(Word word){
        StringBuilder usedSymbol = new StringBuilder();

        for (int i = 0; i < word.getUsedSymbol().size(); i++) {
            usedSymbol.append(word.getUsedSymbol().get(i)).append(" ");
        }

        return usedSymbol.toString().toLowerCase();
    }

    private ImageFormatter() {
    }
}