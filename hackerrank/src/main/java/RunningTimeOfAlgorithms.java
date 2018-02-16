import java.util.*;

public class RunningTimeOfAlgorithms {
    static void printArr(int n, int[] arr) {
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    static int runningTime(int[] arr) {
        // Complete this function
        int count = 0;
        for (int i=1; i<arr.length; i++) {
            int value = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > value) {
                arr[j+1] = arr[j];
                j = j-1;
                count++;
            }
            arr[j+1] = value;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = runningTime(arr);
        System.out.println(result);
        in.close();
    }
}
