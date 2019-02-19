import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

  public int computeSquareOfSumTo(int input) {
    return (int) Math.pow(IntStream.rangeClosed(1, input).sum(), 2);
  }

  public int computeSumOfSquaresTo(int input) {
    return IntStream.rangeClosed(1, input).map(n -> n * n).sum();
  }

  public int computeDifferenceOfSquares(int input) {
    return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
  }
}
