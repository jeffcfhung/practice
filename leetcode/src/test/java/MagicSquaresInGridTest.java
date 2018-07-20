import org.junit.Test;

import static org.junit.Assert.*;

public class MagicSquaresInGridTest {

    @Test
    public void solution() {
        int[][] grid = {
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        };
        assertEquals(1, new MagicSquaresInGrid().numMagicSquaresInside(grid));
    }
}