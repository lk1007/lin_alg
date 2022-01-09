import java.util.Arrays;
import java.util.Random;

import java.util.Arrays.*;

public class Matrix {
    private double[][] matrix;
    private int[][] pivCol;
    private int numCol;
    private int numRow;

    /**
     * This is a constructor for a matrix with parameeters row and col giving the
     * number of rows and collumns in the matrix The constructor constructs a 2D
     * array from the two parameters and fills the values of the array with random
     * numbers n 0 <= n <= 10
     * 
     * @param col
     * @param row
     */
    public Matrix(int row, int col) {
        matrix = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = (int) (10 * Math.random());
            }
        }
        numCol = matrix[0].length;
        numRow = matrix.length;
    }

    /**
     * takes the r1th row and the r2th row of the matrix and returns an array
     * containing the sum of the elements of each row
     * 
     * @param r1
     * @param r2
     * @return
     */
    public double[] add(int r1, int r2) {
        double[] row1 = matrix[r1];
        double[] row2 = matrix[r2];
        double[] sum = new double[row1.length];
        for (int i = 0; i < row1.length; i++)
            sum[i] = row1[i] + row2[i];
        return sum;
    }

    /** add two arrays from any matrix and return the sum array */
    public double[] addArr(double[] a1, double[] a2) {
        double[] sum = new double[a1.length];
        for (int i = 0; i < a1.length; i++)
            sum[i] = a1[i] + a2[i];
        return sum;
    }

    /**
     * finds the first nonzero place in the matrix starting from either the top left
     * or bottom right at the start collumn
     */
    public int firstNonZeroPlace(boolean left, int startCol) {
        if (left) {
            for (int i = startCol; i < numCol; i++) {
                for (int j = 0; j < numRow; j++)
                    if (matrix[i][j] != 0)
                        return i;
            }
            return numRow;
        } else {
            for (int i = numCol - 1 - startCol; i >= 0; i--) {
                for (int j = numRow - 1; j >= 0; j--)
                    if (matrix[j][i] != 0)
                        return j;
            }
            return 0;
        }
    }

    public void transpose() {
        if (numRow == numCol) {
            for (int i = 0; i < numCol; i++) {
                for (int j = 0; j < numRow; j++) {
                    double temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    /**
     * takes the rth row of the matrix and returns an array containing the rth row
     * multiplied by the constant c
     * 
     * @param r
     * @param c
     * @return
     */
    public double[] mult(int r, double c) {
        double[] row = matrix[r].clone();
        double[] prod = new double[row.length];
        for (int i = 0; i < row.length; i++)
            prod[i] = row[i] * c;
        return prod;
    }

    /** swaps the r1th row and r2th row of the matrix  */
    public void swap(int r1, int r2) {
        double[] temp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = temp;
    }

    /**
     * row reduces the matrix to echelon form
     */
    public void echForm() {
        for (int i = 0; i < numCol; i++) {
            if (matrix[i][i] == 0)
                for (int j = i + 1; j < matrix.length; j++) {
                    if (matrix[j][i] != 0)
                        swap(j, i);
                }

            for (int j = i + 1; j < numRow; j++) {
                double element = matrix[j][i];
                if (element != 0)
                    matrix[j] = addArr(matrix[j], mult(i, -1 * element / matrix[i][i]));
            }
        }
    }

    /** row reduces the matrix from echelon for to RREF */
    public void RREF() {
        for (int i = numCol - 1; i > 0; i--) {
            int pivRow = firstNonZeroPlace(false, i);
            for (int j = pivRow - 1; j >= 0; j--) {
                double element = matrix[j][i];
                if (element != 0)
                    matrix[j] = addArr(matrix[j], mult(pivRow, -1 * element / matrix[pivRow][i]));

            }
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < matrix.length; i++)
            str = str + Arrays.toString(matrix[i]) + "\n";
        return str;
    }
}
