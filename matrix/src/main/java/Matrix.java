import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Matrix {

  private List<List<Integer>> rows;

  Matrix(String matrixAsString) {
    String[] lines = matrixAsString.split("\n");
    rows =
        Arrays.stream(lines)
            .map(
                line ->
                    Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
            .collect(Collectors.toList());
  }

  public int[] getRow(int rowNumber) {
    return rows.get(rowNumber - 1).stream().mapToInt(i -> i).toArray();
  }

  public int[] getColumn(int columnNumber) {
    return rows.stream().map(row -> row.get(columnNumber - 1)).mapToInt(i -> i).toArray();
  }
}
