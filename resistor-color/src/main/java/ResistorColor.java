import java.util.HashMap;

class ResistorColor {
  private static final HashMap<String, Integer> values = new HashMap<String, Integer>();

  static {
    values.put("black", 0);
    values.put("brown", 1);
    values.put("red", 2);
    values.put("orange", 3);
    values.put("yellow", 4);
    values.put("green", 5);
    values.put("blue", 6);
    values.put("violet", 7);
    values.put("grey", 8);
    values.put("white", 9);
  }

  public int colorCode(String color) {
    return values.get(color);
  }

  public String[] colors() {
    String[] allColors = {
      "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
    };
    return allColors;
  }
}
