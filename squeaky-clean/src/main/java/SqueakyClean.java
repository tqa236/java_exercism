import java.util.regex.Pattern;
import java.util.stream.Collectors;

class SqueakyClean {
    static String clean(String identifier) {
        return Pattern.compile("-(.)").matcher(identifier.replaceAll(" ", "_").replaceAll("\\p{Cc}", "CTRL"))
                .replaceAll(mr -> mr.group(1).toUpperCase()).chars()
                .filter(c -> Character.isLetter(c) || c == '_')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining()).replaceAll("[α-ω]", "");
    }
}
