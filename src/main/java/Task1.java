import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task1 {
    private String text = "";

    public ArrayList<Integer> search(String input) {
        return Pattern
                .compile(input)
                .matcher(text)
                .results()
                .map(MatchResult::start)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Task1(String text) {
        this.text = text;
    }
}
