import java.util.*;

public class FullCountingSort {
    private final ArrayList<Data> data = new ArrayList<>();

    public void sort() {
        int COUNT_SIZE = 101;
        int[] counts = new int[COUNT_SIZE];
        for (Data d : data) {
            counts[d.x+1]++;
        }

        for (int i=1; i<COUNT_SIZE; i++) {
            counts[i] += counts[i-1];
        }

        String[] output = new String[data.size()];
        for (Data d : data) {
            output[counts[d.x]++] = d.s;
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<output.length; i++) {
            //System.out.print(output[i] + (i != output.length-1 ? " ": ""));
            sb.append(output[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }

    public void addData(int x, String s) {
        data.add(new Data(x, s));
    }

    private class Data {
        private int x;
        private String s;

        public Data(int x, String s) {
            this.x = x;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        FullCountingSort fcs = new FullCountingSort();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            String s = in.next();
            if (a0 < n/2) {
                s = "-";
            }
            fcs.addData(x, s);
        }

        in.close();
        fcs.sort();
    }
}
