package TaskTwo.Logick;

import TaskOne.Entity.Word;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern pattern = Pattern.compile("(AMD|AZN|BYN|BGN|BRL)");
    public static Map<String, String> input = new HashMap<>();

    public static boolean inputUser() {
        String base = scanner.nextLine();
        String size = scanner.nextLine();
        String to = scanner.nextLine();

        Matcher matcherBase = pattern.matcher(base);
        Matcher matcherTo = pattern.matcher(to);

        if (matcherBase.find() && matcherTo.find()){
            input.put("base",base);
            input.put("size",size);
            input.put("to",to);
            return true;
        }else {
            return false;
        }

    }
}
