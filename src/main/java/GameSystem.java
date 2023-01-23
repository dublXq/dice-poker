import java.util.ArrayList;
import java.util.Random;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class GameSystem {
    public ArrayList<Integer> arrayList = new ArrayList<>();
    public final int CUBE_ONE = 1;
    public final int CUBE_TWO = 2;
    public final int CUBE_THREE = 3;
    public final int CUBE_FOUR = 4;
    public final int CUBE_FIVE = 5;
    public final int CUBE_SIX = 6;
    public static String area;
    public static int summaOfAllNumbersPerson; // Общая сумма очков игрока
    public static int summaOfAllNumbersBot; // Общая сумма очков бота
    int viewSummaForAllPlayers; // Переменная отвечающая за временный вывод
    public String randomCube;

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

    public void createAndUpdateArea(int playerNumberOfUnits, int playerNumberOfDeuces,
                                    int playerNumberOfTriplets, int playerNumberOfFours,
                                    int playerNumberOfFives, int playerNumberOfSixes, int botNumberOfUnits,
                                    int botNumberOfDeuces, int botNumberOfTriplets, int botNumberOfFours,
                                    int botNumberOfFives, int botNumberOfSixes) {
        arrayList.add(playerNumberOfUnits);
        arrayList.add(playerNumberOfDeuces);
        arrayList.add(playerNumberOfTriplets);
        arrayList.add(playerNumberOfFours);
        arrayList.add(playerNumberOfFives);
        arrayList.add(playerNumberOfSixes);
        arrayList.add(botNumberOfUnits);
        arrayList.add(botNumberOfDeuces);
        arrayList.add(botNumberOfTriplets);
        arrayList.add(botNumberOfFours);
        arrayList.add(botNumberOfFives);
        arrayList.add(botNumberOfSixes);
        int playerSummaAllNumbers = playerNumberOfUnits + playerNumberOfDeuces + playerNumberOfTriplets + playerNumberOfFours + playerNumberOfFives + playerNumberOfSixes;
        int botSummaAllNumbers = botNumberOfUnits + botNumberOfDeuces + botNumberOfTriplets + botNumberOfFours + botNumberOfFives + botNumberOfSixes;
        area =
                "------------------------------------\n" +
                        "|\t\t\t\t      | Игрок | Бот |\n" +
                        "|_____________________|_______|_____|_____\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Единицы        |  " + playerNumberOfUnits + "       " + botNumberOfUnits + "     <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|       Двойки        |  " + playerNumberOfDeuces + "       " + botNumberOfDeuces + "     <---\n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|       Тройки        |  " + playerNumberOfTriplets + "       " + botNumberOfTriplets + "     <--- \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Четверки       |  " + playerNumberOfFours + "       " + botNumberOfFours + "       <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Пятерки        |  " + playerNumberOfFives + "       " + botNumberOfFives + "       <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Шестерки       |  " + playerNumberOfSixes + "       " + botNumberOfSixes + "       <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|        Сумма        |  " + playerSummaAllNumbers + "      " + botSummaAllNumbers + "    <---  \n" +
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
                        "|      ОБЩИЙ СЧЕТ     |  " + summaOfAllNumbersPerson + "       " + summaOfAllNumbersBot + "   <---  \n" +
                        "|_____________________|_______|___________|";
        area = String.format(area, playerNumberOfUnits, playerNumberOfDeuces,
                playerNumberOfTriplets, playerNumberOfFours,
                playerNumberOfFives, playerNumberOfSixes, botNumberOfUnits,
                botNumberOfDeuces, botNumberOfTriplets, botNumberOfFours,
                botNumberOfFives, botNumberOfSixes);
        System.out.println(area);
    }

    public void cubeRandom(int player, ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
        Random random = new Random();
        String[] arrayCubes = new String[]{one, two, three, four, five, six};
        for (int i = 1; i <= 6; i++) {
            randomCube = arrayCubes[random.nextInt(arrayCubes.length)];
            System.out.println(randomCube);
            if (player == 1) {
                playersPersonScore(arrayList.set(0, i), arrayList.set(1, i), arrayList.set(2, i), arrayList.set(3, i), arrayList.set(4, i), arrayList.set(5, i));
            } else {
                playersBotScore(arrayList.set(6, i), arrayList.set(7, i), arrayList.set(8, i), arrayList.set(9, i), arrayList.set(10, i), arrayList.set(11, i));
            }
        }
    }

    public void playersPersonScore(int playerNumberOfUnits, int playerNumberOfDeuces,
                                   int playerNumberOfTriplets, int playerNumberOfFours,
                                   int playerNumberOfFives, int playerNumberOfSixes) {
        switch (randomCube) {
            case one -> arrayList.set(0, playerNumberOfUnits + CUBE_ONE);
            case two -> arrayList.set(1, playerNumberOfDeuces + CUBE_TWO);
            case three -> arrayList.set(2, playerNumberOfTriplets + CUBE_THREE);
            case four -> arrayList.set(3, playerNumberOfFours + CUBE_FOUR);
            case five -> arrayList.set(4, playerNumberOfFives + CUBE_FIVE);
            case six -> arrayList.set(5, playerNumberOfSixes + CUBE_SIX);
        }
    }

    public void playersBotScore(int botNumberOfUnits,
                                int botNumberOfDeuces, int botNumberOfTriplets, int botNumberOfFours,
                                int botNumberOfFives, int botNumberOfSixes) {
        switch (randomCube) {
            case one -> arrayList.set(6, botNumberOfUnits + CUBE_ONE);
            case two -> arrayList.set(7, botNumberOfDeuces + CUBE_TWO);
            case three -> arrayList.set(8, botNumberOfTriplets + CUBE_THREE);
            case four -> arrayList.set(9, botNumberOfFours + CUBE_FOUR);
            case five -> arrayList.set(10, botNumberOfFives + CUBE_FIVE);
            case six -> arrayList.set(11, botNumberOfSixes + CUBE_SIX);
        }
    }
}

