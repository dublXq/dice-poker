import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameSystem gameSystem = new GameSystem();
        int timesInt = 3;
        System.out.print("Приветствую! Хочешь сыграть в Покер на костях?\nОтвет: ");
        int numb = scanner.nextInt();
        if (numb == 1) {

            System.out.println("\n---------------------------------------\n");
            System.out.println(gameSystem.arrayList);
            gameSystem.cubeRandom(2, gameSystem.arrayList);

            gameSystem.createAndUpdateArea(gameSystem.arrayList.get(0), gameSystem.arrayList.get(1), gameSystem.arrayList.get(2),
                    gameSystem.arrayList.get(3), gameSystem.arrayList.get(4), gameSystem.arrayList.get(5),
                    gameSystem.arrayList.get(6), gameSystem.arrayList.get(7), gameSystem.arrayList.get(8),
                    gameSystem.arrayList.get(9), gameSystem.arrayList.get(10), gameSystem.arrayList.get(11));
            System.out.println(gameSystem.arrayList);
            System.out.println();
        }
    }
}

