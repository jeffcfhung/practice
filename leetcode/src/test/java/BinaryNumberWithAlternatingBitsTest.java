import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryNumberWithAlternatingBitsTest {
    @Test
    public void solution() {
        assertEquals(BinaryNumberWithAlternatingBits.hasAlternatingBits(5), true);
        assertEquals(BinaryNumberWithAlternatingBits.hasAlternatingBits(7), false);
    }
}