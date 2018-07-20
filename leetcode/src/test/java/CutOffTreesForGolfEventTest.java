import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class CutOffTreesForGolfEventTest {
    @Test
    public void solution() {
        List<List<Integer>> forest = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(0, 0, 4),
                Arrays.asList(7, 6, 5)
        );
        CutOffTreesForGolfEvent ce = new CutOffTreesForGolfEvent();

        assertEquals(ce.cutOffTree(forest), 6);
    }
}