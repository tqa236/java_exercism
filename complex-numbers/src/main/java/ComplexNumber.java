class ComplexNumber {
  private double real;
  private double imaginary;

  public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  public double getReal() {
    return real;
  }

  public double getImag() {
    return imaginary;
  }

  public ComplexNumber add(ComplexNumber other) {
    return new ComplexNumber(real + other.real, imaginary + other.imaginary);
  }

  public ComplexNumber minus(ComplexNumber other) {
    return new ComplexNumber(real - other.real, imaginary - other.imaginary);
  }

  public ComplexNumber times(ComplexNumber other) {
    return new ComplexNumber(
        real * other.real - imaginary * other.imaginary,
        imaginary * other.real + real * other.imaginary);
  }

  public ComplexNumber div(ComplexNumber other) {
    double denominator = Math.pow(other.abs(), 2);
    return new ComplexNumber(
        (real * other.real + imaginary * other.imaginary) / denominator,
        (imaginary * other.real - real * other.imaginary) / denominator);
  }

  public double abs() {
    return Math.sqrt(real * real + imaginary * imaginary);
  }

  public ComplexNumber conjugate() {
    return new ComplexNumber(real, -imaginary);
  }

  public ComplexNumber exponentialOf() {
    return new ComplexNumber(
        Math.pow(Math.E, real) * Math.cos(imaginary), Math.pow(Math.E, real) * Math.sin(imaginary));
  }
}
