import java.util.*;

public class FriendsOfAppropriateAges {
    public static int numFriendRequests(int[] ages) {
        final int AGES = 121;
        int[] ageCounts = new int[AGES];

        for (int age : ages) {
            ageCounts[age]++;
        }

        int sum = 0;
        for (int i=1; i<AGES; i++) {
            for (int j=(i/2)+8; j<=i; j++) {
                sum += ageCounts[j] * (ageCounts[i]-(i==j?1:0));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] ages = new int[count];
        int i=0;
        while (in.hasNext()) {
            ages[i] = in.nextInt();
            //System.out.println(ages[i]);
            i++;
        }
        System.out.println(numFriendRequests(ages));
    }
}
