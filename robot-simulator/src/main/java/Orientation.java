enum Orientation {
  NORTH,
  EAST,
  SOUTH,
  WEST;

  private static Orientation[] vals = values();

  public Orientation next() {
    return vals[(this.ordinal() + 1) % vals.length];
  }

  public Orientation previous() {
    return vals[(this.ordinal() + vals.length - 1) % vals.length];
  }
}
