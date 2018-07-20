import java.util.*;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("\\pP", "").toLowerCase().split("\\s+");
        Set<String> bannedMap = new HashSet(Arrays.asList(banned));
        Map<String, Integer> countMap = new HashMap<>();

        int max = 0;
        String res = "";
        for (String word : words) {
            if (bannedMap.contains(word)) continue;

            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            if (max < countMap.get(word)) {
                max = countMap.get(word);
                res = word;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String paragraph = in.nextLine();
        String[] banned = in.nextLine().split(" ");

        System.out.println(mostCommonWord(paragraph, banned));
    }
}
