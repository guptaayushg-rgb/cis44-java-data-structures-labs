public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2, 3);
        Matrix m2 = new Matrix(2, 3);
        m1.populateRandom();
        m2.populateRandom();

        System.out.println("Matrix 1:");
        System.out.println(m1);
        System.out.println("Matrix 2:");
        System.out.println(m2);

        try {
            Matrix sum = m1.add(m2);
            System.out.println("Sum of matrices:");
            System.out.println(sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Addition error: " + e.getMessage());
        }

        Matrix m3 = new Matrix(3, 2);
        m3.populateRandom();
        System.out.println("Matrix 3:");
        System.out.println(m3);

        try {
            Matrix product = m1.multiply(m3);
            System.out.println("Product of Matrix 1 and Matrix 3:");
            System.out.println(product);
        } catch (IllegalArgumentException e) {
            System.out.println("Multiplication error: " + e.getMessage());
        }

        try {
            Matrix wrong = m1.add(m3);
        } catch (IllegalArgumentException e) {
            System.out.println("Addition error with incompatible matrices: " + e.getMessage());
        }
    }
}
