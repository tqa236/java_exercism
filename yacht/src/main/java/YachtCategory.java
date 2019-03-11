enum YachtCategory {
  YACHT(50),
  ONES(1),
  TWOS(2),
  THREES(3),
  FOURS(4),
  FIVES(5),
  SIXES(6),
  FULL_HOUSE(7),
  FOUR_OF_A_KIND(8),
  LITTLE_STRAIGHT(15),
  BIG_STRAIGHT(20),
  CHOICE(11);

  private int value;

  YachtCategory(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
