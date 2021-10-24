import java.util.Arrays;
import java.util.Random;

import java.util.Arrays.*;

public class Matrix {
    private double[][] matrix;
    private int[][] pivCol;
    /**
     * This is a constructor for a matrix with parameeters row and col giving the number of rows and collumns in the matrix
     * The constructor constructs a 2D array from the two parameters and fills the values of the array with random numbers n 0 <= n <= 10
     * @param col
     * @param row
     */
    public Matrix(int row, int col)
    {
        matrix = new double[row][col];
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                matrix[i][j] = (int)(10*Math.random());
            }
        }

    }

    /**
     * takes the r1th row and the r2th row of the matrix and returns an array containing the sum of the elements of each row
     * @param r1
     * @param r2
     * @return
     */
    public double[] add(int r1, int r2)
    {
        double[] row1 = matrix[r1];
        double[] row2 = matrix[r2];
        double[] sum = new double[row1.length];
        for(int i = 0; i < row1.length;i++)
            sum[i] = row1[i] + row2[i];
        return sum;
    }
    public double[] addArr(double[] a1, double[] a2)
    {
        double[] sum = new double[a1.length];
        for(int i = 0; i < a1.length;i++)
            sum[i] = a1[i] + a2[i];
        return sum;
    }
    /**
     * takes the rth row of the matrix and returns an array containing the rth row multiplied by the constant c
     * @param r
     * @param c
     * @return
     */
    public double[] mult(int r, double c)
    {
        double[] row = matrix[r].clone();
        double[] prod = new double[row.length];
        for(int i = 0; i < row.length;i++)
            prod[i] = row[i] * c;
        return prod;
    }
    public void swap(int r1, int r2){
        double[] temp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = temp;
    }

    /**
     * row reduces the matrix to echelon form
     */
    public void echForm()
    {
        for(int j = 0; j < matrix[0].length; j++)
        {
            if(matrix[j][j] == 0)
                for(int i = j+1 ; i < matrix.length;i++)
                {
                    if(matrix[i][j] != 0)
                        swap(i,j);
                }


            for(int i = j+1; i < matrix.length; i++)
            {
                double element = matrix[i][j];
                if(element != 0)
                    matrix[i] = addArr(matrix[i],mult(j,-1*element/matrix[j][j]));
            }
        }
    }
    public void RREF()
    {
       //TODO Complete RREF
    }
    public String toString()
    {
        String str = "";
        for(int i = 0; i < matrix.length; i++)
             str = str + Arrays.toString(matrix[i]) + "\n";
        return str;
    }
}
