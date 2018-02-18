import java.util.*;

class Data implements Comparable<Data> {
    public int index;
    public int price;

    Data(int index, int price) {
        this.index = index;
        this.price = price;
    }

    @Override
    public int compareTo(Data a) {
        if (this.price > a.price) return 1;
        else if (this.price < a.price) return -1;
        else return 0;
    }
}

public class IceCreamParlor {

    static Data search(List<Data> arr, int targetPrice, int startIndex) {
        for (int i=arr.size()-1; i>startIndex; i--) {
            if (arr.get(i).price == targetPrice) {
                return arr.get(i);
            }
        }
        return null;
    }

    static int[] icecreamParlor(int m, int[] arr) {
        // Complete this function
        // Sort
        List<Data> flavors = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            flavors.add(new Data(i, arr[i]));
        }

        Collections.sort(flavors);

        int[] res = new int[2];

        for (int i=0; i<flavors.size(); i++) {
            int targetPrice = m - flavors.get(i).price;
            Data targetData = search(flavors, targetPrice, i);
            if (targetData != null) {
                // Found
                if (flavors.get(i).index < targetData.index) {
                    res[0] = flavors.get(i).index + 1;
                    res[1] = targetData.index + 1;
                }
                else {
                    res[0] = targetData.index + 1;
                    res[1] = flavors.get(i).index + 1;
                }
            }
        }

        // Find by sort array, sum = one of min + one of max...

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}