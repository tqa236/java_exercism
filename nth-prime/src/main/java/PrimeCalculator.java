
class PrimeCalculator {

  int nth(int nth) {
    double upperBound = 10 + nth * (Math.log(nth) + Math.log(Math.log(nth)));
    return nth + 1;
  }
}
