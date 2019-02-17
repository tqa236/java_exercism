import java.util.*;

class Scrabble {

  private String word;
  private int score;
  private static final HashMap<String, Integer> values =
      new HashMap<String, Integer>() {
        {
          put("a", 1);
          put("e", 1);
          put("i", 1);
          put("o", 1);
          put("u", 1);
          put("l", 1);
          put("n", 1);
          put("r", 1);
          put("s", 1);
          put("t", 1);
          put("d", 2);
          put("g", 2);
          put("b", 3);
          put("c", 3);
          put("m", 3);
          put("p", 3);
          put("f", 4);
          put("h", 4);
          put("v", 4);
          put("w", 4);
          put("y", 4);
          put("k", 5);
          put("j", 8);
          put("x", 8);
          put("q", 10);
          put("z", 10);
        }
      };

  Scrabble(String word) {
    this.word = word;
  }

  int getScore() {
    for (int i = 0; i < word.length(); i++) {
      score = score + values.get(("" + word.charAt(i)).toLowerCase());
    }
    return score;
  }
}
