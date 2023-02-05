import java.util.*;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class GameSystem {
    static GameSystem gameSystem = new GameSystem();
    public final int CUBE_ONE = 1;
    public final int CUBE_TWO = 2;
    public final int CUBE_THREE = 3;
    public final int CUBE_FOUR = 4;
    public final int CUBE_FIVE = 5;
    public final int CUBE_SIX = 6;
    public static String scoreCard;
    public static int summaOfAllNumbersPerson; // Общая сумма очков игрока
    public static int summaOfAllNumbersBot; // Общая сумма очков бота
    public String randomCube;
    public static List<String> variableNames;
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
    public ArrayList<String> arrayCubesRandom = new ArrayList<>();
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public void createAndUpdateArea() {
        GlobalVariables.playerSummaAllNumbers = GlobalVariables.playerNumberOfUnits + GlobalVariables.playerNumberOfDeuces +
                GlobalVariables.playerNumberOfTriplets + GlobalVariables.playerNumberOfFours
                + GlobalVariables.playerNumberOfFives + GlobalVariables.playerNumberOfSixes;
        GlobalVariables.botSummaAllNumbers = GlobalVariables.botNumberOfUnits + GlobalVariables.botNumberOfDeuces
                + GlobalVariables.botNumberOfTriplets + GlobalVariables.botNumberOfFours + GlobalVariables.botNumberOfFives + GlobalVariables.botNumberOfSixes;
        scoreCard =
                "------------------------------------\n" +
                        "|\t\t\t\t      | Игрок | Бот |\n" +
                        "|_____________________|_______|_____|_____\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Единицы        |  " + GlobalVariables.playerNumberOfUnits + "       " + GlobalVariables.botNumberOfUnits + "     <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|       Двойки        |  " + GlobalVariables.playerNumberOfDeuces + "       " + GlobalVariables.botNumberOfDeuces + "     <---\n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|       Тройки        |  " + GlobalVariables.playerNumberOfTriplets + "       " + GlobalVariables.botNumberOfTriplets + "     <--- \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Четверки       |  " + GlobalVariables.playerNumberOfFours + "       " + GlobalVariables.botNumberOfFours + "       <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Пятерки        |  " + GlobalVariables.playerNumberOfFives + "       " + GlobalVariables.botNumberOfFives + "       <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Шестерки       |  " + GlobalVariables.playerNumberOfSixes + "       " + GlobalVariables.botNumberOfSixes + "       <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|        Сумма        |  " + GlobalVariables.playerSummaAllNumbers + "       " + GlobalVariables.botSummaAllNumbers + "    <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|        Бонус        |  " + GlobalVariables.playerBonusPoints + "       " + GlobalVariables.botBonusPoints + "            <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|   Три одинаковых    |  " + GlobalVariables.playerThreeOfAKindPoints + "       " + GlobalVariables.botThreeOfAKindPoints + "            <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|  Четыре одинаковых  |  " + GlobalVariables.playerFourOfAKindPoints + "       " + GlobalVariables.botFourOfAKindPoints + "            <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Фулл-хаус      |  " + GlobalVariables.playerFullHousePoints + "       " + GlobalVariables.botFullHousePoints + "            <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|   Маленький стрит   |  " + GlobalVariables.playerSmallStraightPoints + "       " + GlobalVariables.botSmallStraightPoints + "             <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|    Большой стрит    |  " + GlobalVariables.playerLargeStraightPoints + "       " + GlobalVariables.botLargeStraightPoints + "           <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|        Шанс         |  " + GlobalVariables.playerChancePoints + "       " + GlobalVariables.botChancePoints + "             <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      Yahtzee        |  " + GlobalVariables.playerYahtzeePoints + "       " + GlobalVariables.botYahtzeePoints + "             <---  \n" +
                        "|_____________________|_______|___________|\n" +
                        "|\t\t\t\t\t  |       |           |\n" +
                        "|      ОБЩИЙ СЧЕТ     |  " + summaOfAllNumbersPerson + "       " + summaOfAllNumbersBot + "   <---  \n" +
                        "|_____________________|_______|___________|";
        scoreCard = String.format(scoreCard, GlobalVariables.playerNumberOfUnits, GlobalVariables.playerNumberOfDeuces,
                GlobalVariables.playerNumberOfTriplets, GlobalVariables.playerNumberOfFours,
                GlobalVariables.playerNumberOfFives, GlobalVariables.playerNumberOfSixes, GlobalVariables.botNumberOfUnits,
                GlobalVariables.botNumberOfDeuces, GlobalVariables.botNumberOfTriplets, GlobalVariables.botNumberOfFours,
                GlobalVariables.botNumberOfFives, GlobalVariables.botNumberOfSixes);
        System.out.println(scoreCard);
    }

    public void throwRandomCube() {
        Random random = new Random();
        String[] arrayCubes = new String[]{diceOne, diceTwo, diceThree, diceFour, diceFive, diceSix};
        for (int i = 1; i <= 5; i++) {
            randomCube = arrayCubes[random.nextInt(arrayCubes.length)];
            System.out.println(randomCube);
            arrayCubesRandom.add(randomCube);
        }
    }

    public void playersPersonScore() {

        List<String> cubesNumber = arrayCubesRandom;

           // #1
           if (cubesNumber.contains(diceOne) && variableNames.contains("playerNumberOfUnits")) {
               for (String s : arrayCubesRandom) {
                   if (s.equals(diceOne)) {
                       GlobalVariables.playerNumberOfUnits = GlobalVariables.playerNumberOfUnits + CUBE_ONE;
                   }
               }

           }
           // #2
           if (cubesNumber.contains(diceTwo) && variableNames.contains("playerNumberOfDeuces")) {
               for (String s : arrayCubesRandom) {
                   if (s.equals(diceTwo)) {
                       GlobalVariables.playerNumberOfDeuces = GlobalVariables.playerNumberOfDeuces + CUBE_TWO;
                   }
               }
           }
           // #3
           if (cubesNumber.contains(diceThree) && variableNames.contains("playerNumberOfTriplets")) {
               for (String s : arrayCubesRandom) {
                   if (s.equals(diceThree)) {
                       GlobalVariables.playerNumberOfTriplets = GlobalVariables.playerNumberOfTriplets + CUBE_THREE;
                   }
               }
           }
           // #4
           if (cubesNumber.contains(diceFour) && variableNames.contains("playerNumberOfFours")) {
               for (String s : arrayCubesRandom) {
                   if (s.equals(diceFour)) {
                       GlobalVariables.playerNumberOfFours = GlobalVariables.playerNumberOfFours + CUBE_FOUR;
                   }
               }
           }
           // #5
           if (cubesNumber.contains(diceFive) && variableNames.contains("playerNumberOfFives")) {
               for (String s : arrayCubesRandom) {
                   if (s.equals(diceFive)) {
                       GlobalVariables.playerNumberOfFives = GlobalVariables.playerNumberOfFives + CUBE_FIVE;
                   }
               }
           }
           // #6
           if (cubesNumber.contains(diceSix) && variableNames.contains("playerNumberOfSixes")) {
               for (String s : arrayCubesRandom) {
                   if (s.equals(diceSix)) {
                       GlobalVariables.playerNumberOfSixes = GlobalVariables.playerNumberOfSixes + CUBE_SIX;
                   }
               }
           }
        arrayAddPersonScore();
    }


    private void arrayAddPersonScore() {
        arrayList.add(0, GlobalVariables.playerNumberOfUnits);
        arrayList.add(1, GlobalVariables.playerNumberOfDeuces);
        arrayList.add(2, GlobalVariables.playerNumberOfTriplets);
        arrayList.add(3, GlobalVariables.playerNumberOfFours);
        arrayList.add(4, GlobalVariables.playerNumberOfFives);
        arrayList.add(5, GlobalVariables.playerNumberOfSixes);
    }

    public void playersBotScore() {
        for (String s : arrayCubesRandom) {
            switch (s) {
                case diceOne -> GlobalVariables.botNumberOfUnits = GlobalVariables.botNumberOfUnits + CUBE_ONE;
                case diceTwo -> GlobalVariables.botNumberOfDeuces = GlobalVariables.botNumberOfDeuces + CUBE_TWO;
                case diceThree -> GlobalVariables.botNumberOfTriplets = GlobalVariables.botNumberOfTriplets + CUBE_THREE;
                case diceFour -> GlobalVariables.botNumberOfFours = GlobalVariables.botNumberOfFours + CUBE_FOUR;
                case diceFive -> GlobalVariables.botNumberOfFives = GlobalVariables.botNumberOfFives + CUBE_FIVE;
                case diceSix -> GlobalVariables.botNumberOfSixes = GlobalVariables.botNumberOfSixes + CUBE_SIX;
            }
        }
        arrayAddBotScore();
    }

    private void arrayAddBotScore() {
        arrayList.add(6, GlobalVariables.botNumberOfUnits);
        arrayList.add(7, GlobalVariables.botNumberOfDeuces);
        arrayList.add(8, GlobalVariables.botNumberOfTriplets);
        arrayList.add(9, GlobalVariables.botNumberOfFours);
        arrayList.add(10, GlobalVariables.botNumberOfFives);
        arrayList.add(11, GlobalVariables.botNumberOfSixes);
    }

    public static void collectionAllVariablesNames() {

        variableNames = new ArrayList<>(Arrays.asList("playerNumberOfUnits", "playerNumberOfDeuces", "playerNumberOfTriplets",
                "playerNumberOfFours", "playerNumberOfFives", "playerNumberOfSixes", "playerSummaAllNumbers",
                "botNumberOfUnits", "botNumberOfDeuces", "botNumberOfTriplets", "botNumberOfFours", "botNumberOfFives",
                "botNumberOfSixes", "playerBonusPoints", "playerThreeOfAKindPoints",
                "playerFourOfAKindPoints", "playerFullHousePoints", "playerYahtzeePoints",
                "playerLargeStraightPoints", "playerChancePoints", "botThreeOfAKindPoints",
                "botBonusPoints", "botFourOfAKindPoints", "botFullHousePoints",
                "botSmallStraightPoints", "botLargeStraightPoints", "botChancePoints",
                "botYahtzeePoints"));

    }

    public static void clearAllGlobalVariables() throws NoSuchFieldException, IllegalAccessException {

        for (String variableName : variableNames) {
            GlobalVariables.class.getField(variableName).set(null, 0);
        }
    }
}
