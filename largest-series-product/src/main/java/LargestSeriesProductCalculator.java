import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class LargestSeriesProductCalculator {
  private List<Integer> digits;

  LargestSeriesProductCalculator(String inputNumber) {
    digits =
        inputNumber
            .chars()
            .map(d -> d - 48)
            .filter(d -> d >= 0 && d <= 9)
            .boxed()
            .collect(Collectors.toList());
    if (digits.size() != inputNumber.length()) {
      throw new IllegalArgumentException("String to search may only contain digits.");
    }
  }

  long calculateLargestProductForSeriesLength(int numberOfDigits) {
    if (numberOfDigits < 0) {
      throw new IllegalArgumentException("Series length must be non-negative.");
    }
    if (numberOfDigits > digits.size()) {
      throw new IllegalArgumentException(
          "Series length must be less than or equal to the length of the string to search.");
    }
    if (numberOfDigits == 0) return 1;
    return LongStream.rangeClosed(0, digits.size() - numberOfDigits)
        .map(
            n ->
                digits
                    .subList((int) n, (int) n + numberOfDigits)
                    .stream()
                    .reduce(1, (a, b) -> a * b))
        .max()
        .getAsLong();
  }
}
