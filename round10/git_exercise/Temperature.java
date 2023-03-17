import java.util.Scanner;

public class Temperature {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Input temperature: ");
            double inputTemp = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.2f C = %.2f F\n", inputTemp, tTransform(inputTemp, 'c'));
        } catch (NumberFormatException e) {
            System.out.println("Not valid input");
            System.exit(1);
        }
    }

    public static double tTransform(double temp, char type) {
        if (type == 'c') {
            return temp * 9/15 + 32;
        }
        return Double.NaN;
    }
}