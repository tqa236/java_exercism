// import java.util.Arrays;

class PascalsTriangleGenerator {
  public int[][] generateTriangle(int size) {
    int[][] pascalsTriangle = new int[size][];

    for (int i = 0; i < size; i++) {
      int[] newLine = new int[i + 1];
      for (int j = 0; j < i + 1; j++) {
        if ((j == 0) || (j == i)) {
          newLine[j] = 1;
        } else {
          newLine[j] = pascalsTriangle[i - 1][j - 1] + pascalsTriangle[i - 1][j];
        }
      }
      pascalsTriangle[i] = newLine;
    }
    // System.out.println(Arrays.deepToString(pascalsTriangle));
    return pascalsTriangle;
  }
}
