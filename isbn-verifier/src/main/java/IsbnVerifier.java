import java.util.regex.Pattern;

public class IsbnVerifier {

    public boolean isValid(String isbn) {
        String cleanedIsbn = isbn.replace("-", "");

        if (cleanedIsbn.length() != 10) {
            return false;
        }

        if (!Pattern.matches("[0-9X]{10}", cleanedIsbn)) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cleanedIsbn.charAt(i) - '0') * (10 - i);
        }

        char checkChar = cleanedIsbn.charAt(9);
        if (checkChar == 'X') {
            sum += 10;
        } else {
            sum += (checkChar - '0');
        }

        return sum % 11 == 0;
    }
}
