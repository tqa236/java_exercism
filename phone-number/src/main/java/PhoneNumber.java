public class PhoneNumber {
    private final String number;

    public PhoneNumber(String input) {
        this.number = validateAndCleanNumber(input);
    }

    public String getNumber() {
        return number;
    }

    private String validateAndCleanNumber(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input cannot be null or empty");
        }
        if (input.startsWith("+")) {
            input = input.substring(1);
        }
        String cleaned = input.replaceAll("[\\s().-]", "");

        if (cleaned.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("letters not permitted");
        }

        if (cleaned.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        if (cleaned.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        }

        if (cleaned.length() > 11) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
        }

        if (cleaned.length() == 11) {
            if (cleaned.charAt(0) != '1') {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
            cleaned = cleaned.substring(1);
        }

        if (cleaned.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (cleaned.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }

        if (cleaned.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (cleaned.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }

        return cleaned;
    }
}
