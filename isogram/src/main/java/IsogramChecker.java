class IsogramChecker {

  public boolean isIsogram(String phrase) {
    String letters = phrase.replaceAll("[^a-zA-Z]", "").toLowerCase();
    return letters.chars().distinct().count() == letters.length() ? true : false;
  }
}
