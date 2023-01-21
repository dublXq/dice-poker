import java.util.Random;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class GameSystem {

    public final int CUBE_ONE = 1;
    public final int CUBE_TWO = 2;
    public final int CUBE_THREE = 3;
    public final int CUBE_FOUR = 4;
    public final int CUBE_FIVE = 5;
    public final int CUBE_SIX = 6;
    public static String area;
    public static int summaOfAllNumbersPerson; // Общая сумма очков игрока
    public static int summaOfAllNumbersBot; // Общая сумма очков бота
    int ViewSummaForAllPlayers; // Переменная отвечающая за временный вывод
    String randomCube;


    final String one =
            """
                    -----
                    |   |
                    | o |
                    |   |
                    -----""";
    final String two =
            """
                    -----
                    |o  |
                    |   |
                    |  o|
                    -----""";
    final String three =
            """
                    -----
                    |o  |
                    | o |
                    |  o|
                    -----""";
    final String four =
            """
                    -----
                    |o o|
                    |   |
                    |o o|
                    -----""";
    final String five =
            """
                    -----
                    |o o|
                    | o |
                    |o o|
                    -----""";

    final String six =
            """
                    -----
                    |o o|
                    |o o|
                    |o o|
                    -----""";

    public static void updateArea() {
        area =
                "------------------------------------\n" +
                        "|\t\t\t\t      | Игрок | Бот |\n" +
                        "|_____________________|_______|_____|_____     \n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Единицы        |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|       Двойки        |              <---\n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|       Тройки        |              <--- \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Четверки       |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Пятерки        |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Шестерки       |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|        Сумма        |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|        Бонус        |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|   Три одинаковых    |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|  Четыре одинаковых  |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Фулл-хаус      |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|   Маленький стрит   |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|    Большой стрит    |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|        Шанс         |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Единицы        |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Yahtzee        |              <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      ОБЩИЙ СЧЕТ     |  " + summaOfAllNumbersPerson + "     " + summaOfAllNumbersBot + "   <---  \n" +
                        "|_____________________|_______|___________|";
        area = String.format(area, summaOfAllNumbersPerson, summaOfAllNumbersBot);
        System.out.println(area);
    }

    public void cubeRandom(int player) {
        Random random = new Random();
        String[] arrayCubes = new String[]{one, two, three, four, five, six};
        for (int i = 1; i <= 6; i++) {
            randomCube = arrayCubes[random.nextInt(arrayCubes.length)];
            System.out.println(randomCube);
            if (player == 1) {
                playersPersonScore();
            } else {
                playersBotScore();
            }
        }
    }

    public void playersPersonScore() {
        switch (randomCube) {
            case one -> summaOfAllNumbersPerson = summaOfAllNumbersPerson + CUBE_ONE;
            case two -> summaOfAllNumbersPerson = summaOfAllNumbersPerson + CUBE_TWO;
            case three -> summaOfAllNumbersPerson = summaOfAllNumbersPerson + CUBE_THREE;
            case four -> summaOfAllNumbersPerson = summaOfAllNumbersPerson + CUBE_FOUR;
            case five -> summaOfAllNumbersPerson = summaOfAllNumbersPerson + CUBE_FIVE;
            case six -> summaOfAllNumbersPerson = summaOfAllNumbersPerson + CUBE_SIX;
        }
    }
    public void playersBotScore() {
        switch (randomCube) {
            case one -> summaOfAllNumbersBot = summaOfAllNumbersBot + CUBE_ONE;
            case two -> summaOfAllNumbersBot = summaOfAllNumbersBot + CUBE_TWO;
            case three -> summaOfAllNumbersBot = summaOfAllNumbersBot + CUBE_THREE;
            case four -> summaOfAllNumbersBot = summaOfAllNumbersBot + CUBE_FOUR;
            case five -> summaOfAllNumbersBot = summaOfAllNumbersBot + CUBE_FIVE;
            case six -> summaOfAllNumbersBot = summaOfAllNumbersBot + CUBE_SIX;
        }
    }
}

