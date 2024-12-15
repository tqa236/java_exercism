import java.util.*;

class ProteinTranslator {
    private static final HashMap<String, String> values = new HashMap<String, String>() {{
        put("AUG", "Methionine");
        put("UUU", "Phenylalanine");
        put("UUC", "Phenylalanine");
        put("UUA", "Leucine");
        put("UUG", "Leucine");
        put("UCU", "Serine");
        put("UCC", "Serine");
        put("UCA", "Serine");
        put("UCG", "Serine");
        put("UAU", "Tyrosine");
        put("UAC", "Tyrosine");
        put("UGU", "Cysteine");
        put("UGC", "Cysteine");
        put("UGG", "Tryptophan");
        put("UAA", "STOP");
        put("UAG", "STOP");
        put("UGA", "STOP");
    }};
    
    List<String> translate(String rnaSequence) {
        List<String> proteins = new ArrayList<>();
        
        for (int i = 0; i < rnaSequence.length(); i = i + 3) {
            if (i + 3 <= rnaSequence.length()) {
                String codon = rnaSequence.substring(i, i + 3);
                String protein = values.get(codon);

                if (protein == null) {
                    throw new IllegalArgumentException("Invalid codon");
                }

                if (protein.equals("STOP")) {
                    break;
                }

                proteins.add(protein);
            } else {
                throw new IllegalArgumentException("Invalid codon");
            }
        }

        return proteins;
    }
}
