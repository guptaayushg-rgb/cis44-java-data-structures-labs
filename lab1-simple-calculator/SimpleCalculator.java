import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentValue = 0;
        double nextValue = 0;
        String operator = "";
        boolean running = true;

        System.out.println("Simple Calculator (type 'exit' to quit)");

        while (running) {
            System.out.print("Input: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                running = false;
            } else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                operator = input;
            } else if (input.equals("=")) {
                System.out.println("Screen: " + currentValue);
            } else {
                double value = Double.parseDouble(input);
                if (operator.isEmpty()) {
                    currentValue = value;
                } else {
                    nextValue = value;
                    switch (operator) {
                        case "+": currentValue += nextValue; break;
                        case "-": currentValue -= nextValue; break;
                        case "*": currentValue *= nextValue; break;
                        case "/": currentValue /= nextValue; break;
                    }
                    operator = "";
                }
                System.out.println("Screen: " + currentValue);
            }
        }
        scanner.close();
    }
}
