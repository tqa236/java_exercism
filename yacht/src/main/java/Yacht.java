import java.util.Arrays;

class Yacht {
  private int score;

  Yacht(int[] dice, YachtCategory yachtCategory) {
    // IntStream dices = Arrays.stream(dice);
    int value = yachtCategory.getValue();
    long distinctValue = Arrays.stream(dice).distinct().count();
    int sumDice = Arrays.stream(dice).sum();
    switch (yachtCategory) {
      case YACHT:
        if (distinctValue == 1) {
          score = value;
        }
        break;
      case ONES:
      case TWOS:
      case THREES:
      case FOURS:
      case FIVES:
      case SIXES:
        score = value * (int) Arrays.stream(dice).filter(num -> num == value).count();
        break;
      case FULL_HOUSE:
        if (distinctValue == 2) {
          long count = Arrays.stream(dice).filter(num -> num == dice[0]).count();
          if (count == 2 || count == 3) {
            score = sumDice;
          }
        }
        break;
      case FOUR_OF_A_KIND:
        if (distinctValue <= 2) {
          switch (Math.toIntExact(Arrays.stream(dice).filter(num -> num == dice[0]).count())) {
            case 1:
              score = sumDice - dice[0];
              break;
            case 4:
            case 5:
              score = dice[0] * 4;
              break;
            default:
              score = 0;
          }
        }
        break;
      case LITTLE_STRAIGHT:
      case BIG_STRAIGHT:
        if (distinctValue == 5 && sumDice == value) {
          score = 30;
        }
        break;
      case CHOICE:
        score = sumDice;
        break;
      default:
        throw new IllegalArgumentException("Unknow category");
    }
  }

  public int score() {
    return score;
  }
}
