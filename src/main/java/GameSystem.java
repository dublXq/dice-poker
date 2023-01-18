import java.util.Random;

/**
 * @author Evgeniy_Tyslevich
 * @link https://github.com/dublXq
 */
public class GameSystem {

    protected static final int Cube_ONE = 1;
    protected static final int Cube_TWO = 2;
    protected static final int Cube_THREE = 3;
    protected static final int Cube_FOUR = 4;
    protected static final int Cube_FIVE = 5;
    protected static final int Cube_SIX = 6;

    public int SummaOfAllNumbersPerson; // Общая сумма очков игрока
    public int SummaOfAllNumbersBot; // Общая сумма очков бота
    int ViewSummaForAllPlayers; // Переменная отвечающая за временный вывод

    String randomCube;
    String one =
            "-----\n" +
                    "|   |\n" +
                    "| o |\n" +
                    "|   |\n" +
                    "-----";
    String two =
            "-----\n" +
                    "|o  |\n" +
                    "|   |\n" +
                    "|  o|\n" +
                    "-----";
    String three =
            "-----\n" +
                    "|o  |\n" +
                    "| o |\n" +
                    "|  o|\n" +
                    "-----";
    String four =
            "-----\n" +
                    "|o o|\n" +
                    "|   |\n" +
                    "|o o|\n" +
                    "-----";
    String five =
            "-----\n" +
                    "|o o|\n" +
                    "| o |\n" +
                    "|o o|\n" +
                    "-----";

    String six =
            "-----\n" +
                    "|o o|\n" +
                    "|o o|\n" +
                    "|o o|\n" +
                    "-----";

    String area = "------------------------------------\n" +
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
            "|      ОБЩИЙ СЧЕТ     |  " + SummaOfAllNumbersPerson + "       " + SummaOfAllNumbersBot + "    <---  \n" +
            "|_____________________|_______|___________|";

    public void CubeRandom() {
        Random random = new Random();
        String[] arrayCubes = new String[]{one, two, three, four, five, six};
        for (int i = 1; i <= 6; i++) {
            randomCube = arrayCubes[random.nextInt(arrayCubes.length)];
            System.out.println(randomCube);
            PlayersScore();
        }

    }

    public void PlayersScore() {
        if (randomCube.equals(one)) {
            SummaOfAllNumbersPerson = SummaOfAllNumbersPerson + Cube_ONE;
        } else if (randomCube.equals(two)) {
            SummaOfAllNumbersPerson = SummaOfAllNumbersPerson + Cube_TWO;
        } else if (randomCube.equals(three)) {
            SummaOfAllNumbersPerson = SummaOfAllNumbersPerson + Cube_THREE;
        } else if (randomCube.equals(four)) {
            SummaOfAllNumbersPerson = SummaOfAllNumbersPerson + Cube_FOUR;
        } else if (randomCube.equals(five)) {
            SummaOfAllNumbersPerson = SummaOfAllNumbersPerson + Cube_FIVE;
        } else if (randomCube.equals(six)) {
            SummaOfAllNumbersPerson = SummaOfAllNumbersPerson + Cube_SIX;
        }
    }

}
