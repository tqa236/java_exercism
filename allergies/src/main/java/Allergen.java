enum Allergen {
  EGGS(0),
  PEANUTS(1),
  SHELLFISH(2),
  STRAWBERRIES(3),
  TOMATOES(4),
  CHOCOLATE(5),
  POLLEN(6),
  CATS(7);

  private final int score;

  Allergen(int score) {
    this.score = score;
  }

  int getScore() {
    return score;
  }
}
