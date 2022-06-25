import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Task1CLI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    private static String getInput() throws Exception {
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new Exception("Error during text input: " + e.getMessage());
        }

        return input;
    }

    private static String getText() {
        System.out.println("Please, enter text:");
        String text = "";

        try {
            text = getInput();
        } catch (Exception e) {
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ac dolor nec sem mattis tempor. In hac habitasse platea dictumst. Sed vulputate facilisis scelerisque. Duis id varius lacus, eget tincidunt nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Cras quis porta tellus. Pellentesque ultricies, metus in gravida placerat, elit enim imperdiet ipsum, eget euismod arcu urna non mi. Nam id leo ac nisi aliquet dapibus. In ornare lacus sed iaculis dictum. Integer lacinia tellus vitae justo mattis, et porttitor risus cursus.";
        }

        return text;
    }

    public static <R> R getLineWithCallback(Function<String, R> callback) throws Exception {
        String line = getInput();

        if (line.equals("-")) {
            throw new Exception("Input has finish sign `-`");
        }

        return callback.apply(line);
    }

    public static void main(String[] args) {
        String text = getText();
        Task1 task1 = new Task1(text);

        while (true) {
            try {
                System.out.println();
                System.out.print("Please, enter text to search: ");
                System.out.println("Index of input in text: " + getLineWithCallback(task1::search));
            } catch (Exception e) {
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                return;
            }
        }
    }
}
