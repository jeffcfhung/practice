import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>(
                (Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) -> {
                    int diff = b.getValue() - a.getValue();
                    if (diff == 0) {
                        return a.getKey() - b.getKey();
                    }
                    return diff;
                }
            );
        pq.addAll(countMap.entrySet());
        StringBuffer sb = new StringBuffer();

        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            for (int i=0; i<curr.getValue(); i++) {
                sb.append(curr.getKey());
            }
        }
        return sb.toString();
    }
}
