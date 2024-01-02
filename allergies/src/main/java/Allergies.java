import java.util.*;

class Allergies {
  private int score;

  Allergies(int score) {
    this.score = score % 256 + 256;
  }

  public boolean isAllergicTo(Allergen allergen) {

    return Integer.toBinaryString(score).charAt(8 - allergen.getScore()) == '1';
  }

  public List<Allergen> getList() {
    List<Allergen> allergens = new ArrayList<Allergen>();
    for (Allergen allergen : Allergen.values()) {
      if (isAllergicTo(allergen)) allergens.add(allergen);
    }
    return allergens;
  }
}
