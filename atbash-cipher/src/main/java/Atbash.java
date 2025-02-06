class Atbash {

    private static final String PLAIN = "abcdefghijklmnopqrstuvwxyz";
    private static final String CIPHER = "zyxwvutsrqponmlkjihgfedcba";

    String encode(String input) {
        StringBuilder encoded = new StringBuilder();
        input = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        int count = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                encoded.append(CIPHER.charAt(PLAIN.indexOf(c)));
                count++;
            } else {
                encoded.append(c);
                count++;
            }
            if (count == 5) {
                encoded.append(' ');
                count = 0;
            }
        }
        return encoded.toString().trim();
    }

    String decode(String input) {
        StringBuilder decoded = new StringBuilder();
        input = input.replaceAll("[^a-z0-9]", "");
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                decoded.append(PLAIN.charAt(CIPHER.indexOf(c)));
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}