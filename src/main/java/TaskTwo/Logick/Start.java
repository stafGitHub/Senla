package TaskTwo.Logick;

import TaskTwo.Unil.ArrayList_Currency;

import java.util.Scanner;

public class Start {
    public static void start() {
        ArrayList_Currency.init();
        while (true) {

            if (Input.inputUser()) {
                System.out.println(ImageFormater.formatter("src/main/resources/TaskTwo/Image.txt",
                        Input.input.get("base"),
                        Input.input.get("size"),
                        Input.input.get("to"),

                        Converter.convert(Input.input.get("base"),
                                Input.input.get("to"),
                                Double.parseDouble(Input.input.get("size")))));
            } else init();
        }
    }

    static {
        init();
    }

    public static void init() {
        System.out.println(ImageFormater.formatter("src/main/resources/TaskTwo/Image.txt",
                "Тикет(console)", "количество(console)", "Тикет(console)", "(количество рассчитывается автоматически)"));
    }


    private Start() {
    }
}
