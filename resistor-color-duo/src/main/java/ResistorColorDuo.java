class ResistorColorDuo {
    private static final String[] COLORS = {
        "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
    };
    
    int value(String[] colors) {
        int firstDigit = getColorValue(colors[0]);
        int secondDigit = getColorValue(colors[1]);
        return firstDigit * 10 + secondDigit;
    }
    
    private int getColorValue(String color) {
        for (int i = 0; i < COLORS.length; i++) {
            if (COLORS[i].equals(color)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid color: " + color);
    }
}
