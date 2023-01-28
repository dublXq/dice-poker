import java.awt.*;
import java.awt.image.RasterOp;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class Launcher {
    static Scanner scanner = new Scanner(System.in);
    static Launcher launcher = new Launcher();
    static GameSystem gameSystem = new GameSystem();

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        boolean isFalse = false;
        int time = 3;

        System.out.println("\nПриветствую друг! Тебя приветствует Игра в Покер на костях o(￣▽￣)ｄ");
        while (true) {
            System.out.print("Перед тем, как играть, нужно ознакомится с правилами игры. \nЧтобы перейти к правилам, нажми цифру 1\nОтвет: ");
            String numb = scanner.nextLine();
            if (numb.equals("1")) {
//               Desktop.getDesktop().browse(URI.create("https://github.com/dublXq/dice-poker#readme"));
                break;
            } else {
                System.out.println("Попробуй еще раз");
            }
        }
        System.out.print("Молодец! Первый этап пройден. Ну что, можем приступать?\n1 - Да\n2 - Нет\nОтвет: ");
        int numb_2 = scanner.nextInt();
        do {
            while (true) {
                if (numb_2 == 1) {
                    System.out.println("Желаем удачи в победе!");
                    launcher.start();
                    break;
                } else if (numb_2 == 2) {
                    System.out.println("Удачи! Рад был увидеться!(👉ﾟヮﾟ)👉");
                    return;
                } else {
                    System.out.println("Ошибка, повторите попытку\nВведите цифру = 1\nОтвет: ");
                }
            }

            System.out.print("1 - Перебросить кубики\n2 - Засчитать\nОтвет: ");
            int numb_3 = scanner.nextInt();

            if (numb_3 == 1) {

                GameSystem.arrayCubesRandom.clear();
                GameSystem.arrayList.clear();
                GameSystem.clearAllGlobalVariables();
                time--;
                if (time <= 0) {
                    System.out.println("Это был последний возможный бросок. Выбери куда засчитать очки?");
                    // Код (метод)
                    launcher.methodResultScare();
                    break;
                }
            } else if (numb_3 == 2) {
                // Код, который дает определение куда засчитать очки игрока (метод)
                launcher.methodResultScare();
                isFalse = true;
                break;

            } else {
                System.out.println("Данного варианта нет. Попробуй еще раз");
            }


            if (isFalse) {
                gameSystem.playersBotScore();
                System.out.println("\nБот сделал ход! Ваш черед ^_~");
                isFalse = false;
            }
        } while (true);
    }


    public void start() {
        gameSystem.throwRandomCube();
        gameSystem.playersPersonScore();
        gameSystem.createAndUpdateArea();
    }

    public void methodResultScare() throws IOException {
        // method который дает определение куда засчитать очки игрока
        System.out.print("Куда засчитать очки?\nВНИМАНИЕ! Если забыл, что такое секция, и чем они отличаются, разработчик советует" +
                " вернуться к правилам игры\n0 - Правила игры\n1 - Верхняя секция\n2 - Нижняя секция\nОтвет: ");
        int numb = scanner.nextInt();
        switch (numb) {
            case 0:
                Desktop.getDesktop().browse(URI.create("https://github.com/dublXq/dice-poker#readme"));
            case 1:
                startingMethodNumbers();
            case 2:
                differentMethodNGames();
            default:
                System.out.println("Неверный ввод. Попробуй еще раз");
        }
    }

    public void startingMethodNumbers() {
        System.out.print("1 - Единицы\n2 - Двойки\n3 - Тройки\n4 - Четверки\n5 - Пятерки\n6 - Шестерки\nОтвет: ");
        int numb = scanner.nextInt();
        switch (numb) {
            case 1:
                // если единицы -> перебор массива кубиков -> находим единицы -> сумма -> GlobalVariables.playerNumberOfUnits
                break;
            case 2:
                // если двойки -> перебор массива кубиков -> находим двойки -> сумма -> GlobalVariables.playerNumberOfDeuces
                break;
            case 3:
                // если тройки -> перебор массива кубиков -> находим тройки -> сумма -> GlobalVariables.playerNumberOfTriplets
                break;
            case 4:
                // если четверки -> перебор массива кубиков -> находим четверки -> сумма -> GlobalVariables.playerNumberOfFours
                break;
            case 5:
                // если пятерки -> перебор массива кубиков -> находим пятерки -> сумма -> GlobalVariables.playerNumberOfFives
                break;
            case 6:
                // если шестерки -> перебор массива кубиков -> находим шестерки -> сумма -> GlobalVariables.playerNumberOfSixes
                break;
            default:
                System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повторите еще раз");
        }
    }

    public void differentMethodNGames() {
        System.out.print("1 - Три одинаковых\n2 - Четыре одинаковых\n3 - Фулл-хаус\n4 - Маленький стрит\n5 - Большой стрит\n6 - Шанс\n7 - Yahtzee\nОтвет: ");
        int numb = scanner.nextInt();
        switch (numb) {
            case 1:
                // если Три одинаковых -> перебор массива кубиков -> находим Три одинаковых числа -> сумма -> GlobalVariables.playerThreeOfAKindPoints
                break;
            case 2:
                // если Четыре одинаковых -> перебор массива кубиков -> находим Четыре одинаковых числа -> сумма -> GlobalVariables.playerFourOfAKindPoints
                break;
            case 3:
                // если Фулл-хаус -> перебор массива кубиков -> находим "Фулл-хаус" -> сумма -> GlobalVariables.playerFullHousePoints
                break;
            case 4:
                // если Маленький стрит -> перебор массива кубиков -> находим Маленький стрит -> сумма -> GlobalVariables.playerSmallStraightPoints
                break;
            case 5:
                // если Большой стрит -> перебор массива кубиков -> Большой стрит -> сумма -> GlobalVariables.playerLargeStraightPoints
                break;
            case 6:
                // если Шанс -> перебор массива кубиков -> находим Шанс -> сумма -> GlobalVariables.playerChancePoints
                break;
            case 7:
                // если Yahtzee -> перебор массива кубиков -> находим Yahtzee -> сумма -> GlobalVariables.playerYahtzeePoints
                break;
            default:
                System.out.println("Ты ввел не корректное число. Проверь пожалуйста, и повторите еще раз");
        }
    }
}
