package exercises.chapter01;

public class Ex07Rotate90 {

  private static void rotate90(int[][] matrix) {
    int N = matrix.length;
    if (N == 0 || N != matrix[0].length) {
      return;
    }    
    for (int i = 0; i < N-1; i++) {
      for (int j = i+1; j < N; j++) {
        swap(matrix, i, j);
      }
    }
  }

  private static void swap(int[][] matrix, int r, int c) {
    int tmp = matrix[r][c];
    matrix[r][c] = matrix[c][r];
    matrix[c][r] = tmp;
  }

  private static void dump(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j]);
        if (j < matrix.length-1) {
          System.out.print(", ");
        }
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1,2,3,10}, {4,5,6,11}, {7,8,9,20}, {9,9,9,9}};
    System.out.println("Before: ");
    dump(matrix);
    rotate90(matrix);
    System.out.println("After: ");
    dump(matrix);
  }

}