import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    static Task1 task1;

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        task1 = new Task1("Strategic thinking you can process a wide variety of inputs to produce a clear, prioritized plan of action that represents the needs of all our users.");
    }

    @org.junit.jupiter.api.Test
    void search() {
        ArrayList<Integer> result = task1.search("S");

        System.out.print("Some checks of searching... ");
        assertEquals(result.get(0), 0);

        result = task1.search("t");
        assertEquals(result.size(), 12);
        System.out.println("Complete!");
    }
}