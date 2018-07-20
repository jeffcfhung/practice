import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeysAndRoomsTest {

    @Test
    public void solution() {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList(1));
        inputs.add(Arrays.asList(2));
        inputs.add(Arrays.asList(3));
        inputs.add(Arrays.asList());
        assertEquals(true, new KeysAndRooms().canVisitAllRooms(inputs));
        inputs.add(Arrays.asList(1, 3));
        inputs.add(Arrays.asList(3, 0, 1));
        inputs.add(Arrays.asList(3));
        inputs.add(Arrays.asList(0));
        assertEquals(false, new KeysAndRooms().canVisitAllRooms(inputs));
    }
}