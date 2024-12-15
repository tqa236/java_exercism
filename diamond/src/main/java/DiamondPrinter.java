import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> result = new ArrayList<>();
        int size = a - 'A' + 1;
        
        for (int i = 0; i < size; i++) {
            char currentChar = (char) ('A' + i);
            StringBuilder line = new StringBuilder();
            
            for (int j = 0; j < size - i - 1; j++) {
                line.append(" ");
            }
            
            line.append(currentChar);
            
            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    line.append(" ");
                }
                line.append(currentChar);
            }
            
            while (line.length() < 2 * size - 1) {
                line.append(" ");
            }

            result.add(line.toString());
        }

        for (int i = size - 2; i >= 0; i--) {
            result.add(result.get(i));
        }
        
        return result;
    }
}
