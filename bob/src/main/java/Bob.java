class Bob {

    String hey(String input) {
        input = input.trim();
        if (input.equals("")) {
            return "Fine. Be that way!";
        }
        boolean isQuestion = input.endsWith("?");
        boolean containsLetter = input.chars().anyMatch(Character::isLetter);
        boolean isYell = containsLetter && input.equals(input.toUpperCase());

        if (isQuestion && isYell) {
            return "Calm down, I know what I'm doing!";
        }
        if (isQuestion) {
            return "Sure.";
        }
        if (isYell) {
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }

}