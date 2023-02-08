import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.*;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class GameLauncher {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final GameLauncher GAME_LAUNCHER = new GameLauncher();
    private static final GameSystem GAME_SYSTEM = new GameSystem();
    private static boolean isNotTrue = false;
    private static final ArrayList<String> isPreviousSelectionTracker = new ArrayList<>();
    private static int botGeneratedValue;
    private static final ArrayList<Integer> usedDiceChoices = new ArrayList<>();
    private static final HashSet<Integer> INTEGER_HASH_SET = new HashSet<>();
    private static int TIME = 3;
    static String isDataInput;
    static final HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, InterruptedException {


        System.out.println("\nПриветствую друг! Тебя приветствует Игра в Покер на костях o(￣▽￣)ｄ");
        while (true) {
            System.out.print("Перед тем, как играть, нужно ознакомится с правилами игры. \nЧтобы перейти к правилам, нажми цифру 1\nОтвет: ");
            isDataInput = SCANNER.nextLine();
            if (isDataInput.equals("1")) {
                Desktop.getDesktop().browse(URI.create("https://github.com/dublXq/dice-poker#readme"));
                break;
            } else {
                System.out.println("Попробуй еще раз");
            }
        }

        System.out.print("Молодец! Первый этап пройден. Ну что, можем приступать?\n1 - Да\n2 - Нет\nОтвет: ");
        isDataInput = SCANNER.nextLine();

        while (true) {
            // Инициализация
            GameSystem.collectionAllVariablesNames();

            if (isDataInput.equals("1")) {
                System.out.println("Желаем удачи в победе!");
                GAME_LAUNCHER.startTurnMethods();
                TIME--;
                break;
            } else if (isDataInput.equals("2")) {
                System.out.println("Удачи! Рад был увидеться!(👉ﾟヮﾟ)👉");
                return;
            } else {
                System.out.print("Ошибка, повторите попытку\nВведите цифру = 1\nОтвет: ");
                isDataInput = SCANNER.nextLine();
            }
        }
        rollOrScore();
        startBotMove();
        while (true) {
            if (INTEGER_HASH_SET.size() == 6) {
                break;
            } else {
                PlayerCheck.wordBookWordsOfSupport();
                startPersonMove();
                System.out.println("------------------------------------");
                startBotMove();
            }
        }
        PlayerCheck.playerCalculateBonusPoints();
        System.out.println("------------------------------------");

        System.out.println("Ну что ж, дорогой друг. Поздравляю! Ты прошел первый раунд игры. Твоя сумма очков, сейчас составляет --> "
                + GlobalVariables.playerSummaAllNumbers + " очков.\n" +
                "Переходим ко второму раунду!\n");
        Thread.sleep(300);
        System.out.println("""
                Заметь, что во втором раунде, бот увеличивает свои возможности, и у него нет ограничений, в количествах бросков ^_~
                Поэтому не расслабляйся )
                """);
        for (int i = 5; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.println("Старт через " + i + " секунд\n");
        }
        System.out.println("----------- START -----------");
        while (true) {
            if (INTEGER_HASH_SET.size() == 13) {
                break;
            } else {
                PlayerCheck.wordBookWordsOfSupport();
                startPersonMove();
                System.out.println("------------------------------------");
                startBotMove();
            }
        }

        if (GameSystem.summaOfAllNumbersPerson >= GameSystem.summaOfAllNumbersBot) {
            System.out.println("\nТы победил! ( ﾉ ﾟｰﾟ)ﾉ\nТвоя сумма очков составляет --> " + GameSystem.summaOfAllNumbersPerson +
                    "\nРад был с тобой сыграть, увидимся ^_~\nP.S. Разработчик игры благодарит за внимание к проекту!");
        } else {
            System.out.println("\nТы проиграл! ╮（╯＿╰）╭\nТвоя сумма очков составляет --> " + GameSystem.summaOfAllNumbersPerson +
                    "\nРад был с тобой сыграть, увидимся ^_~\nP.S. Разработчик игры благодарит за внимание к проекту!");
        }
    }

    private static void startPersonMove() throws NoSuchFieldException, IllegalAccessException, IOException {
        resetVariables();
        GAME_LAUNCHER.startTurnMethods();
        rollOrScore();
    }
    private static void startBotMove() throws NoSuchFieldException, IllegalAccessException {
        if (isNotTrue) {
            GameSystem.clearAllGlobalVariables();
            smartSummationMethodBot();
            PlayerBot.playerBotCalculateBonusPoints();
            System.out.println("\nБот сделал ход! Ваш черед ^_~");
            isNotTrue = false;
        }
    }
    private static void resetVariables() throws NoSuchFieldException, IllegalAccessException {
        GameSystem.clearAllGlobalVariables();
        GAME_SYSTEM.arrayCubesRandom.clear();
        GameSystem.scoreTimeArrayList.clear();
    }
    private static void rollOrScore() throws IOException, NoSuchFieldException, IllegalAccessException {
        while (true) {
            System.out.print("1 - Перебросить кубики\n2 - Засчитать\nОтвет: ");
            isDataInput = SCANNER.nextLine();
            if (isDataInput.equals("1")) {
                if (TIME == 0) {
                    System.out.println("Это был последний возможный бросок. Выбери куда засчитать очки?");
                    TIME = 3;
                    GAME_LAUNCHER.methodResultScare();
                    break;
                } else {
                    resetVariables();
                    GAME_LAUNCHER.startTurnMethods();
                    TIME--;
                }
            } else if (isDataInput.equals("2")) {
                // Код, который дает определение куда засчитать очки игрока (метод)
                TIME = 3;
                GAME_LAUNCHER.methodResultScare();
                break;
            } else {
                System.out.println("Данного варианта нет. Попробуй еще раз");
            }
        }
    }
    public void startTurnMethods() throws NoSuchFieldException, IllegalAccessException {
        GameSystem.clearAllGlobalVariables();
        GAME_SYSTEM.throwRandomCube();
        GAME_SYSTEM.playersPersonScore();
        GAME_SYSTEM.createAndUpdateArea();
    }
    public void methodResultScare() throws IOException, NoSuchFieldException, IllegalAccessException {
        // метод, который дает определение куда засчитать очки игрока
        do {
            System.out.print("""
                    Куда засчитать очки?
                    ВНИМАНИЕ! Если забыл, что такое секция, и чем они отличаются, разработчик советует вернуться к правилам игры
                    0 - Правила игры
                    1 - Верхняя секция
                    2 - Нижняя секция
                    Ответ:\s""");
            isDataInput = SCANNER.nextLine();
            while (true) {
                if (isDataInput.isEmpty()) {
                    System.out.print("Введи цифру от 0 до 2, для выбора куда хочешь засчитать свои очки\nОтвет: ");
                    isDataInput = SCANNER.nextLine();

                } else if (!Character.isDigit(isDataInput.charAt(0))) {
                    System.out.print("Ты ввел не цифру! Попробуй еще раз\nОтвет: ");
                    isDataInput = SCANNER.nextLine();

                } else {
                    int viewNumber = Integer.parseInt(isDataInput);
                    if (viewNumber < 0 || viewNumber > 2) {
                        System.out.print("Выход за границы! Ты ввел -> " + viewNumber + ". Требуется ввод от 0 до 2\nОтвет: ");
                        isDataInput = SCANNER.nextLine();
                    }
                    break;
                }
            }

            if (isDataInput.equals("0")) {
                Desktop.getDesktop().browse(URI.create("https://github.com/dublXq/dice-poker#readme"));
            } else {
                switch (isDataInput) {
                    case "1" -> startFirstHalf();
                    case "2" -> startSecondHalf();
                    default -> System.out.println("Неверный ввод. Попробуй еще раз");
                }
                isNotTrue = true;
                break;
            }
        } while (true);
    }
    public void startFirstHalf() throws NoSuchFieldException, IllegalAccessException {
        String numb = getPlayerUpperSectionSelection();
        resetVariableValue(numb);
        smartFirstSummationMethod(numb);
    }
    public void startSecondHalf() throws NoSuchFieldException, IllegalAccessException {
        String numb = getPlayerLowerSectionSelection();
        resetVariableValue(numb);
        smartSecondSummationMethod(numb, hashMap);
    }
    private static String getPlayerUpperSectionSelection() {
        System.out.print("1 - Единицы\n2 - Двойки\n3 - Тройки\n4 - Четверки\n5 - Пятерки\n6 - Шестерки\nОтвет: ");
        isDataInput = SCANNER.nextLine();

        while (true) {
            if (isDataInput.isEmpty()) {
                System.out.print("Введи цифру от 1 до 6, для выбора куда хочешь засчитать свои очки\nОтвет: ");
                isDataInput = SCANNER.nextLine();
            } else if (!Character.isDigit(isDataInput.charAt(0))) {
                System.out.print("Ты ввел не цифру! Попробуй еще раз\nОтвет: ");
                isDataInput = SCANNER.nextLine();
            } else {
                int viewNumber = Integer.parseInt(isDataInput);
                if (viewNumber < 1 || viewNumber > 6) {
                    System.out.print("Выход за границы! Ты ввел -> " + viewNumber + ". Требуется ввод от 1 до 6\nОтвет: ");
                    isDataInput = SCANNER.nextLine();
                } else if (isPreviousSelectionTracker.contains(isDataInput)) {
                    System.out.print("Ты уже это вводил, забыл?. Попробуй еще раз\nВыбери от 1 до 6, куда желаешь записать число\nОтвет: ");
                    isDataInput = SCANNER.nextLine();
                } else {
                    isPreviousSelectionTracker.add(isDataInput);
                    break;
                }
            }
        }
        switch (isDataInput) {
            case "1" -> isDataInput = "playerNumberOfUnits";
            case "2" -> isDataInput = "playerNumberOfDeuces";
            case "3" -> isDataInput = "playerNumberOfTriplets";
            case "4" -> isDataInput = "playerNumberOfFours";
            case "5" -> isDataInput = "playerNumberOfFives";
            case "6" -> isDataInput = "playerNumberOfSixes";

            default -> System.out.println("Некорректный ввод. Повтори еще раз");

        }
        return isDataInput;
    }
    private static void resetVariableValue(String numb) throws IllegalAccessException, NoSuchFieldException {
        for (String variableName : GameSystem.variableNames) {
            if (variableName.contains(numb)) {
                GlobalVariables.class.getField(variableName).set(null, 0);
            }
        }
    }
    public static void randomChooseBot(HashMap<String, Integer> hashMap) throws NoSuchFieldException, IllegalAccessException {
        botGeneratedValue = 0;
        Random random = new Random();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        setHashMap();
        while (INTEGER_HASH_SET.containsAll(integerArrayList)) {
            resetVariables();
            System.out.println("Бот делает бросок ^_^");
            GAME_SYSTEM.throwRandomCube();
            if (!usedDiceChoices.contains(1)) {
                if (GAME_SYSTEM.arrayCubesRandom.contains(GAME_SYSTEM.diceOne)) {
                    integerArrayList.add(1);
                }
            }
            if (!usedDiceChoices.contains(2)) {
                if (GAME_SYSTEM.arrayCubesRandom.contains(GAME_SYSTEM.diceTwo)) {
                    integerArrayList.add(2);
                }
            }
            if (!usedDiceChoices.contains(3)) {
                if (GAME_SYSTEM.arrayCubesRandom.contains(GAME_SYSTEM.diceThree)) {
                    integerArrayList.add(3);
                }
            }
            if (!usedDiceChoices.contains(4)) {
                if (GAME_SYSTEM.arrayCubesRandom.contains(GAME_SYSTEM.diceFour)) {
                    integerArrayList.add(4);
                }
            }
            if (!usedDiceChoices.contains(5)) {
                if (GAME_SYSTEM.arrayCubesRandom.contains(GAME_SYSTEM.diceFive)) {
                    integerArrayList.add(5);
                }
            }
            if (!usedDiceChoices.contains(6)) {
                if (GAME_SYSTEM.arrayCubesRandom.contains(GAME_SYSTEM.diceSix)) {
                    integerArrayList.add(6);
                }
            }
            if (!usedDiceChoices.contains(7)) {
                if (PlayerCheck.playerCheckTripleDice(GAME_SYSTEM.arrayCubesRandom)) {
                    integerArrayList.add(7);
                }
            }
            if (!usedDiceChoices.contains(8)) {
                if (PlayerCheck.playerCheckQuadrupleDice(GAME_SYSTEM.arrayCubesRandom)) {
                    integerArrayList.add(8);
                }
            }
            if (!usedDiceChoices.contains(9)) {
                if (PlayerCheck.playerCheckFullHouse(GAME_SYSTEM.arrayCubesRandom)) {
                    integerArrayList.add(9);
                }
            }
            if (!usedDiceChoices.contains(10)) {
                if (PlayerCheck.playerCheckLittleStreet(hashMap, GAME_SYSTEM.arrayCubesRandom)) {
                    integerArrayList.add(10);
                }
            }
            if (!usedDiceChoices.contains(11)) {
                if (PlayerCheck.playerCheckBigStreet(hashMap, GAME_SYSTEM.arrayCubesRandom)) {
                    integerArrayList.add(11);
                }
            }
            if (!usedDiceChoices.contains(12)) {
                integerArrayList.add(12);
            }
            if (!usedDiceChoices.contains(13)) {
                if (PlayerCheck.playerCheckYahtzee(GAME_SYSTEM.arrayCubesRandom)) {
                    integerArrayList.add(13);
                }
            }
        }
        int index = random.nextInt(integerArrayList.size());
        botGeneratedValue = integerArrayList.get(index);
        usedDiceChoices.add(botGeneratedValue);
        INTEGER_HASH_SET.add(botGeneratedValue);
        integerArrayList.clear();
    }
    private static void smartSummationMethodBot() throws NoSuchFieldException, IllegalAccessException {
        int stream;
        randomChooseBot(hashMap);
        switch (botGeneratedValue) {
            case 1 -> {
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceOne::equals).count();
                GlobalVariables.botNumberOfUnits = stream;
                GAME_SYSTEM.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfUnits");
            }
            case 2 -> {
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceTwo::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_TWO;
                GlobalVariables.botNumberOfDeuces = stream;
                GAME_SYSTEM.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfDeuces");
            }
            case 3 -> {
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceThree::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_THREE;
                GlobalVariables.botNumberOfTriplets = stream;
                GAME_SYSTEM.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfTriplets");
            }
            case 4 -> {
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceFour::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_FOUR;
                GlobalVariables.botNumberOfFours = stream;
                GAME_SYSTEM.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfFours");
            }
            case 5 -> {
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceFive::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_FIVE;
                GlobalVariables.botNumberOfFives = stream;
                GAME_SYSTEM.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfFives");
            }
            case 6 -> {
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceSix::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_SIX;
                GlobalVariables.botNumberOfSixes = stream;
                GAME_SYSTEM.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfSixes");
            }
            case 7 -> {
                if (PlayerCheck.playerCheckTripleDice(GAME_SYSTEM.arrayCubesRandom)) {
                    stream = hashMap.get(GlobalVariables.numberDiceForVariable);
                    GlobalVariables.botThreeOfAKindPoints = stream * 3;
                    GAME_SYSTEM.createAndUpdateArea();
                    GameSystem.variableNames.remove("botThreeOfAKindPoints");
                } else {
                    GlobalVariables.botThreeOfAKindPoints = 0;
                    GameSystem.variableNames.remove("botThreeOfAKindPoints");
                }
            }
            case 8 -> {
                if (PlayerCheck.playerCheckQuadrupleDice(GAME_SYSTEM.arrayCubesRandom)) {
                    stream = hashMap.get(GlobalVariables.numberDiceForVariable);
                    GlobalVariables.botFourOfAKindPoints = stream * 4;
                    GAME_SYSTEM.createAndUpdateArea();
                    GameSystem.variableNames.remove("botFourOfAKindPoints");
                } else {
                    GlobalVariables.botFourOfAKindPoints = 0;
                    GameSystem.variableNames.remove("botFourOfAKindPoints");
                }
            }
            case 9 -> {
                if (PlayerCheck.playerCheckFullHouse(GAME_SYSTEM.arrayCubesRandom)) {
                    GlobalVariables.botFullHousePoints = 25;
                    GAME_SYSTEM.createAndUpdateArea();
                    GameSystem.variableNames.remove("botFullHousePoints");
                } else {
                    GlobalVariables.botFullHousePoints = 0;
                    GameSystem.variableNames.remove("botFullHousePoints");
                }
            }
            case 10 -> {
                if (PlayerCheck.playerCheckLittleStreet(hashMap, GAME_SYSTEM.arrayCubesRandom)) {
                    GlobalVariables.botSmallStraightPoints = 30;
                    GAME_SYSTEM.createAndUpdateArea();
                    GameSystem.variableNames.remove("botSmallStraightPoints");
                } else {
                    GlobalVariables.botSmallStraightPoints = 0;
                    GameSystem.variableNames.remove("botSmallStraightPoints");
                }
            }
            case 11 -> {
                if (PlayerCheck.playerCheckBigStreet(hashMap, GAME_SYSTEM.arrayCubesRandom)) {
                    GlobalVariables.botLargeStraightPoints = 40;
                    GAME_SYSTEM.createAndUpdateArea();
                    GameSystem.variableNames.remove("botLargeStraightPoints");
                } else {
                    GlobalVariables.botLargeStraightPoints = 0;
                    GameSystem.variableNames.remove("botLargeStraightPoints");
                }
            }
            case 12 -> {
                GlobalVariables.botChancePoints = GlobalVariables.botSummaAllNumbers;
                GAME_SYSTEM.createAndUpdateArea();
                GameSystem.variableNames.remove("botChancePoints");
            }
            case 13 -> {
                if (PlayerCheck.playerCheckYahtzee(GAME_SYSTEM.arrayCubesRandom)) {
                    GlobalVariables.botYahtzeePoints = 50;
                    GAME_SYSTEM.createAndUpdateArea();
                    GameSystem.variableNames.remove("botYahtzeePoints");
                } else {
                    GlobalVariables.botYahtzeePoints = 0;
                    GameSystem.variableNames.remove("botYahtzeePoints");
                }
            }
        }
    }
    public static void smartFirstSummationMethod(String numb) {

        int stream;
        switch (numb) {
            case "playerNumberOfUnits" -> {
                // если единицы -> перебор массива кубиков -> находим единицы -> сумма -> GlobalVariables.playerNumberOfUnits
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceOne::equals).count();
                GlobalVariables.playerNumberOfUnits = stream;
                GameSystem.variableNames.remove("playerNumberOfUnits");
            }
            case "playerNumberOfDeuces" -> {
                // если двойки -> перебор массива кубиков -> находим двойки -> сумма -> GlobalVariables.playerNumberOfDeuces
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceTwo::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_TWO;
                GlobalVariables.playerNumberOfDeuces = stream;
                GameSystem.variableNames.remove("playerNumberOfDeuces");
            }
            case "playerNumberOfTriplets" -> {
                // если тройки -> перебор массива кубиков -> находим тройки -> сумма -> GlobalVariables.playerNumberOfTriplets
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceThree::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_THREE;
                GlobalVariables.playerNumberOfTriplets = stream;
                GameSystem.variableNames.remove("playerNumberOfTriplets");
            }
            case "playerNumberOfFours" -> {
//                 если четверки -> перебор массива кубиков -> находим четверки -> сумма -> GlobalVariables.playerNumberOfFours
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceFour::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_FOUR;
                GlobalVariables.playerNumberOfFours = stream;
                GameSystem.variableNames.remove("playerNumberOfFours");
            }
            case "playerNumberOfFives" -> {
//                 если пятерки -> перебор массива кубиков -> находим пятерки -> сумма -> GlobalVariables.playerNumberOfFives
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceFive::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_FIVE;
                GlobalVariables.playerNumberOfFives = stream;
                GameSystem.variableNames.remove("playerNumberOfFives");
            }
            case "playerNumberOfSixes" -> {
//                 если шестерки -> перебор массива кубиков -> находим шестерки -> сумма -> GlobalVariables.playerNumberOfSixes
                stream = (int) GAME_SYSTEM.arrayCubesRandom.stream().filter(GAME_SYSTEM.diceSix::equals).count();
                stream = stream * GAME_SYSTEM.CUBE_SIX;
                GlobalVariables.playerNumberOfSixes = stream;
                GameSystem.variableNames.remove("playerNumberOfSixes");
            }
            default -> System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повтори еще раз");
        }
    }
    public static void smartSecondSummationMethod(String numb, HashMap<String, Integer> hashMap) {
        int count;
        setHashMap();
        switch (numb) {
            // если Три одинаковых -> перебор массива кубиков -> находим Три одинаковых числа -> сумма -> GlobalVariables.playerThreeOfAKindPoints
            case "playerThreeOfAKindPoints" -> {
                if (PlayerCheck.playerCheckTripleDice(GAME_SYSTEM.arrayCubesRandom)) {
                    count = hashMap.get(GlobalVariables.numberDiceForVariable);
                    GlobalVariables.playerThreeOfAKindPoints = count * 3;
                    GameSystem.variableNames.remove("playerThreeOfAKindPoints");
                } else {
                    GameSystem.variableNames.remove("playerThreeOfAKindPoints");
                    System.out.println("Эй, не шали.");
                }
            }
            // если Четыре одинаковых -> перебор массива кубиков -> находим Четыре одинаковых числа -> сумма -> GlobalVariables.playerFourOfAKindPoints
            case "playerFourOfAKindPoints" -> {
                if (PlayerCheck.playerCheckQuadrupleDice(GAME_SYSTEM.arrayCubesRandom)) {
                    count = hashMap.get(GlobalVariables.numberDiceForVariable);
                    GlobalVariables.playerFourOfAKindPoints = count * 4;
                    GameSystem.variableNames.remove("playerFourOfAKindPoints");
                } else {
                    GameSystem.variableNames.remove("playerFourOfAKindPoints");
                    System.out.println("Не повезло. Эх.");
                }
            }
            // если Фулл-хаус -> перебор массива кубиков -> находим "Фулл-хаус" -> сумма -> GlobalVariables.playerFullHousePoints
            case "playerFullHousePoints" -> {
                if (PlayerCheck.playerCheckFullHouse(GAME_SYSTEM.arrayCubesRandom)) {
                    GlobalVariables.playerFullHousePoints = 25;
                    GameSystem.variableNames.remove("playerFullHousePoints");
                } else {
                    GameSystem.variableNames.remove("playerFullHousePoints");
                    System.out.println("Не повезло. Эх.");
                }
            }
            // если Маленький стрит -> перебор массива кубиков -> находим Маленький стрит -> сумма -> GlobalVariables.playerSmallStraightPoints
            case "playerSmallStraightPoints" -> {
                if (PlayerCheck.playerCheckLittleStreet(hashMap, GAME_SYSTEM.arrayCubesRandom)) {
                    GlobalVariables.playerSmallStraightPoints = 30;
                    GameSystem.variableNames.remove("playerSmallStraightPoints");
                } else {
                    GameSystem.variableNames.remove("playerSmallStraightPoints");
                    System.out.println("Не повезло. Эх.");
                }
            }
            // если Большой стрит -> перебор массива кубиков -> Большой стрит -> сумма -> GlobalVariables.playerLargeStraightPoints
            case "playerLargeStraightPoints" -> {
                if (PlayerCheck.playerCheckBigStreet(hashMap, GAME_SYSTEM.arrayCubesRandom)) {
                    GlobalVariables.playerLargeStraightPoints = 40;
                    GameSystem.variableNames.remove("playerLargeStraightPoints");
                } else {
                    GameSystem.variableNames.remove("playerLargeStraightPoints");
                    System.out.println("Не повезло. Эх.");
                }
            }
            // если Шанс -> сумма -> GlobalVariables.playerChancePoints
            case "playerChancePoints" -> {
                GlobalVariables.playerChancePoints = GlobalVariables.playerSummaAllNumbers;
                GameSystem.variableNames.remove("playerChancePoints");
            }
            // если Yahtzee -> перебор массива кубиков -> находим Yahtzee -> сумма -> GlobalVariables.playerYahtzeePoints
            case "playerYahtzeePoints" -> {
                if (PlayerCheck.playerCheckYahtzee(GAME_SYSTEM.arrayCubesRandom)) {
                    GlobalVariables.playerYahtzeePoints = 50;
                    GameSystem.variableNames.remove("playerCheckYahtzee");
                }
            }
            default -> System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повторите еще раз");
        }
    }
    public static String getPlayerLowerSectionSelection() {
        System.out.print("7 - Три одинаковых\n8 - Четыре одинаковых\n9 - Фулл-хаус\n10 - Маленький стрит\n11 - Большой стрит\n12 - Шанс\n13 - Yahtzee\nОтвет: ");
        isDataInput = SCANNER.nextLine();
        checkOnCorrectInput();
        switch (isDataInput) {
            case "7" -> isDataInput = "playerThreeOfAKindPoints";
            case "8" -> isDataInput = "playerFourOfAKindPoints";
            case "9" -> isDataInput = "playerFullHousePoints";
            case "10" -> isDataInput = "playerSmallStraightPoints";
            case "11" -> isDataInput = "playerLargeStraightPoints";
            case "12" -> isDataInput = "playerChancePoints";
            case "13" -> isDataInput = "playerYahtzeePoints";

            default -> System.out.println("Некорректный ввод. Повтори еще раз");
        }
        return isDataInput;
    }
    private static void checkOnCorrectInput() {
        while (true) {
            if (isDataInput.isEmpty()) {
                System.out.print("Введи цифру от 7 до 13, для выбора куда хочешь засчитать свои очки\nОтвет: ");
                isDataInput = SCANNER.nextLine();
            } else if (!Character.isDigit(isDataInput.charAt(0))) {
                System.out.print("Ты ввел не цифру! Попробуй еще раз\nОтвет: ");
                isDataInput = SCANNER.nextLine();
            } else {
                int viewNumber = Integer.parseInt(isDataInput);
                if (viewNumber < 7 || viewNumber > 13) {
                    System.out.print("Выход за границы! Ты ввел -> " + viewNumber + ". Требуется ввод от 7 до 13\nОтвет: ");
                    isDataInput = SCANNER.nextLine();
                } else if (isPreviousSelectionTracker.contains(isDataInput)) {
                    System.out.print("Ты уже это вводил, забыл?. Попробуй еще раз\nВыбери от 7 до 13, куда желаешь записать число\nОтвет: ");
                    isDataInput = SCANNER.nextLine();
                } else {
                    isPreviousSelectionTracker.add(isDataInput);
                    break;
                }
            }
        }
    }
    public static void setHashMap() {
        hashMap.put(GAME_SYSTEM.diceOne, 1);
        hashMap.put(GAME_SYSTEM.diceTwo, 2);
        hashMap.put(GAME_SYSTEM.diceThree, 3);
        hashMap.put(GAME_SYSTEM.diceFour, 4);
        hashMap.put(GAME_SYSTEM.diceFive, 5);
        hashMap.put(GAME_SYSTEM.diceSix, 6);
    }
}
