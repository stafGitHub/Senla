package TaskOne.GameLogic;

import TaskOne.Entity.User;
import TaskOne.Entity.Word;
import TaskOne.Util.TextReader;
import TaskOne.Util.WordsForTheGallows_ArrayList;

public class Start {
    static int countWordToGame = WordsForTheGallows_ArrayList.words.size();

    //Команды
    static boolean con = false;
    static boolean exit = false;

    public static void start() {
        User user = new User();
        String gameText_Image = TextReader.reader("src/main/resources/TaskOne/image.txt").toString();

        while (countWordToGame > 0) {
            Word word = WordGeneration.generateWord();
            WordUser.wordUser(word);

            while (word.getOpenSymbolmap().size() < word.getText().length()) {
                String out = ImageFormatter.formatted(user, gameText_Image, word, word.getOpenSymbolmap());
                System.out.println(out);
                String inputUser = InputUser.inputUser(word);

                if (InputUser.check(inputUser)||inputUser.equals("Error")) {
                    continue;
                }

                if (con || exit) {
                    break;
                }

                EntityResult.latterCheck(word,user,inputUser);

                if (EntityResult.lose(user)) {
                    break;
                }

            }

            if (exit||user.getLive()==0){
                break;
            }

            EntityResult.win(word);



            con = false;
            countWordToGame--;
        }

    }

    public Start() {
    }
}