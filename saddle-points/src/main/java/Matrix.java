import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

class Matrix {

    private List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        
        for (int i = 0; i < values.size(); i++) {
            List<Integer> row = values.get(i);
            int maxInRow = Collections.max(row);
            
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == maxInRow) {
                    boolean isMinInCol = true;
                    for (int k = 0; k < values.size(); k++) {
                        if (values.get(k).get(j) < row.get(j)) {
                            isMinInCol = false;
                            break;
                        }
                    }
                    if (isMinInCol) {
                        saddlePoints.add(new MatrixCoordinate(i + 1, j + 1));
                    }
                }
            }
        }

        return saddlePoints;
    }
}