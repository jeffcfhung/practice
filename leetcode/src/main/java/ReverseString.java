public class ReverseString {
    static String reverseString(String s) {
        StringBuffer bf = new StringBuffer();
        for (int i=s.length()-1; i>=0; i--) {
            bf.append(s.charAt(i));
        }
        return bf.toString();
    }
}
