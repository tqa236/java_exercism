import java.util.ArrayList;
import java.util.List;

public class Transpose {
    public String transpose(String toTranspose) {
        if (toTranspose.isEmpty()) {
            return "";
        }

        String[] lines = toTranspose.split("\n");

        for (int i = lines.length - 2; i >= 0; i--) {
            if (lines[i].length() < lines[i + 1].length()) {
                lines[i] = String.format("%-" + lines[i + 1].length() + "s", lines[i]);
            }
        }

        int maxLength = 0;
        for (String line : lines) {
            maxLength = Math.max(maxLength, line.length());
        }

        List<StringBuilder> transposed = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            transposed.add(new StringBuilder());
        }

        for (int i = 0; i < maxLength; i++) {
            for (String line : lines) {
                if (i < line.length()) {
                    transposed.get(i).append(line.charAt(i));
                }
            }
        }

        return String.join("\n", transposed.stream().map(StringBuilder::toString).toArray(String[]::new));
    }
}
