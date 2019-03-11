import java.util.Arrays;

class Triangle {
  private double[] sides;

  Triangle(double side1, double side2, double side3) throws TriangleException {
    sides = new double[] {side1, side2, side3};
    if (!isTriangle()) {
      throw new TriangleException();
    }
  }

  public boolean isEquilateral() {
    return sides[0] == sides[1] && sides[0] == sides[2];
  }

  public boolean isIsosceles() {
    return sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2];
  }

  public boolean isScalene() {
    return !isIsosceles();
  }

  private boolean isTriangle() {
    return Arrays.stream(sides).min().getAsDouble() > 0
        && sides[0] + sides[1] + sides[2] > 2 * Arrays.stream(sides).max().getAsDouble();
  }
}
