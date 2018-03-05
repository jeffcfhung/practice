import java.util.*;

public class MarcsCakewalk {

    static long marcsCakewalk(int[] calorie) {
        // Complete this function
        Arrays.sort(calorie);
        //System.out.println("Max:" + Long.MAX_VALUE);

        long sum = 0;
        // Descending order to minimize calories
        for (int i = 0, j = calorie.length-1; i < calorie.length; i++, j--) {
            long c = (long) calorie[j] * ((long) 1 << i);
            sum += c;
            //System.out.println(c + "--" + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calorie = new int[n];
        for(int calorie_i = 0; calorie_i < n; calorie_i++){
            calorie[calorie_i] = in.nextInt();
        }
        long result = marcsCakewalk(calorie);
        System.out.println(result);
        in.close();
    }
}
