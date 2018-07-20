import org.junit.Test;

import static org.junit.Assert.*;

public class BitwiseANDofNumbersRangeTest {
    @Test
    public void solution() {
        assertEquals(BitwiseANDofNumbersRange.rangeBitwiseAnd(5, 7), 4);
        assertEquals(BitwiseANDofNumbersRange.rangeBitwiseAnd(0, 1), 0);
    }
}