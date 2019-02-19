class Twofer {
  private static final String message = "One for %s, one for me.";

  public String twofer(String name) {
    String final_name = name;
    if (final_name == null) {
      final_name = "you";
    }
    return String.format(message, final_name);
  }
}
