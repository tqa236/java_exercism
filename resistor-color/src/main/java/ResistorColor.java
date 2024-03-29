import java.util.*;

class ResistorColor {
    private static final HashMap<String, Integer> values = new HashMap<String, Integer>(){{
      put("black", 0); put("brown", 1); put("red", 2); put("orange", 3);
      put("yellow", 4); put("green", 5); put("blue", 6); put("violet", 7);
      put("grey", 8); put("white", 9);
    }};

    int colorCode(String color) {
        return values.get(color);
    }

    String[] colors() {
        String[] all_colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        return all_colors;
    }
}
