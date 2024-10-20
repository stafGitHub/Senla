package TaskOne.GameLogic;

public class Command {
    public static boolean broker(String text) {
        return switch (text) {
            case "/con" -> {
                Start.con = true;
                yield false;
            }
            case "/exit" -> {
                Start.exit = true;
                yield false;
            }
            default -> true;
        };
    }
}