package TaskOne.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
    public static StringBuilder reader(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader readers = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = readers.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {

        }
        return builder;
    }

    public TextReader() {
    }
}