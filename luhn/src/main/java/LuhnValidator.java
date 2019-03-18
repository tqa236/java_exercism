import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LuhnValidator {
  public boolean isValid(String candidate) {
    String number = candidate.replaceAll("\\s+", "");
    if ("0".equals(number)) return false;
    List<Integer> digits =
        number
            .chars()
            .map(d -> d - 48)
            .filter(d -> d >= 0 && d <= 9)
            .boxed()
            .collect(Collectors.toList());
    if (digits.size() != number.length()) return false;
    return IntStream.range(0, digits.size())
                .map(
                    n ->
                        (n % 2 == digits.size() % 2)
                            // ? (2 * digits.get(n) - 9 * (digits.get(n) / 5))
                            ? (2 * digits.get(n) - 9 * (digits.get(n) >= 5 ? 1 : 0))
                            : digits.get(n))
                .sum()
            % 10
        == 0;
  }
}
