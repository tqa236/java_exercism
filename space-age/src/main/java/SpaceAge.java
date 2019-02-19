class SpaceAge {
  private double seconds;

  SpaceAge(double seconds) {
    this.seconds = seconds;
  }

  public double getSeconds() {
    return this.seconds;
  }

  public double onEarth() {
    return this.seconds / 31557600;
  }

  public double onMercury() {
    return this.seconds / (31557600 * 0.2408467);
  }

  public double onVenus() {
    return this.seconds / (31557600 * 0.61519726);
  }

  public double onMars() {
    return this.seconds / (31557600 * 1.8808158);
  }

  public double onJupiter() {
    return this.seconds / (31557600 * 11.862615);
  }

  public double onSaturn() {
    return this.seconds / (31557600 * 29.447498);
  }

  public double onUranus() {
    return this.seconds / (31557600 * 84.016846);
  }

  public double onNeptune() {
    return this.seconds / (31557600 * 164.79132);
  }
}
