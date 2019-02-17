class Darts {
  private double x;
  private double y;

  Darts(double x, double y) {
    this.x = x;
    this.y = y;
  }

  int score() {
    if (x * x + y * y <= 1) return 10;
    if (x * x + y * y <= 25) return 5;
    if (x * x + y * y <= 100) return 1;
    return 0;
  }
}
