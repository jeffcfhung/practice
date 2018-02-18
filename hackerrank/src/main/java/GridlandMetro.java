import java.util.*;

class Data implements Comparable<Data> {
    public long start;
    public long end;

    Data(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Data a) {
        if (start > a.start) return 1;
        else if (start < a.start) return -1;
        return 0;
    }
}

public class GridlandMetro {
    static long merge(List<Data> input) {
        if (input.size() <= 0) return 0;

        Collections.sort(input, new Comparator<Data>() {
            public int compare(Data a, Data b) {
                return a.compareTo(b);
            }
        });

        Stack<Data> stack = new Stack<>();
        stack.push(input.get(0));

        for (int i=1; i<input.size(); i++) {
            Data a = stack.pop();
            Data b = input.get(i);
            if (a.end < b.start) {
                // No connection
                stack.push(a);
                stack.push(b);
            }
            else if (a.end > b.start) {
                // Overlap
                if (a.end < b.end) {
                    a.end = b.end;
                }
                stack.push(a);
            }
            else {
                a.end = b.end;
                stack.push(a);
            }
        }

        long total = 0;
        for (Data s : stack) {
            total += s.end - s.start + 1;
        }
        return total;
    }

    static long gridlandMetro(int n, int m, int k, int[][] track) {
        // Complete this function
        long total = (long)n * (long)m;

        Map<Integer, List<Data>> trackMap = new HashMap<>();

        for (int i=0; i<k; i++) {
            int index = track[i][0];
            List<Data> r;
            if (trackMap.containsKey(index)) {
                r = trackMap.get(index);
            }
            else {
                r = new ArrayList<>();
                trackMap.put(index, r);
            }
            r.add(new Data(track[i][1], track[i][2]));
        }

        long trackUnits = 0;

        Iterator<Map.Entry<Integer, List<Data>>> iterator = trackMap.entrySet().iterator();
        while (iterator.hasNext()) {
            trackUnits += merge(iterator.next().getValue());
        }

        return total - trackUnits;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] track = new int[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        long result = gridlandMetro(n, m, k, track);
        System.out.println(result);
        in.close();
    }
}


