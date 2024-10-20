package TaskTwo.Logick;

import TaskTwo.Unil.ArrayList_Currency;
import TaskTwo.Unil.TextReader;

import java.util.ArrayList;

public class ImageFormater {
    public static String formatter(String path, Object... formatted){
        return TextReader.reader(path).toString().formatted(formatted);
    }

    private ImageFormater() {
    }
}
