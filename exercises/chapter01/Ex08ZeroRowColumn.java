package exercises.chapter01;

public class Ex08ZeroRowColumn {

  private static void zeroCol(int[][] matrix, int col) {
    for (int i = 0; i < matrix.length; matrix[i++][col] = 0);
  }

  private static void zeroRow(int[][] matrix, int row) {
    for (int i = 0; i < matrix[0].length; matrix[row][i++] = 0);
  }

  private static int[][] zeroA(int[][] matrix) {
    if (matrix.length == 0) {
      return matrix;
    }
    int M = matrix.length;
    int N = matrix[0].length;
    int[][] out = new int[M][N];
    boolean[] zeroCol = new boolean[N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] != 0) {
          if (!zeroCol[j]) {
            out[i][j] = matrix[i][j];
          }
          continue;
        }
        zeroRow(out, i);
        if (!zeroCol[j]) {
          zeroCol(out, j);
          zeroCol[j] = true;
        }
        break;
      }
    }
    return out;
  }

  private static void zeroB(int[][] matrix) {
    if (matrix.length == 0) {
      return;
    }
    int M = matrix.length;
    int N = matrix[0].length;
    boolean[] zeroRow = new boolean[M];
    boolean[] zeroCol = new boolean[N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 0) {
          zeroRow[i] = true;
          zeroCol[j] = true;
        }
      }
    }
    // Zero rows
    for (int i = 0; i < M; i++) {
      if (zeroRow[i]) {
        zeroRow(matrix, i);
      }      
    }
    // Zero columns
    for (int j = 0; j < N; j++) {
      if (zeroCol[j]) {
        zeroCol(matrix, j);
      }
    }  
  }

  private static void dump(int[][] matrix) {
    if (matrix.length == 0) {
      return;
    }
    int M = matrix.length;
    int N = matrix[0].length;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(matrix[i][j]);
        if (j < N-1) {
          System.out.print(", ");
        }
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1,2,0,10}, {4,0,0,11}, {7,8,9,20}, {9,9,9,9}};
    System.out.println("Before: ");
    dump(matrix);
    int[][] out = zeroA(matrix);
    System.out.println("AfterA: ");
    dump(out);
    zeroB(matrix);
    System.out.println("AfterB: ");
    dump(matrix);
  }
  

}