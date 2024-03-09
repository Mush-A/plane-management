import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {
    private int[][] seatsMatrix;
    private final Scanner scanner;
    private final Search<Integer> searchInteger;
    private final Search<String> searchString;
    private final String[] validRows = {"A", "B", "C", "D"};

    public PlaneManagement() {
        scanner = new Scanner(System.in);
        searchInteger = new Search<Integer>();
        searchString = new Search<String>();

        main();
    }

    private void main() {
        seatsMatrix = new int[4][];

        seatsMatrix[0] = new int[14];
        seatsMatrix[1] = new int[12];
        seatsMatrix[2] = new int[12];
        seatsMatrix[3] = new int[14];

        for (int[] array : seatsMatrix) {
            Arrays.fill(array, 0);
        }

        System.out.println("Welcome to the Plane Management application");

        init();
    }

    private void init() {
        int input;

        do {
            input = getMenuInput();
            methodCaller(input);
        } while (input != 0);

        System.out.println("Program quit.");
    }

    private int getMenuInput() {
        Integer[] validInputs = {1, 2, 3, 4, 5, 6, 0};
        String[] inputLabels = {
                "Buy a seat",
                "Cancel a seat",
                "Find first available seat",
                "Show seating plan",
                "Print tickets information and total sales",
                "Search ticket",
                "Quit"
        };

        return getValidInput(validInputs, inputLabels);
    }

    private int getValidInput(Integer[] validInputs, String[] inputLabels) {
        int input = -1;
        boolean isValidInput = false;

        do {
            printOptions(validInputs, inputLabels);
            try {
                input = scanner.nextInt();

                if (input == 0) break;

                if (searchInteger.linearSearch(validInputs, input) == -1) {
                    System.out.println("\nInvalid input. Try again:\n");
                    continue;
                }

                isValidInput = true;
            } catch (Exception exception) {
                System.out.println("Something went wrong...");
                scanner.nextLine();
            }
        } while (!isValidInput);

        return input;
    }

    private void methodCaller(int input) {
        switch (input) {
            case 1:
                buySeat();
                break;
            case 2:
                cancelSeat();
                break;
            case 3:
                findFirstAvailable();
                break;
            case 4:
                showSeatingPlan();
                break;
            default:
                System.out.println("That is not a valid option sire!");
        }
    }

    private void buySeat() {
        String rowInput = getValidRowInput();
        int rowIndex = getRowIndex(rowInput);

        int seatNumberInput = getValidSeatNumberInput(rowInput);
        int seatIndex = seatNumberInput - 1;

        seatsMatrix[rowIndex][seatIndex] = 1;
    }

    private void cancelSeat() {
        String rowInput = getValidRowInput();
        int rowIndex = getRowIndex(rowInput);

        int seatNumberInput = getValidSeatNumberInput(rowInput);
        int seatIndex = seatNumberInput - 1;

        seatsMatrix[rowIndex][seatIndex] = 0;
    }

    private void findFirstAvailable() {
        for (int rowIndex = 0; rowIndex < seatsMatrix.length; rowIndex++) {
            for (int seatIndex = 0; seatIndex < seatsMatrix[rowIndex].length; seatIndex++) {
                if (seatsMatrix[rowIndex][seatIndex] == 0) {
                    System.out.println("First available seat at " + validRows[rowIndex] + (seatIndex + 1));
                }
            }
        }
    }

    private void showSeatingPlan() {
        System.out.println();
        for (int rowIndex = 0; rowIndex < seatsMatrix.length; rowIndex++) {
            for (int seatIndex = 0; seatIndex < seatsMatrix[rowIndex].length; seatIndex++) {
                if (seatsMatrix[rowIndex][seatIndex] == 0) {
                    System.out.print("O");
                }
                else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private String getValidRowInput() {
        String rowInput = "";
        boolean isValidInput = false;

        do {
            System.out.print("Enter row: ");
            rowInput = scanner.next();

            if (searchString.linearSearch(validRows, rowInput) == -1) {
                System.out.println("\nInvalid row. Try again:\n");
                continue;
            }

            isValidInput = true;
        } while (!isValidInput);

        return rowInput;
    }

    private int getRowIndex(String rowChar) {
        return searchString.linearSearch(validRows, rowChar);
    }

    private int getValidSeatNumberInput(String rowInput) {
        int seatNumberInput = -1;
        boolean isValidInput = false;

        do {
            System.out.print("Enter seat number for row " + rowInput + ": ");
            try {
                seatNumberInput = scanner.nextInt();

                int rowIndex = getRowIndex(rowInput);
                int maxSeats = seatsMatrix[rowIndex].length;
                if (seatNumberInput < 1 || seatNumberInput > maxSeats) {
                    System.out.println("\nInvalid seat number. Try again.\n");
                    continue;
                }

                if (seatsMatrix[rowIndex][seatNumberInput - 1] == 1) {
                    System.out.println("\nSeat already occupied. Please choose another seat.\n");
                    continue;
                }

                isValidInput = true;
            }
            catch (InputMismatchException exception) {
                System.out.println("Input must be an integer.");
                scanner.nextLine();
            }
            catch (Exception exception) {
                System.out.println("Something went wrong...");
                scanner.nextLine();
            }
        } while (!isValidInput);

        return seatNumberInput;
    }

    private void printOptions(Integer[] validInputs, String[] inputLabels) {
        System.out.println("**********************************************");
        System.out.println("*                MENU OPTION                 *");
        System.out.println("**********************************************");

        int counter = 0;
        for (String label : inputLabels) {
            System.out.println("    " + validInputs[counter] + ")  " + label);
            counter++;
        }

        System.out.println("**********************************************");
        System.out.print("Please select an option: ");
    }
}
