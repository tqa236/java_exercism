import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Series {
  private String inputNumber;

  Series(String inputNumber) {
    this.inputNumber = inputNumber;
  }

  public List<String> slices(int numberOfDigits) {
    if (numberOfDigits < 1) {
      throw new IllegalArgumentException("Slice size is too small.");
    }
    if (numberOfDigits > inputNumber.length()) {
      throw new IllegalArgumentException("Slice size is too big.");
    }
    return IntStream.rangeClosed(0, inputNumber.length() - numberOfDigits)
        .mapToObj(n -> inputNumber.substring(n, n + numberOfDigits))
        .collect(Collectors.toList());
  }
}
