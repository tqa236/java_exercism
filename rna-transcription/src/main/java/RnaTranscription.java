import java.util.*;

class RnaTranscription {
    private static final HashMap<String, String> values =
                                    new HashMap<String, String>(){{
        put("G", "C");put("C", "G");put("T", "A");put("A", "U");
    }};
    private String rna = "";
    String transcribe(String dnaStrand) {
        for (char ch: dnaStrand.toCharArray()) {
            rna = rna + values.get("" + ch);
        }
        return rna;
    }

}
