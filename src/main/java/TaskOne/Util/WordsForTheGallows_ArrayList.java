package TaskOne.Util;

import TaskOne.Entity.Word;

import java.util.ArrayList;

public class WordsForTheGallows_ArrayList {
    //Глобальная коллекция со словами для игры
    public static ArrayList<Word> words = new ArrayList<>();


    static {
        TextAddArrayList.parseText(TextReader.reader("src/main/resources/TaskOne/hagmanGeme.txt").toString(),words);
    }

    public WordsForTheGallows_ArrayList() {
    }
}
