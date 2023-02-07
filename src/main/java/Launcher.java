import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.*;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class Launcher {
    static final Scanner scanner = new Scanner(System.in);
    static final Launcher launcher = new Launcher();
    static final GameSystem gameSystem = new GameSystem();
    static boolean isFalse = false;
    static ArrayList<String> stringArrayList = new ArrayList<>();
    static Random random = new Random();
    private static int number;
    static ArrayList<Integer> arrayCubesRandoms = new ArrayList<>();
    static HashSet<Integer> hashSet = new HashSet<>();


    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, InterruptedException {

        int time = 3;

        System.out.println("\nПриветствую друг! Тебя приветствует Игра в Покер на костях o(￣▽￣)ｄ");
        while (true) {
            System.out.print("Перед тем, как играть, нужно ознакомится с правилами игры. \nЧтобы перейти к правилам, нажми цифру 1\nОтвет: ");
            String numb = scanner.nextLine();
            if (numb.equals("1")) {
//                Desktop.getDesktop().browse(URI.create("https://github.com/dublXq/dice-poker#readme"));
                break;
            } else {
                System.out.println("Попробуй еще раз");
            }
        }

        System.out.print("Молодец! Первый этап пройден. Ну что, можем приступать?\n1 - Да\n2 - Нет\nОтвет: ");
        String numb_2 = scanner.nextLine();

        while (true) {

            // Инициализация
            GameSystem.collectionAllVariablesNames();

            if (numb_2.equals("1")) {
                System.out.println("Желаем удачи в победе!");
                launcher.start();
                time--;
                break;
            } else if (numb_2.equals("2")) {
                System.out.println("Удачи! Рад был увидеться!(👉ﾟヮﾟ)👉");
                return;
            } else {
                System.out.print("Ошибка, повторите попытку\nВведите цифру = 1\nОтвет: ");
                numb_2 = scanner.nextLine();
            }
        }
        RollOrScore(time);
        startWalkBot();

        while (true) {
            if (hashSet.size() == 6) {
                break;
            } else {
                PlayerPerson.wordBookWordsOfSupport();
                startWalkPerson(time);
                System.out.println("------------------------------------");
                startWalkBot();
            }
        }
        PlayerPerson.playerCalculateBonusPoints();
        System.out.println("------------------------------------");

        System.out.println("Ну что ж, дорогой друг. Поздравляю! Ты прошел первый раунд игры. Твоя сумма очков, сейчас составляет --> "
                + GlobalVariables.playerSummaAllNumbers + " очков.\n" +
                "Переходим ко второму раунду!");
        for (int i = 10; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.println("Старт через " + i + " секунд");
        }
        System.out.println("----------- START -----------");


    }

    private static void startWalkPerson(int time) throws NoSuchFieldException, IllegalAccessException, IOException {
        allClear();
        launcher.start();
        RollOrScore(time);
    }

    private static void startWalkBot() throws NoSuchFieldException, IllegalAccessException {
        if (isFalse) {
            GameSystem.clearAllGlobalVariables();
            smartSimplificationMethodForBot();
            System.out.println("\nБот сделал ход! Ваш черед ^_~");
            isFalse = false;
        }
    }

    private static void allClear() throws NoSuchFieldException, IllegalAccessException {
        GameSystem.clearAllGlobalVariables();
        gameSystem.arrayCubesRandom.clear();
        GameSystem.arrayList.clear();
    }

    private static void RollOrScore(int time) throws IOException, NoSuchFieldException, IllegalAccessException {

        while (true) {
            System.out.print("1 - Перебросить кубики\n2 - Засчитать\nОтвет: ");
            String numb = scanner.nextLine();
            if (numb.equals("1")) {
                if (time == 0) {
                    System.out.println("Это был последний возможный бросок. Выбери куда засчитать очки?");
                    // Код (метод)
                    time = 3;
                    launcher.methodResultScare();
                    break;

                } else {
                    allClear();
                    launcher.start();
                    time--;
                }

            } else if (numb.equals("2")) {
                // Код, который дает определение куда засчитать очки игрока (метод)
                time = 3;
                launcher.methodResultScare();
                break;

            } else {
                System.out.println("Данного варианта нет. Попробуй еще раз");
            }
        }
    }


    public void start() throws NoSuchFieldException, IllegalAccessException {
        GameSystem.clearAllGlobalVariables();
        gameSystem.throwRandomCube();
        gameSystem.playersPersonScore();

        gameSystem.createAndUpdateArea();
    }

    public void methodResultScare() throws IOException, NoSuchFieldException, IllegalAccessException {
        // method который дает определение куда засчитать очки игрока
        do {
            System.out.print("""
                    Куда засчитать очки?
                    ВНИМАНИЕ! Если забыл, что такое секция, и чем они отличаются, разработчик советует вернуться к правилам игры
                    0 - Правила игры
                    1 - Верхняя секция
                    2 - Нижняя секция
                    Ответ:\s""");
            int numb = scanner.nextInt();
            if (numb == 0) {
                Desktop.getDesktop().browse(URI.create("https://github.com/dublXq/dice-poker#readme"));
            } else {
                switch (numb) {
                    case 1 -> startingMethodNumbers();
                    case 2 -> endingMethodNumbers();
                    default -> System.out.println("Неверный ввод. Попробуй еще раз");
                }
                isFalse = true;
                break;
            }
        } while (true);
    }

    public void startingMethodNumbers() throws NoSuchFieldException, IllegalAccessException {

        String numb = getPersonUpperSelection();
        resetVariableValue(numb);
        smartSimplificationMethod(numb);

    }

    public void endingMethodNumbers() throws NoSuchFieldException, IllegalAccessException {
        String numb = getPersonLowerSelection();
        resetVariableValue(numb);
        endLowerSimplificationMethod(numb);
    }

    private static String getPersonUpperSelection() {
        System.out.print("1 - Единицы\n2 - Двойки\n3 - Тройки\n4 - Четверки\n5 - Пятерки\n6 - Шестерки\nОтвет: ");
        String numb = scanner.nextLine();
        numb = scanner.nextLine();

        while (true) {
            if (numb.isEmpty()) {
                System.out.print("Введи цифру от 1 до 6, для выбора куда хочешь засчитать свои очки\nОтвет: ");
                numb = scanner.nextLine();
            } else if (!Character.isDigit(numb.charAt(0))) {
                System.out.print("Ты ввел не цифру! Попробуй еще раз\nОтвет: ");
                numb = scanner.nextLine();
            } else {
                int viewNumber = Integer.parseInt(numb);
                if (viewNumber < 1 || viewNumber > 6) {
                    System.out.print("Выход за границы! Ты ввел -> " + viewNumber + ". Требуется ввод от 1 до 6\nОтвет: ");
                    numb = scanner.nextLine();
                } else if (stringArrayList.contains(numb)) {
                    System.out.print("Ты уже это вводил, забыл?. Попробуй еще раз\nВыбери от 1 до 6, куда желаешь записать число\nОтвет: ");
                    numb = scanner.nextLine();
                } else {
                    stringArrayList.add(numb);
                    break;
                }
            }
        }
        switch (numb) {
            case "1" -> numb = "playerNumberOfUnits";
            case "2" -> numb = "playerNumberOfDeuces";
            case "3" -> numb = "playerNumberOfTriplets";
            case "4" -> numb = "playerNumberOfFours";
            case "5" -> numb = "playerNumberOfFives";
            case "6" -> numb = "playerNumberOfSixes";

            default -> System.out.println("Некорректный ввод. Повтори еще раз");

        }

        return numb;
    }

    private static void resetVariableValue(String numb) throws IllegalAccessException, NoSuchFieldException {


        for (String variableName : GameSystem.variableNames) {
            if (variableName.contains(numb)) {
                GlobalVariables.class.getField(variableName).set(null, 0);
            }
        }
    }

    public static void randomChooseBot() throws NoSuchFieldException, IllegalAccessException {
        number = 0;
        allClear();
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        while (hashSet.containsAll(integerArrayList)) {
            System.out.println("Бот делает бросок ^_^");
            gameSystem.throwRandomCube();
            integerArrayList.clear();
            if (!arrayCubesRandoms.contains(1)) {
                if (gameSystem.arrayCubesRandom.contains(gameSystem.diceOne)) {
                    integerArrayList.add(1);
                }
            }
            if (!arrayCubesRandoms.contains(2)) {
                if (gameSystem.arrayCubesRandom.contains(gameSystem.diceTwo)) {
                    integerArrayList.add(2);
                }
            }
            if (!arrayCubesRandoms.contains(3)) {
                if (gameSystem.arrayCubesRandom.contains(gameSystem.diceThree)) {
                    integerArrayList.add(3);
                }
            }
            if (!arrayCubesRandoms.contains(4)) {
                if (gameSystem.arrayCubesRandom.contains(gameSystem.diceFour)) {
                    integerArrayList.add(4);
                }
            }
            if (!arrayCubesRandoms.contains(5)) {
                if (gameSystem.arrayCubesRandom.contains(gameSystem.diceFive)) {
                    integerArrayList.add(5);
                }
            }
            if (!arrayCubesRandoms.contains(6)) {
                if (gameSystem.arrayCubesRandom.contains(gameSystem.diceSix)) {
                    integerArrayList.add(6);
                }
            }
        }

        int index = random.nextInt(integerArrayList.size());
        number = integerArrayList.get(index);
        arrayCubesRandoms.add(number);
        hashSet.add(number);
        integerArrayList.clear();
    }


    private static void smartSimplificationMethodForBot() throws NoSuchFieldException, IllegalAccessException {

        randomChooseBot();
        System.out.println();
        int stream;
        switch (number) {
            case 1 -> {
                // если единицы -> перебор массива кубиков -> находим единицы -> сумма -> GlobalVariables.playerNumberOfUnits
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceOne::equals).count();
                GlobalVariables.botNumberOfUnits = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfUnits");
            }
            case 2 -> {
                // если двойки -> перебор массива кубиков -> находим двойки -> сумма -> GlobalVariables.playerNumberOfDeuces
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceTwo::equals).count();
                stream = stream * gameSystem.CUBE_TWO;
                GlobalVariables.botNumberOfDeuces = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfDeuces");
            }
            case 3 -> {
                // если тройки -> перебор массива кубиков -> находим тройки -> сумма -> GlobalVariables.playerNumberOfTriplets
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceThree::equals).count();
                stream = stream * gameSystem.CUBE_THREE;
                GlobalVariables.botNumberOfTriplets = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfTriplets");
            }
            case 4 -> {
//                 если четверки -> перебор массива кубиков -> находим четверки -> сумма -> GlobalVariables.playerNumberOfFours
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceFour::equals).count();
                stream = stream * gameSystem.CUBE_FOUR;
                GlobalVariables.botNumberOfFours = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfFours");
            }
            case 5 -> {
//                 если пятерки -> перебор массива кубиков -> находим пятерки -> сумма -> GlobalVariables.playerNumberOfFives
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceFive::equals).count();
                stream = stream * gameSystem.CUBE_FIVE;
                GlobalVariables.botNumberOfFives = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfFives");
            }
            case 6 -> {
//                 если шестерки -> перебор массива кубиков -> находим шестерки -> сумма -> GlobalVariables.playerNumberOfSixes
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceSix::equals).count();
                stream = stream * gameSystem.CUBE_SIX;
                GlobalVariables.botNumberOfSixes = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("botNumberOfSixes");
            }
            default -> System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повтори еще раз");
        }
    }

    public static void smartSimplificationMethod(String numb) {

        int stream;
        switch (numb) {
            case "playerNumberOfUnits" -> {
                // если единицы -> перебор массива кубиков -> находим единицы -> сумма -> GlobalVariables.playerNumberOfUnits
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceOne::equals).count();
                GlobalVariables.playerNumberOfUnits = stream;
                GameSystem.variableNames.remove("playerNumberOfUnits");
            }
            case "playerNumberOfDeuces" -> {
                // если двойки -> перебор массива кубиков -> находим двойки -> сумма -> GlobalVariables.playerNumberOfDeuces
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceTwo::equals).count();
                stream = stream * gameSystem.CUBE_TWO;
                GlobalVariables.playerNumberOfDeuces = stream;
                GameSystem.variableNames.remove("playerNumberOfDeuces");
            }
            case "playerNumberOfTriplets" -> {
                // если тройки -> перебор массива кубиков -> находим тройки -> сумма -> GlobalVariables.playerNumberOfTriplets
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceThree::equals).count();
                stream = stream * gameSystem.CUBE_THREE;
                GlobalVariables.playerNumberOfTriplets = stream;
                GameSystem.variableNames.remove("playerNumberOfTriplets");
            }
            case "playerNumberOfFours" -> {
//                 если четверки -> перебор массива кубиков -> находим четверки -> сумма -> GlobalVariables.playerNumberOfFours
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceFour::equals).count();
                stream = stream * gameSystem.CUBE_FOUR;
                GlobalVariables.playerNumberOfFours = stream;
                GameSystem.variableNames.remove("playerNumberOfFours");
            }
            case "playerNumberOfFives" -> {
//                 если пятерки -> перебор массива кубиков -> находим пятерки -> сумма -> GlobalVariables.playerNumberOfFives
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceFive::equals).count();
                stream = stream * gameSystem.CUBE_FIVE;
                GlobalVariables.playerNumberOfFives = stream;
                GameSystem.variableNames.remove("playerNumberOfFives");
            }
            case "playerNumberOfSixes" -> {
//                 если шестерки -> перебор массива кубиков -> находим шестерки -> сумма -> GlobalVariables.playerNumberOfSixes
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceSix::equals).count();
                stream = stream * gameSystem.CUBE_SIX;
                GlobalVariables.playerNumberOfSixes = stream;
                GameSystem.variableNames.remove("playerNumberOfSixes");
            }
            default -> System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повтори еще раз");
        }
    }

    public static void endLowerSimplificationMethod(String numb) {

        int stream;

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put(gameSystem.diceOne, 1);
        hashMap.put(gameSystem.diceTwo, 2);
        hashMap.put(gameSystem.diceThree, 3);
        hashMap.put(gameSystem.diceFour, 4);
        hashMap.put(gameSystem.diceFive, 5);
        hashMap.put(gameSystem.diceSix, 6);
        int count;
        switch (numb) {

            // если Три одинаковых -> перебор массива кубиков -> находим Три одинаковых числа -> сумма -> GlobalVariables.playerThreeOfAKindPoints
            case "playerThreeOfAKindPoints" -> {
                if (PlayerPerson.playerCheckTripleDice(gameSystem.arrayCubesRandom)) {
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
                if (PlayerPerson.playerCheckQuadrupleDice(gameSystem.arrayCubesRandom)) {
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
                if (PlayerPerson.playerCheckFullHouse(gameSystem.arrayCubesRandom)) {
                    GlobalVariables.playerFullHousePoints = 25;
                    GameSystem.variableNames.remove("playerFullHousePoints");
                } else {
                    GameSystem.variableNames.remove("playerFullHousePoints");
                    System.out.println("Не повезло. Эх.");
                }
            }
            // если Маленький стрит -> перебор массива кубиков -> находим Маленький стрит -> сумма -> GlobalVariables.playerSmallStraightPoints
            case "playerSmallStraightPoints" -> {
                if (PlayerPerson.playerCheckLittleStreet(hashMap, gameSystem.arrayCubesRandom)) {
                    GlobalVariables.playerSmallStraightPoints = 30;
                    GameSystem.variableNames.remove("playerSmallStraightPoints");
                } else {
                    GameSystem.variableNames.remove("playerSmallStraightPoints");
                    System.out.println("Не повезло. Эх.");
                }
            }
            // если Большой стрит -> перебор массива кубиков -> Большой стрит -> сумма -> GlobalVariables.playerLargeStraightPoints
            case "playerLargeStraightPoints" -> {
                if (PlayerPerson.playerCheckBigStreet(hashMap, gameSystem.arrayCubesRandom)) {
                    GlobalVariables.playerLargeStraightPoints = 30;
                    GameSystem.variableNames.remove("playerLargeStraightPoints");
                } else {
                    GameSystem.variableNames.remove("playerLargeStraightPoints");
                    System.out.println("Не повезло. Эх.");
                }
            }
            // если Шанс -> сумма -> GlobalVariables.playerChancePoints
            case "playerChancePoints" -> {
                GlobalVariables.playerSummaAllNumbers = GlobalVariables.playerChancePoints;
                GameSystem.variableNames.remove("playerChancePoints");
            }
            // если Yahtzee -> перебор массива кубиков -> находим Yahtzee -> сумма -> GlobalVariables.playerYahtzeePoints
            case "playerYahtzeePoints" -> {
                if (PlayerPerson.playerCheckYahtzee(gameSystem.arrayCubesRandom)){
                    GlobalVariables.playerYahtzeePoints = 50;
                    GameSystem.variableNames.remove("playerCheckYahtzee");
                }
            }
            default -> System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повторите еще раз");
        }
    }

    public static String getPersonLowerSelection() {
        System.out.print("1 - Три одинаковых\n2 - Четыре одинаковых\n3 - Фулл-хаус\n4 - Маленький стрит\n5 - Большой стрит\n6 - Шанс\n7 - Yahtzee\nОтвет: ");
        String numb = scanner.nextLine();
        numb = scanner.nextLine();

        while (true) {
            if (numb.isEmpty()) {
                System.out.print("Введи цифру от 7 до 13, для выбора куда хочешь засчитать свои очки\nОтвет: ");
                numb = scanner.nextLine();
            } else if (!Character.isDigit(numb.charAt(0))) {
                System.out.print("Ты ввел не цифру! Попробуй еще раз\nОтвет: ");
                numb = scanner.nextLine();
            } else {
                int viewNumber = Integer.parseInt(numb);
                if (viewNumber < 7 || viewNumber > 13) {
                    System.out.print("Выход за границы! Ты ввел -> " + viewNumber + ". Требуется ввод от 7 до 13\nОтвет: ");
                    numb = scanner.nextLine();
                } else if (stringArrayList.contains(numb)) {
                    System.out.print("Ты уже это вводил, забыл?. Попробуй еще раз\nВыбери от 1 до 6, куда желаешь записать число\nОтвет: ");
                    numb = scanner.nextLine();
                } else {
                    stringArrayList.add(numb);
                    break;
                }
            }
        }
        switch (numb) {
            case "7" -> numb = "playerThreeOfAKindPoints";
            case "8" -> numb = "playerFourOfAKindPoints";
            case "9" -> numb = "playerFullHousePoints";
            case "10" -> numb = "playerSmallStraightPoints";
            case "11" -> numb = "playerLargeStraightPoints";
            case "12" -> numb = "playerChancePoints";
            case "13" -> numb = "playerYahtzeePoints";

            default -> System.out.println("Некорректный ввод. Повтори еще раз");

        }
        return numb;
    }
}
