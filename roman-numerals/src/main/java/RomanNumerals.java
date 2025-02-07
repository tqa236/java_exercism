class RomanNumerals {
    private final int number;

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    RomanNumerals(int number) {
        this.number = number;
    }

    String getRomanNumeral() {
        StringBuilder roman = new StringBuilder();
        int remainder = number;

        for (int i = 0; i < VALUES.length; i++) {
            while (remainder >= VALUES[i]) {
                roman.append(SYMBOLS[i]);
                remainder -= VALUES[i];
            }
        }

        return roman.toString();
    }
}
