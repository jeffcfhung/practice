import org.junit.Test;

import static org.junit.Assert.*;

public class GoatLatinTest {
    @Test
    public void name() {
        String res = GoatLatin.toGoatLatin("abc dddd");
        System.out.println(res);
    }
}