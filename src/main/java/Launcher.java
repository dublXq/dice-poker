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
    static boolean isFalseBoolean = false;
    static boolean isFalse = false;

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {


        int time = 3;

        System.out.println("\nПриветствую друг! Тебя приветствует Игра в Покер на костях o(￣▽￣)ｄ");
        while (true) {
            System.out.print("Перед тем, как играть, нужно ознакомится с правилами игры. \nЧтобы перейти к правилам, нажми цифру 1\nОтвет: ");
            String numb = scanner.nextLine();
            if (numb.equals("1")) {
                Desktop.getDesktop().browse(URI.create("https://github.com/dublXq/dice-poker#readme"));
                break;
            } else {
                System.out.println("Попробуй еще раз");
            }
        }

        while (true) {
            // Инициализация
            gameSystem.arrayCubesRandom.clear();
            GameSystem.arrayList.clear();
            GameSystem.clearAllGlobalVariables();

            System.out.print("Молодец! Первый этап пройден. Ну что, можем приступать?\n1 - Да\n2 - Нет\nОтвет: ");
            String numb_2 = scanner.nextLine();


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

        System.out.println("Ну что, продолжаем. 2-й раунд.\nНапоминаем что вам нужно собрать 63 балла, чтобы получить бонус в 35 очков ^_^");
        gameSystem.arrayCubesRandom.clear();
        GameSystem.arrayList.clear();
        GameSystem.clearAllGlobalVariables();
        launcher.start();
        RollOrScore(time);


//        if (isFalse) {
//            gameSystem.playersBotScore();
//            gameSystem.createAndUpdateArea();
//            System.out.println("\nБот сделал ход! Ваш черед ^_~");
//            isFalse = false;
//        }

    }

    private static void RollOrScore(int time) throws IOException, NoSuchFieldException, IllegalAccessException {

        while (true) {
            System.out.print("1 - Перебросить кубики\n2 - Засчитать\nОтвет: ");
            String numb_3 = scanner.nextLine();
            if (numb_3.equals("1")) {
                gameSystem.arrayCubesRandom.clear();
                GameSystem.arrayList.clear();
                GameSystem.clearAllGlobalVariables();
                if (time == 0) {
                    System.out.println("Это был последний возможный бросок. Выбери куда засчитать очки?");
                    // Код (метод)
                    launcher.methodResultScare();
                    break;

                } else {
                    launcher.start();
                    time--;
                }

            } else if (numb_3.equals("2")) {
                // Код, который дает определение куда засчитать очки игрока (метод)
                time = 3;
                launcher.methodResultScare();
                break;

            } else {
                System.out.println("Данного варианта нет. Попробуй еще раз");
            }
        }
    }


    public void start() {
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
                    case 2 -> getPersonLowerSelection();
                    default -> System.out.println("Неверный ввод. Попробуй еще раз");
                }
                isFalse = true;
                break;
            }
        } while (true);
    }

    //ТРЕБУЕТСЯ УСЛОВИЕ = ЕСЛИ ОТВЕТ БЫЛ УЖЕ ВЫБРАН (1-6), ТО ЭТОТ ОТВЕТ УДАЛЯЕТСЯ ИЗ МАССИВА GameSystem.variableNames
    public void startingMethodNumbers() throws NoSuchFieldException, IllegalAccessException {

        String numb = getPersonUpperSelection();
        resetVariableValue(numb);
        smartSimplificationMethod(numb);

    }

    private static void smartSimplificationMethod(String numb) {
        int stream;
        switch (numb) {
            case "playerNumberOfUnits" -> {
                // если единицы -> перебор массива кубиков -> находим единицы -> сумма -> GlobalVariables.playerNumberOfUnits
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceOne::equals).count();
                GlobalVariables.playerNumberOfUnits = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("playerNumberOfUnits");
                System.out.println(GameSystem.variableNames);
            }
            case "playerNumberOfDeuces" -> {
                // если двойки -> перебор массива кубиков -> находим двойки -> сумма -> GlobalVariables.playerNumberOfDeuces
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceTwo::equals).count();
                stream = stream * gameSystem.CUBE_TWO;
                GlobalVariables.playerNumberOfDeuces = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("playerNumberOfDeuces");
            }
            case "playerNumberOfTriplets" -> {
                // если тройки -> перебор массива кубиков -> находим тройки -> сумма -> GlobalVariables.playerNumberOfTriplets
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceThree::equals).count();
                stream = stream * gameSystem.CUBE_THREE;
                GlobalVariables.playerNumberOfTriplets = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("playerNumberOfTriplets");
            }
            case "playerNumberOfFours" -> {
//                 если четверки -> перебор массива кубиков -> находим четверки -> сумма -> GlobalVariables.playerNumberOfFours
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceFour::equals).count();
                stream = stream * gameSystem.CUBE_FOUR;
                GlobalVariables.playerNumberOfFours = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("playerNumberOfFours");
            }
            case "playerNumberOfFives" -> {
//                 если пятерки -> перебор массива кубиков -> находим пятерки -> сумма -> GlobalVariables.playerNumberOfFives
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceFive::equals).count();
                stream = stream * gameSystem.CUBE_FIVE;
                GlobalVariables.playerNumberOfFives = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("playerNumberOfFives");
            }
            case "playerNumberOfSixes" -> {
//                 если шестерки -> перебор массива кубиков -> находим шестерки -> сумма -> GlobalVariables.playerNumberOfSixes
                stream = (int) gameSystem.arrayCubesRandom.stream().filter(gameSystem.diceSix::equals).count();
                stream = stream * gameSystem.CUBE_SIX;
                GlobalVariables.playerNumberOfSixes = stream;
                gameSystem.createAndUpdateArea();
                GameSystem.variableNames.remove("playerNumberOfSixes");
            }
            default -> System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повтори еще раз");
        }
    }

    private static void resetVariableValue(String numb) throws IllegalAccessException, NoSuchFieldException {


        for (String variableName : GameSystem.variableNames) {
            if (variableName.contains(numb)) {
                GlobalVariables.class.getField(variableName).set(null, 0);
//                isFalseBoolean = true;
            }
        }
        if (isFalseBoolean) {
            System.out.println("Вы уже ввели это");
            isFalseBoolean = false;
        }
    }

    private static String getPersonUpperSelection() throws NoSuchFieldException, IllegalAccessException {
        System.out.print("1 - Единицы\n2 - Двойки\n3 - Тройки\n4 - Четверки\n5 - Пятерки\n6 - Шестерки\nОтвет: ");
        String numb = scanner.nextLine();
        numb = scanner.nextLine();

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


    public static String getPersonLowerSelection() throws NoSuchFieldException, IllegalAccessException {
        System.out.print("1 - Три одинаковых\n2 - Четыре одинаковых\n3 - Фулл-хаус\n4 - Маленький стрит\n5 - Большой стрит\n6 - Шанс\n7 - Yahtzee\nОтвет: ");
        String numb = scanner.nextLine();

        GameSystem.clearAllGlobalVariables();


        switch (numb) {
            case "1":
                // если Три одинаковых -> перебор массива кубиков -> находим Три одинаковых числа -> сумма -> GlobalVariables.playerThreeOfAKindPoints
                numb = "playerThreeOfAKindPoints";
                break;
            case "2":
                // если Четыре одинаковых -> перебор массива кубиков -> находим Четыре одинаковых числа -> сумма -> GlobalVariables.playerFourOfAKindPoints
                numb = "playerFourOfAKindPoints";
                break;
            case "3":
                // если Фулл-хаус -> перебор массива кубиков -> находим "Фулл-хаус" -> сумма -> GlobalVariables.playerFullHousePoints
                numb = "playerFullHousePoints";
                break;
            case "4":
                // если Маленький стрит -> перебор массива кубиков -> находим Маленький стрит -> сумма -> GlobalVariables.playerSmallStraightPoints
                numb = "playerSmallStraightPoints";
                break;
            case "5":
                // если Большой стрит -> перебор массива кубиков -> Большой стрит -> сумма -> GlobalVariables.playerLargeStraightPoints
                numb = "playerLargeStraightPoints";
                break;
            case "6":
                // если Шанс -> перебор массива кубиков -> находим Шанс -> сумма -> GlobalVariables.playerChancePoints
                numb = "playerChancePoints";
                break;
            case "7":
                // если Yahtzee -> перебор массива кубиков -> находим Yahtzee -> сумма -> GlobalVariables.playerYahtzeePoints
                numb = "playerYahtzeePoints";
                break;
            default:
                System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повторите еще раз");
        }
        return numb;
    }
}
