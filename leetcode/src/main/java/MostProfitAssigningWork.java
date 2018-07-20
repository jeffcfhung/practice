import java.util.*;

public class MostProfitAssigningWork {
    static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] arr = new int[difficulty.length][2];
        for (int i=0; i<arr.length; i++) {
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr, Comparator.comparing((int[] o)->o[0]));
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i=1; i<arr.length; i++) {
            if (arr[i][1] < arr[i-1][1]) {
                arr[i][1] = arr[i-1][1];
            }
        }
        for (int i=0; i<arr.length; i++) {
            //System.out.println(arr[i][0] + " " + arr[i][1]);
            map.put(arr[i][0], arr[i][1]);
        }

        int sum = 0;
        for (int i=0; i<worker.length; i++) {
            int ability = worker[i];
            Integer index = map.floorKey(ability);
            if (index != null) {
                sum += map.get(index);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int difficultyNum = in.nextInt();
        int[] difficulty = new int[difficultyNum];

        for (int i=0; i<difficultyNum; i++) {
            difficulty[i] = in.nextInt();
        }

        int profitNum = in.nextInt();
        int[] profit = new int[profitNum];
        for (int i=0; i<profitNum; i++) {
            profit[i] = in.nextInt();
        }

        int workerNum = in.nextInt();
        int[] worker = new int[workerNum];
        for (int i=0; i<workerNum; i++) {
            worker[i] = in.nextInt();
        }
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }
}
