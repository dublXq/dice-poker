import java.util.Scanner;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int timesInt = 3;
        System.out.print("Приветствую! Хочешь сыграть в Покер на костях?\nОтвет: ");
        int numb = scanner.nextInt();
        if (numb == 1) {
            GameSystem gameSystem = new GameSystem();

            System.out.println("\n---------------------------------------\n");
            System.out.println();
            gameSystem.start();
            System.out.println(gameSystem.arrayList);
        }
    }
}
