class Acronym {

  private String phrase;

  Acronym(String phrase) {
    this.phrase = phrase;
  }

  public String getAcronym() {
    String acronym = "";
    Boolean isAcronym = true;
    for (char c : phrase.toCharArray()) {
      if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) {
        if (isAcronym) {
          acronym = acronym + Character.toUpperCase(c);
          isAcronym = false;
        }
      } else if (c != '\'') {
        isAcronym = true;
      }
    }
    return acronym;
  }
}
