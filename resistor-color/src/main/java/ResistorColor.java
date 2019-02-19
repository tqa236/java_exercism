import java.util.HashMap;

class ResistorColor {
  private static final HashMap<String, Integer> values =
      new HashMap<String, Integer>() {
        {
          put("black", 0);
          put("brown", 1);
          put("red", 2);
          put("orange", 3);
          put("yellow", 4);
          put("green", 5);
          put("blue", 6);
          put("violet", 7);
          put("grey", 8);
          put("white", 9);
        }
      };

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
