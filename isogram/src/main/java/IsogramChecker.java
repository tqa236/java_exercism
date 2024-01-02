class IsogramChecker {

  boolean isIsogram(String phrase) {
    phrase = phrase.replaceAll("[^a-zA-Z]", "").toLowerCase();
    return phrase.chars().distinct().count() == phrase.length() ? true : false;
  }
}
