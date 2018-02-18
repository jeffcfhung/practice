import java.util.*;

public class MinimumLoss {
    class Data implements Comparable<Data> {
        int index;
        long price;

        @Override
        public int compareTo(Data a) {
            if (this.price > a.price) return 1;
            else if (this.price < a.price ) return -1;
            return 0;
        }
    }

    static int minimumLoss(long[] price) {
        // Complete this function
        MinimumLoss ml = new MinimumLoss();
        List<Data> indices = new ArrayList<>();

        for (int i=0; i<price.length; i++) {
            Data d = ml.new Data();
            d.index = i;
            d.price = price[i];
            indices.add(d);
        }

        Collections.sort(indices);

        long min = Long.MAX_VALUE;
        for (int i=1; i<indices.size(); i++) {
            Data a = indices.get(i-1);
            Data b = indices.get(i);
            if (min > (b.price - a.price) && b.index < a.index) {
                min = b.price - a.price;
            }
        }

        return (int) min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] price = new long[n];
        for(int price_i = 0; price_i < n; price_i++){
            price[price_i] = in.nextLong();
        }
        int result = minimumLoss(price);
        System.out.println(result);
        in.close();
    }
}

