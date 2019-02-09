import java.util.*;

public class PangramChecker {

    public boolean isPangram(String input) {
        Set<Character> letters = new HashSet<Character>();
        input = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        for (char c : input.toCharArray()) {
            letters.add(c);
        }

        return letters.size() == 26 ? true: false;
    }

}
