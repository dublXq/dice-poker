import java.util.*;

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

    public static Boolean playerCheckTripleDice(ArrayList<String> diceValues) {
        for (int i = 0; i < diceValues.size(); i++) {
            GlobalVariables.numberDiceForVariable = diceValues.get(i);
            int count = 0;
            for (int j = i + 1; j < diceValues.size(); j++) {
                if (diceValues.get(j).equals(GlobalVariables.numberDiceForVariable)) {
                    count++;
                    if (count == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Boolean playerCheckQuadrupleDice(ArrayList<String> diceValues) {
        for (int i = 0; i < diceValues.size(); i++) {
            GlobalVariables.numberDiceForVariable = diceValues.get(i);
            int count = 0;
            for (int j = i + 1; j < diceValues.size(); j++) {
                if (diceValues.get(j).equals(GlobalVariables.numberDiceForVariable)) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Boolean playerCheckFullHouse(ArrayList<String> diceValues) {
        boolean check = playerCheckTripleDice(diceValues);
        if (check) {
            ArrayList<String> timeVar = new ArrayList<>();
            HashMap<String, Integer> countMap = new HashMap<>();
            for (String diceValue : diceValues) {
                if (countMap.containsKey(diceValue)) {
                    countMap.put(diceValue, countMap.get(diceValue) + 1);
                    if (countMap.get(diceValue) == 3) {
                        timeVar.add(diceValue);
                        countMap.remove(diceValue);
                    }
                } else {
                    countMap.put(diceValue, 1);
                }
            }
            diceValues.removeAll(timeVar);
            for (int i = 0; i < diceValues.size(); i++) {
                GlobalVariables.numberDiceForVariable = diceValues.get(i);
                int count = 0;
                for (int j = i; j < diceValues.size(); j++) {
                    if (diceValues.get(j).equals(GlobalVariables.numberDiceForVariable)) {
                        count++;
                        if (count == 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean playerCheckLittleStreet(HashMap<String, Integer> hashMap, ArrayList<String> diceValues) {
        HashSet<Integer> hashSet = new HashSet<>();
        Set<Integer> values1 = Set.of(1, 2, 3, 4);
        Set<Integer> values2 = Set.of(2, 3, 4, 5);
        Set<Integer> values3 = Set.of(3, 4, 5, 6);
        for (String s : diceValues) {
            if (hashMap.containsKey(s)) {
                hashSet.add(hashMap.get(s));
            }
        }
        for (int i = 0; i < hashSet.size(); i++) {
            if (hashSet.containsAll(values1) || hashSet.containsAll(values2) || hashSet.containsAll(values3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean playerCheckBigStreet(HashMap<String, Integer> hashMap, ArrayList<String> diceValues) {
        HashSet<Integer> hashSet = new HashSet<>();
        Set<Integer> values1 = Set.of(1, 2, 3, 4, 5);
        Set<Integer> values2 = Set.of(2, 3, 4, 5, 6);
        for (String s : diceValues) {
            if (hashMap.containsKey(s)) {
                hashSet.add(hashMap.get(s));
            }
        }
        for (int i = 0; i < hashSet.size(); i++) {
            if (hashSet.containsAll(values1) || hashSet.containsAll(values2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean playerCheckYahtzee(ArrayList<String> diceValues) {
        for (String value : diceValues) {
            long count = diceValues.stream().filter(v -> v.equals(value)).count();
            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    public static void wordBookWordsOfSupport() {
        Random random = new Random();
        ArrayList<String> wordBook = new ArrayList<>();
        wordBook.add("Йоу, а ты молодец! Продолжай в том же духе (👉ﾟヮﾟ)👉");
        wordBook.add("Хах, идешь к победе? Встретимся на финишной прямой ^_^");
        wordBook.add("Мне кажется, или мы встретили Нового Чемпиона в игре Покер на костях o(￣▽￣)ｄ");
        wordBook.add("Обратного пути нет, только вперед! ^_~");
        wordBook.add("Не каждый может шевелить своими извилинами как ты, похвально. Я вижу перед собой Игрока с большой буквы （￣︶￣）↗　");
        wordBook.add("Ты уже близок! Давай! ＼(ﾟｰﾟ＼)");
        wordBook.add("Это игра заставляет думать, а как ты хотел? Не всегда стоит надеяться на удачу (⌐■_■)");
        wordBook.add("Никто не может остановить тебя! ε٩(๑❛ᴗ❛๑)۶з");
        wordBook.add("Ты невероятный, продолжай так же! ＼(｀0´)／");
        wordBook.add("Это сложная игра, но ты справляешься с ней на ура! ＼(￣▽￣)／");
        wordBook.add("Следующий шаг - победа! (✯◡✯)");
        wordBook.add("Ты держишь все под контролем, я верю в тебя! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
        wordBook.add("Игра похожа на тебя, могучая и уверенная! ʕ•ᴥ•ʔ");
        wordBook.add("Ты растешь каждый раз, когда играешь, не останавливайся! ＼(￣▽￣)ノ");
        wordBook.add("Никто не может победить тебя, ты слишком хорош! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
        wordBook.add("Все под контролем, давай вперед! (ง'̀-'́)ง");
        wordBook.add("Ты знаешь, что делаешь, пусть победа будет твоей! (•‿•)");
        wordBook.add("Ты являешься великолепным игроком, удачи в следующем раунде! (✿◕‿◕✿)");
        int randomIndex = random.nextInt(wordBook.size());
        String randomWord = wordBook.get(randomIndex);
        System.out.println(randomWord);
    }
}
