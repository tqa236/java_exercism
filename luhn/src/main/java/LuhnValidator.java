import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LuhnValidator {

  public boolean isValid(String candidate) {
    String number = candidate.replaceAll("\\s+", "");
    System.out.println(number);
    if ("0".equals(number)) return false;
    List<Integer> digits = number.chars().map(d -> d - 48).boxed().collect(Collectors.toList());
    return IntStream.range(0, digits.size())
                .map(
                    n ->
                        (n % 2 == digits.size() % 2)
                            ? (2 * digits.get(n) - 9 * (digits.get(n) / 5))
                            : digits.get(n))
                .sum()
            % 10
        == 0;
  }
}
