import java.security.SecureRandom;
import java.util.stream.Collectors;

public class Cipher {
    private final String key;
    private static final int ALPHABET_SIZE = 26;
    private static final SecureRandom RANDOM = new SecureRandom();
    
    // Default constructor - generates random key
    public Cipher() {
        this.key = generateRandomKey();
    }
    
    // Constructor with specific key
    public Cipher(String key) {
        if (key == null || key.isEmpty() || !key.matches("^[a-z]+$")) {
            throw new IllegalArgumentException("Key must contain only lowercase letters");
        }
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
    
    public String encode(String plainText) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            int shift = key.charAt(i % key.length()) - 'a';
            char encodedChar = shiftChar(plainChar, shift);
            result.append(encodedChar);
        }
        
        return result.toString();
    }
    
    public String decode(String cipherText) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < cipherText.length(); i++) {
            char cipherChar = cipherText.charAt(i);
            int shift = key.charAt(i % key.length()) - 'a';
            char decodedChar = shiftChar(cipherChar, -shift);
            result.append(decodedChar);
        }
        
        return result.toString();
    }
    
    private char shiftChar(char c, int shift) {
        // Convert to 0-based position in alphabet (a=0, b=1, etc)
        int position = c - 'a';
        
        // Apply shift and handle wrapping
        int newPosition = (position + shift + ALPHABET_SIZE) % ALPHABET_SIZE;
        
        // Convert back to character
        return (char) (newPosition + 'a');
    }
    
    private String generateRandomKey() {
        // Generate a random key of 100 lowercase letters
        return RANDOM.ints(100, 0, ALPHABET_SIZE)
                    .mapToObj(i -> String.valueOf((char)('a' + i)))
                    .collect(Collectors.joining());
    }
}