class Twofer {
  private static final String message = "One for %s, one for me.";

  public String twofer(String name) {
    return String.format(message, name == null ? "you" : name);
  }
}
