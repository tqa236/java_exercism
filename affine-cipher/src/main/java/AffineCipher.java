public class AffineCipher {

    private static final int ALPHABET_SIZE = 26;

    private boolean isCoprime(int a, int b) {
        return gcd(a, b) == 1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String encode(String text, int coefficient1, int coefficient2) {
        if (gcd(coefficient1, ALPHABET_SIZE) != 1) {
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }

        StringBuilder encodedText = new StringBuilder();
        text = text.toLowerCase();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int x = c - 'a';
                int encryptedChar = (coefficient1 * x + coefficient2) % ALPHABET_SIZE;
                encodedText.append((char) ('a' + encryptedChar));
            }
            else if (Character.isDigit(c)) {
                encodedText.append(c);
            }
        }

        return addSpacesEveryFiveChars(encodedText.toString());
    }

    public String decode(String encodedText, int coefficient1, int coefficient2) {
        encodedText = encodedText.replaceAll(" ", "");

        int modInverse = modInverse(coefficient1, ALPHABET_SIZE);
        if (modInverse == -1) {
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }

        StringBuilder decodedText = new StringBuilder();

        for (char c : encodedText.toCharArray()) {
            if (Character.isLetter(c)) {
                int y = c - 'a';
                int x = (modInverse * (y - coefficient2 + ALPHABET_SIZE)) % ALPHABET_SIZE;
                decodedText.append((char) ('a' + (x + ALPHABET_SIZE) % ALPHABET_SIZE));
            }
            else if (Character.isDigit(c)) {
                decodedText.append(c);
            }
        }

        return decodedText.toString();
    }

    private int modInverse(int a, int m) {
        int t = 0, newT = 1;
        int r = m, newR = a;

        while (newR != 0) {
            int quotient = r / newR;

            int tempT = t;
            t = newT;
            newT = tempT - quotient * newT;

            int tempR = r;
            r = newR;
            newR = tempR - quotient * newR;
        }

        if (r > 1) return -1;
        if (t < 0) t += m;

        return t;
    }

    private String addSpacesEveryFiveChars(String text) {
        StringBuilder resultWithSpaces = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            resultWithSpaces.append(text.charAt(i));
            if ((i + 1) % 5 == 0 && i + 1 != text.length()) {
                resultWithSpaces.append(' ');
            }
        }
        return resultWithSpaces.toString();
    }
}
