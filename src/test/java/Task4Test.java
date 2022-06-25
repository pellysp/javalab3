import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void compute() {
        ArrayList<String> toTest = new ArrayList<>();
        toTest.add("test");
        toTest.add("Test");
        toTest.add("ttest");
        toTest.add("973");
        toTest.add("test");

        ArrayList<String> result = Task4.compute(toTest);
        System.out.print("Check result correction...");
        assertEquals(result.stream().filter((ri) -> ri.contains("test")).toArray().length, 2);
        System.out.println("Correct!");
    }
}