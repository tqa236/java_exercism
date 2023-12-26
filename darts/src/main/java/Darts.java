class Darts {

  Darts() {
  }

  public int score(double x, double y) {
    if (x * x + y * y <= 1) return 10;
    if (x * x + y * y <= 25) return 5;
    if (x * x + y * y <= 100) return 1;
    return 0;
  }
}
