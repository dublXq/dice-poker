import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Evgeniy_Tyslevich
 * @link <a href="https://github.com/dublXq">...</a>
 */
public class PlayerPerson {

    public static void playerCalculateBonusPoints() {
        if (GlobalVariables.playerSummaAllNumbers >= 63) {
            GlobalVariables.playerBonusPoints = 35;
            GameSystem.variableNames.remove("playerBonusPoints");
        }
    }

    public void playerCheckTripleDice() {

    }

    public void playerCheckQuadrupleDice() {

    }

    public void playerCheckFullHouse() {

    }

    public void playerCheckStraightDice() {

    }

    public void playerCheckLittleStreet() {

    }

    public void playerCheckBigStreet() {

    }

    public void playerCalculateChance() {

    }

    public void playerCheckYahtzee() {

    }

    public static void wordBookWordsOfSupport(){
        Random random = new Random();
        ArrayList<String> wordBook = new ArrayList<>();
        wordBook.add("Йоу, а ты молодец! Продолжай в том же духе (👉ﾟヮﾟ)👉");
        wordBook.add("Хах, идешь к победе? Встретимся на финишной прямой ^_^");
        wordBook.add("Мне кажется, или мы встретили Нового Чемпиона в игре Покер на костях o(￣▽￣)ｄ");
        wordBook.add("Обратного пути нет, только вперед! ^_~");
        wordBook.add("Не каждый может шевелить своими извилинами как ты, похвально. Я вижу перед собой Игрока с большой буквы （￣︶￣）↗　");
        wordBook.add("Ты уже близок! Давай! ＼(ﾟｰﾟ＼)");
        wordBook.add("Это игра заставляет думать, а как ты хотел? Не всегда стоит надеяться на удачу (⌐■_■)");
        int randomIndex = random.nextInt(wordBook.size());
        String randomWord = wordBook.get(randomIndex);
        System.out.println(randomWord);
    }

}
