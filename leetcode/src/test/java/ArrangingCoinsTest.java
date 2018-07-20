import org.junit.Test;

import static org.junit.Assert.*;

public class ArrangingCoinsTest {
    @Test
    public void solution() {
        assertEquals(ArrangingCoins.arrangeCoins(5), 2);
        assertEquals(ArrangingCoins.arrangeCoins(8), 3);
        assertEquals(ArrangingCoins.arrangeCoins(0), 0);
        assertEquals(ArrangingCoins.arrangeCoins(1), 1);
        assertEquals(ArrangingCoins.arrangeCoins(1804289383L), 60070);
    }
}