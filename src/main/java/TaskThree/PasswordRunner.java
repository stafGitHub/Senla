package TaskThree;

import TaskThree.Logic.CheckYouPassword;
import TaskThree.Logic.GeneratePassword;
import TaskThree.Util.ParseMap;
import TaskTwo.Logick.Converter;

import java.util.Scanner;

public class PasswordRunner {
    public static void main(String[] args) {
        ParseMap.initMap(ParseMap.getProperties("src/main/resources/TaskThree/password.properties"));
        GeneratePassword.init();

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                |-----------------------------------
                |    Password                      |
                |                   Generator      |
                -----------------------------------|

                /exit - выход , выведется допалнительная информация
                """);


        while (true) {
            System.out.println("\u001B[37m"+"Введите длину пароля");
            String input = scanner.nextLine();

            if (input.equals("/exit")) {
                break;
            }
            while (true) {
                StringBuilder stringBuilder = new StringBuilder();

                try {
                    String iterator = (Integer.parseInt(input)>=8&&Integer.parseInt(input)<=12)?input:"Error!";

                    for (int i = 0; i < Integer.parseInt(iterator); i++) {
                        stringBuilder.append(GeneratePassword.generateSymbol());
                    }
                }catch (Exception e){
                    System.out.println("\u001B[31m"+"Можно вводить только числа 8<=12");
                    break;
                }

                if (CheckYouPassword.check(stringBuilder.toString())) {
                    System.out.println("\u001B[32m" +stringBuilder +"\u001B[37m"+" ---> password 🔏 \n");
                    break;
                }
            }

        }

        System.out.println(CheckYouPassword.error + " ошибок");
        System.out.println("""
                Создание пароля работает на вероятностях
                Может произойти такое , что пароль не будет соответствовать требованию
                В этом случае пароль создаётся заново
                
                Вероятность ошибки для пароля из 8 символов - 0,00036%
                Вероятность ошибки для пароля из 12 символов - 0,00006%
                Данные взяты за 5000 итераций
                """);

    }

}
