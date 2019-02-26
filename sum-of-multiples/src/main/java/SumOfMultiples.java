import java.util.Arrays;
import java.util.stream.IntStream;

class SumOfMultiples {

  private int number;
  private int[] factors;

  SumOfMultiples(int number, int[] set) {
    this.number = number;
    factors = set;
  }

  public int getSum() {
    return IntStream.rangeClosed(1, number - 1)
        .filter(n -> Arrays.stream(factors).filter(i -> i != 0).anyMatch(i -> n % i == 0))
        .sum();
  }
}
