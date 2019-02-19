import java.util.*;

class ProteinTranslator {
  private static final HashMap<String, String> values = new HashMap<String, String>();

  static {
    values.put("AUG", "Methionine");
    values.put("UUU", "Phenylalanine");
    values.put("UUC", "Phenylalanine");
    values.put("UUA", "Leucine");
    values.put("UUG", "Leucine");
    values.put("UCU", "Serine");
    values.put("UCC", "Serine");
    values.put("UCA", "Serine");
    values.put("UCG", "Serine");
    values.put("UAU", "Tyrosine");
    values.put("UAC", "Tyrosine");
    values.put("UGU", "Cysteine");
    values.put("UGC", "Cysteine");
    values.put("UGG", "Tryptophan");
    values.put("UAA", "STOP");
    values.put("UAG", "STOP");
    values.put("UGA", "STOP");
  }

  private String protein;

  public List<String> translate(String rnaSequence) {
    List<String> proteins = new ArrayList<>();
    for (int i = 0; i < rnaSequence.length(); i = i + 3) {
      protein = values.get(rnaSequence.substring(i, i + 3));
      if (!"STOP".equals(protein)) {
        proteins.add(protein);
      } else {
        break;
      }
    }
    return proteins;
  }
}
