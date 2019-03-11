import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {

  private int limit;

  Sieve(int maxPrime) {
    limit = maxPrime;
  }

  public List<Integer> getPrimes() {
    List<Integer> primes = new ArrayList<Integer>();
    List<Integer> range = IntStream.rangeClosed(2, limit).boxed().collect(Collectors.toList());
    while (!range.isEmpty()) {
      Integer prime = range.get(0);
      primes.add(prime);
      range = range.stream().filter(p -> p % prime != 0).collect(Collectors.toList());
    }

    return primes;
  }
}
