import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task4 {

    public static ArrayList<String> compute(ArrayList<String> args) {
        String pattern = args.remove(0);
        return args.stream().filter((arg) -> arg.contains(pattern)).collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        ArrayList<String> argsList = Arrays.stream(args).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Input args: " + Arrays.toString(args));
        System.out.println("Number of args to test: " + (args.length - 1));
        ArrayList<String> computed = compute(argsList);
        System.out.println(computed.size() == 0 ? "Matches not fount" : "Matches: " + computed);
    }
}
