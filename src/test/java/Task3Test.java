import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void compute() {
        Result result = Task3.compute(new String[]{"test", "test354", "MegaTest", "привет"});
        System.out.print("Check results... ");
        assertEquals(result.getAppliedArgs().length, 3);
        assertEquals(result.getMaxArgument(), "MegaTest");
        assertTrue(result.isMaxLengthUniq());
        System.out.println("Correct!");
    }
}