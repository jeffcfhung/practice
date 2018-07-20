import org.junit.Test;

import static org.junit.Assert.*;

public class FindDuplicatesTest {
    @Test
    public void findDuplicates() {
        int[] arr = {5, 4, 7, 5, 6, 5, 4};
        int[] res = FindDuplicates.findDuplicates(arr);
        assertArrayEquals(res, new int[] {5, 4});
    }
    @Test
    public void findDuplicates1() {
        int[] arr = {5, 4, 7, 5, 6, 5, 4, 6};
        int[] res = FindDuplicates.findDuplicates(arr);
        assertArrayEquals(res, new int[] {5, 6, 4});
    }
}