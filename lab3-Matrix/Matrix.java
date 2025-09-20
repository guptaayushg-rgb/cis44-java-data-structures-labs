import java.util.Random;

public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        int rows = data.length;
        int cols = data[0].length;
        this.data = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    public void populateRandom() {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = rand.nextInt(10) + 1;
            }
        }
    }

    public Matrix add(Matrix other) {
        if (data.length != other.data.length || data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to add.");
        }
        Matrix result = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (data[0].length != other.data.length) {
            throw new IllegalArgumentException("Number of columns of first matrix must equal number of rows of second.");
        }
        int rows = data.length;
        int cols = other.data[0].length;
        int common = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result.data[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int val : row) {
                sb.append(val).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
