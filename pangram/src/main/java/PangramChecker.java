import java.util.*;

public class PangramChecker {

  public boolean isPangram(String input) {
    Set<Character> letters = new HashSet<Character>();
    String sentence = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
    for (char c : sentence.toCharArray()) {
      letters.add(c);
    }

    return letters.size() == 26 ? true : false;
  }
}
