import java.util.*;

class RnaTranscription {
  private static final HashMap<String, String> values = new HashMap<String, String>();

  static {
    values.put("G", "C");
    values.put("C", "G");
    values.put("T", "A");
    values.put("A", "U");
  }

  private String rna = "";

  public String transcribe(String dnaStrand) {
    for (char ch : dnaStrand.toCharArray()) {
      rna = rna + values.get("" + ch);
    }
    return rna;
  }
}
