import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class IsbnVerifier {

  public boolean isValid(String stringToVerify) {
    if (stringToVerify.length() == 0) return false;
    String number = stringToVerify.replaceAll("\\D+", "");
    List<Integer> digits =
        Arrays.stream(number.split("")).map(d -> Integer.valueOf(d)).collect(Collectors.toList());
    if (stringToVerify.charAt(stringToVerify.length() - 1) == 'X') digits.add(10);
    if (digits.size() != 10) return false;
    return IntStream.range(0, 10).map(i -> (10 - i) * digits.get(i)).sum() % 11 == 0;
  }
}
