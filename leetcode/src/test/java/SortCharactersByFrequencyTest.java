import org.junit.Test;

import static org.junit.Assert.*;

public class SortCharactersByFrequencyTest {

    @Test
    public void solution() {
        String input = "tree";
        assertEquals("eert", new SortCharactersByFrequency().frequencySort(input));
    }
}