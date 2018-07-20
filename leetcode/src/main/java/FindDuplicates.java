import javafx.scene.layout.Priority;

import java.util.*;

public class FindDuplicates {
    public static int[] findDuplicates(int[] arr) {
        int[] res;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a)->a[1]).reversed());
        for (int i : arr) {
            int count = map.getOrDefault(i, 0);
            map.put(i, ++count);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        res = new int[pq.size()];

        int j=0;
        while(!pq.isEmpty()) {
            res[j++] = pq.poll()[0];
        }

        return res;
    }
}
