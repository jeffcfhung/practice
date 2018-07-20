import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {

    @Test
    public void TestResult() {
        assertEquals(ReverseString.reverseString("taabbccdd"), "ddccbbaat");
    }
}