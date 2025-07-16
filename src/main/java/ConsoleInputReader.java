import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    private final Scanner scanner;

    public ConsoleInputReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int readInt() {
        int input;

        System.out.println("Enter the size of the grid (e.g. 4 for a 4x4 grid): ");
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();

                if (Validator.isValid(input)) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + Validator.MIN_SIZE + " and " + Validator.MAX_SIZE + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
        return input;
    }

    @Override
    public int readInt(int sizeOfGrid) {
        int input;
        System.out.println("Enter the number of mines to place on the grid (maximum is 35% of the total squares): ");

        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();

                if (Validator.isLessThan35percent(input, sizeOfGrid)) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and less than 35% of the total grid size");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
        return input;
    }

    @Override
    public Boolean readResponse() {
        String input=scanner.next().trim();

        return !input.equalsIgnoreCase("q");
    }

    @Override
    public String readLine(int sizeOfGrid) {
        String input;
        System.out.println("Select a square to reveal (e.g. A1): ");

        while (true) {
            if (scanner.hasNext()) {
                input = scanner.next().toUpperCase();

                if (Validator.isValidInput(input, sizeOfGrid)) {
                    break;
                } else {
                    System.out.println("Invalid input. Enter a value within the limits of the grid");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid.");
                scanner.next();
            }
        }
        return input;
    }

    public void close() {
        scanner.close();
    }

}
