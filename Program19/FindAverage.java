import java.util.Scanner;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class FindAverage {
    public static double calculateAverage(int n, Scanner sc) throws NegativeNumberException {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number: ");
            double num = sc.nextDouble();

            if (num < 0) {
                throw new NegativeNumberException("Negative numbers are not allowed!");
            }
            sum += num;
        }
        return sum /n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter how many numbers: ");
            int n = sc.nextInt();
            double avg = calculateAverage(n, sc);
            System.out.println("Average = " + avg);

        } catch (NegativeNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
}
