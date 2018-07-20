import org.junit.Test;

import static org.junit.Assert.*;

public class PushDominoesTest {

    @Test
    public void solution() {
        PushDominoes pd = new PushDominoes();
        String input = ".L.R...LR..L..";
        assertEquals(pd.pushDominoes(input), "LL.RR.LLRRLL..");
    }
}