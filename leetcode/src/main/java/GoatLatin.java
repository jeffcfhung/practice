import java.util.*;

public class GoatLatin {
    static public String toGoatLatin(String S) {
        Character[] ch = new Character[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowels = new HashSet<>(Arrays.asList(ch));
        String[] arr = S.split("\\s+");
        StringBuffer sb = new StringBuffer();

        for (int i=0; i<arr.length; i++) {
            char first = arr[i].charAt(0);
            if (vowels.contains(first)) {
                sb.append(arr[i]);
            }
            else {
                sb.append(arr[i].substring(1, arr[i].length()));
                sb.append(arr[i].charAt(0));
            }
            sb.append("ma");
            for (int j=0; j<=i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        System.out.println(toGoatLatin(input));
    }
}
