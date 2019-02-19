import java.util.*;

class Scrabble {

  private String word;
  private int score;
  private static final HashMap<String, Integer> values = new HashMap<String, Integer>();

  {
    values.put("a", 1);
    values.put("e", 1);
    values.put("i", 1);
    values.put("o", 1);
    values.put("u", 1);
    values.put("l", 1);
    values.put("n", 1);
    values.put("r", 1);
    values.put("s", 1);
    values.put("t", 1);
    values.put("d", 2);
    values.put("g", 2);
    values.put("b", 3);
    values.put("c", 3);
    values.put("m", 3);
    values.put("p", 3);
    values.put("f", 4);
    values.put("h", 4);
    values.put("v", 4);
    values.put("w", 4);
    values.put("y", 4);
    values.put("k", 5);
    values.put("j", 8);
    values.put("x", 8);
    values.put("q", 10);
    values.put("z", 10);
  }

  Scrabble(String word) {
    this.word = word;
  }

  public int getScore() {
    for (int i = 0; i < word.length(); i++) {
      score = score + values.get(("" + word.charAt(i)).toLowerCase());
    }
    return score;
  }
}
