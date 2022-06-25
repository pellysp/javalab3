import java.util.Arrays;
import java.util.Comparator;

public class Task3 {

    public static Result compute(String[] args) {
        String[] appliedArg = Arrays.stream(args).filter((arg) -> arg.matches("^[a-zA-Zа-яА-Я]*$")).toArray(String[]::new);
        String maxStringLength = Arrays.stream(appliedArg).max(Comparator.comparingInt(String::length)).orElse("");

        int[] appliedArgLength =  Arrays.stream(appliedArg).mapToInt(String::length).toArray();
        int maxAppliedLength = Arrays.stream(appliedArgLength).reduce(Math::max).orElse(-1);
        boolean isMaxUniq = Arrays.stream(appliedArgLength).filter((l) -> l == maxAppliedLength).toArray().length == 1;
        return new Result(appliedArg, isMaxUniq, maxStringLength);
    }

    public static void main(String[] args) {
        System.out.println("Input args: " + Arrays.toString(args));

        Result result = compute(args);
        System.out.println("\n" + result);
    }
}

class Result {
    public String[] getAppliedArgs() {
        return appliedArgs;
    }

    public boolean isMaxLengthUniq() {
        return isMaxLengthUniq;
    }

    public String getMaxArgument() {
        return maxArgument;
    }

    private String[] appliedArgs;
    private boolean isMaxLengthUniq = true;
    private String maxArgument = "";

    Result(String[] appliedArgs, boolean isMaxLengthUniq, String maxArgument) {
        this.appliedArgs = appliedArgs;
        this.isMaxLengthUniq = isMaxLengthUniq;
        this.maxArgument = maxArgument;
    }

    @Override
    public String toString() {
        return "Result: \n" +
                "Applied args = " + Arrays.toString(appliedArgs) + "\n" +
                "Max argument = " + (isMaxLengthUniq ? maxArgument : "Max argument didn't exists") + "\n";
    }
}
