package TaskOne.GameLogic;

import TaskOne.Entity.Word;
import TaskOne.Util.Random;
import TaskOne.Util.WordsForTheGallows_ArrayList;


public class WordGeneration {

    public static Word generateWord() {
        while (true) {
            int getWord = Random.random(0,WordsForTheGallows_ArrayList.words.size());

            if (WordsForTheGallows_ArrayList.words.get(getWord).isUsed()) {
                Word w = WordsForTheGallows_ArrayList.words.get(getWord);
                WordsForTheGallows_ArrayList.words.remove(getWord).setUsed(false);
                return w;
            }
        }
    }
}