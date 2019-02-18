import java.util.Random;
import java.util.stream.IntStream;

class DnDCharacter {
  private int strength = ability();
  private int dexterity = ability();
  private int constitution = ability();
  private int intelligence = ability();
  private int wisdom = ability();
  private int charisma = ability();
  private int hitpoints = 10 + modifier(constitution);

  public int ability() {
    Random rand = new Random();
    int[] random_ability = new int[4];
    for (int i = 0; i < 4; i = i + 1) {
      random_ability[i] = 1 + rand.nextInt(6);
    }
    return IntStream.of(random_ability).sum() - IntStream.of(random_ability).min().orElse(0);
  }

  public int modifier(int input) {
    return (int) Math.floor((input - 10) / 2.0);
  }

  public int getStrength() {
    return strength;
  }

  public int getDexterity() {
    return dexterity;
  }

  public int getConstitution() {
    return constitution;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public int getWisdom() {
    return wisdom;
  }

  public int getCharisma() {
    return charisma;
  }

  public int getHitpoints() {
    return hitpoints;
  }
}
