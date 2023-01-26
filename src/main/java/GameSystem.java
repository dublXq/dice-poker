import java.util.ArrayList;
import java.util.Random;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class GameSystem {

    public int playerNumberOfUnits;
    public int playerNumberOfDeuces;
    public int playerNumberOfTriplets;
    public int playerNumberOfFours;
    public int playerNumberOfFives;
    public int playerNumberOfSixes;
    public int botNumberOfUnits;
    public int botNumberOfDeuces;
    public int botNumberOfTriplets;
    public int botNumberOfFours;
    public int botNumberOfFives;
    public int botNumberOfSixes;


    public final int CUBE_ONE = 1;
    public final int CUBE_TWO = 2;
    public final int CUBE_THREE = 3;
    public final int CUBE_FOUR = 4;
    public final int CUBE_FIVE = 5;
    public final int CUBE_SIX = 6;
    public static String scoreCard;
    public static int summaOfAllNumbersPerson; // Общая сумма очков игрока
    public static int summaOfAllNumbersBot; // Общая сумма очков бота
    int viewSummaForAllPlayers; // Переменная отвечающая за временный вывод
    public String randomCube;

    final String diceOne = """
                    -----
                    |   |
                    | o |
                    |   |
                    -----""";
    final String diceTwo = """
                    -----
                    |o  |
                    |   |
                    |  o|
                    -----""";
    final String diceThree = """
                    -----
                    |o  |
                    | o |
                    |  o|
                    -----""";
    final String diceFour = """
                    -----
                    |o o|
                    |   |
                    |o o|
                    -----""";
    final String diceFive = """
                    -----
                    |o o|
                    | o |
                    |o o|
                    -----""";

    final String diceSix = """
                    -----
                    |o o|
                    |o o|
                    |o o|
                    -----""";
    ArrayList<String> arrayCubesRandom = new ArrayList<>();
    public ArrayList<Integer> arrayList = new ArrayList<>();

    public void createAndUpdateArea() {

        int playerSummaAllNumbers = playerNumberOfUnits + playerNumberOfDeuces + playerNumberOfTriplets + playerNumberOfFours + playerNumberOfFives + playerNumberOfSixes;
        int botSummaAllNumbers = botNumberOfUnits + botNumberOfDeuces + botNumberOfTriplets + botNumberOfFours + botNumberOfFives + botNumberOfSixes;
        scoreCard =
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
        scoreCard = String.format(scoreCard, playerNumberOfUnits, playerNumberOfDeuces,
                playerNumberOfTriplets, playerNumberOfFours,
                playerNumberOfFives, playerNumberOfSixes, botNumberOfUnits,
                botNumberOfDeuces, botNumberOfTriplets, botNumberOfFours,
                botNumberOfFives, botNumberOfSixes);
        System.out.println(scoreCard);
    }

    public void throwRandomCube() {
        Random random = new Random();
        String[] arrayCubes = new String[]{diceOne, diceTwo, diceThree, diceFour, diceFive, diceSix};
        for (int i = 1; i <= 6; i++) {
            randomCube = arrayCubes[random.nextInt(arrayCubes.length)];
            System.out.println(randomCube);
            arrayCubesRandom.add(randomCube);
        }
    }

    public void playersPersonScore() {
        for (String s : arrayCubesRandom) {
            switch (s) {
                case diceOne -> playerNumberOfUnits = playerNumberOfUnits + CUBE_ONE;
                case diceTwo -> playerNumberOfDeuces = playerNumberOfDeuces + CUBE_TWO;
                case diceThree -> playerNumberOfTriplets = playerNumberOfTriplets + CUBE_THREE;
                case diceFour -> playerNumberOfFours = playerNumberOfFours + CUBE_FOUR;
                case diceFive -> playerNumberOfFives = playerNumberOfFives + CUBE_FIVE;
                case diceSix -> playerNumberOfSixes = playerNumberOfSixes + CUBE_SIX;
            }
        }
        arrayAddPersonScore();
    }
    private void arrayAddPersonScore() {
        arrayList.add(0, playerNumberOfUnits);
        arrayList.add(1, playerNumberOfDeuces);
        arrayList.add(2, playerNumberOfTriplets);
        arrayList.add(3, playerNumberOfFours);
        arrayList.add(4, playerNumberOfFives);
        arrayList.add(5, playerNumberOfSixes);
    }
    public void playersBotScore() {
        for (String s : arrayCubesRandom){
            switch (s) {
                case diceOne -> botNumberOfUnits = botNumberOfUnits + CUBE_ONE;
                case diceTwo -> botNumberOfDeuces = botNumberOfDeuces + CUBE_TWO;
                case diceThree -> botNumberOfTriplets = botNumberOfTriplets + CUBE_THREE;
                case diceFour -> botNumberOfFours = botNumberOfFours + CUBE_FOUR;
                case diceFive -> botNumberOfFives = botNumberOfFives + CUBE_FIVE;
                case diceSix -> botNumberOfSixes = botNumberOfSixes + CUBE_SIX;
            }
        }
        arrayAddBotScore();
    }
    private void arrayAddBotScore() {
        arrayList.add(6, botNumberOfUnits);
        arrayList.add(7, botNumberOfDeuces);
        arrayList.add(8, botNumberOfTriplets);
        arrayList.add(9, botNumberOfFours);
        arrayList.add(10, botNumberOfFives);
        arrayList.add(11, botNumberOfSixes);
    }
    public void start() {
        throwRandomCube();
        playersPersonScore();
        createAndUpdateArea();
        System.out.println(arrayList);
        arrayCubesRandom.clear();
        System.out.println("\n---------------------------------------\n");
        throwRandomCube();
        playersBotScore();
        System.out.println(arrayList);
        System.out.println("\n---------------------------------------\n");
        createAndUpdateArea();
    }
}