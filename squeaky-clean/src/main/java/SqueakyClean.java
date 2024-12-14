import java.util.regex.Pattern;
import java.util.stream.Collectors;

class SqueakyClean {
    static String clean(String identifier) {
        identifier = identifier
                .replace("4", "a")
                .replace("3", "e")
                .replace("0", "o")
                .replace("1", "l")
                .replace("7", "t");

        return Pattern.compile("-(.)").matcher(identifier.replaceAll(" ", "_").replaceAll("\\p{Cc}", "CTRL"))
                .replaceAll(mr -> mr.group(1).toUpperCase()).chars()
                .filter(c -> Character.isLetter(c) || c == '_')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining()).replaceAll("[α-ω]", "");
    }
}
