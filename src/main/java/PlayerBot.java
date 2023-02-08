import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class PlayerBot {

    public static void playerBotCalculateBonusPoints() {
        if (GlobalVariables.botSummaAllNumbers >= 63) {
            GlobalVariables.botBonusPoints = 35;
            GameSystem.variableNames.remove("botBonusPoints");
        }
    }
}
