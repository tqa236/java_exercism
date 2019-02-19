class RaindropConverter {

  public String convert(int number) {
    String s = "";
    if (number % 3 == 0) {
      s = s + "Pling";
    }
    if (number % 5 == 0) {
      s = s + "Plang";
    }
    if (number % 7 == 0) {
      s = s + "Plong";
    }
    if ("".equals(s)) {
      return String.valueOf(number);
    }
    return s;
  }
}
