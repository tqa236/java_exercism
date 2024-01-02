import java.util.*;

class NucleotideCounter {
  private String dnaStrand;
  private HashMap<Character, Integer> counts =
      new HashMap<Character, Integer>() {
        {
          put('A', 0);
          put('C', 0);
          put('G', 0);
          put('T', 0);
        }
      };

  public NucleotideCounter(String dnaStrand) {
    if (!dnaStrand.isEmpty() && !dnaStrand.matches("^([ACGT])+$"))
      throw new IllegalArgumentException();

    this.dnaStrand = dnaStrand;
  };

  Map<Character, Integer> nucleotideCounts() throws IllegalArgumentException {
    for (char ch : dnaStrand.toCharArray()) counts.put(ch, counts.get(ch) + 1);
    return counts;
  };
}
