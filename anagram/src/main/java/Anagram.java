import java.util.List;
import java.util.stream.Collectors;

class Anagram {
  private String word;
  private String sortedWord;

  public Anagram(String word) {
    this.word = word.toLowerCase();
    sortedWord = sortWord(word);
  }

  public List<String> match(List<String> candidates) {
    return candidates
        .stream()
        .filter(
            candidate ->
                sortedWord.equals(sortWord(candidate)) && !word.equals(candidate.toLowerCase()))
        .collect(Collectors.toList());
  }

  private String sortWord(String word) {
    return word.toLowerCase()
        .chars()
        .sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
