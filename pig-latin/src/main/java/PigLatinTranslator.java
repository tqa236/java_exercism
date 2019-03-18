import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {
  public String translate(String word) {
    return Stream.of(word.split("\\s+"))
        .map(w -> translateOneWord(w))
        .collect(Collectors.joining(" "));
  }

  public String translateOneWord(String word) {
    Pattern specialVowel = Pattern.compile("^(yt|xr)(.*)");
    Pattern consonant = Pattern.compile("^(qu|y|[^aeiouy]qu|[^aeiouy]+)(.*)");

    Matcher matchSpecialVowel = specialVowel.matcher(word);
    Matcher matchConsonant = consonant.matcher(word);

    if (matchConsonant.find() && !matchSpecialVowel.find()) {
      return matchConsonant.group(2) + matchConsonant.group(1) + "ay";
    }
    return word + "ay";
  }
}
