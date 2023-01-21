/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class Launcher {
    public static void main(String[] args) {

        GameSystem gameSystem = new GameSystem();
        gameSystem.cubeRandom(1);
        System.out.println("\n---------------------------------------\n");
        GameSystem.updateArea();

    }


}
