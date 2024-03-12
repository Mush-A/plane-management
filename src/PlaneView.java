import helper.Search;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PlaneView class is responsible for handling user inputs and validations related to plane seat selection.
 */
public class PlaneView
{
    private final Scanner scanner;
    private final Search<String> searchString;

    /**
     * Constructor for PlaneView class.
     * Initializes the scanner and searchString objects.
     */
    public PlaneView()
    {
        this.scanner = new Scanner(System.in);
        this.searchString = new Search<String>();
    }

    /**
     * Method to get row input from the user.
     * @param rowLabels Array of row labels.
     * @return String representing the row input.
     */
    public String getRowInput(String[] rowLabels)
    {
        String rowInput = "";
        boolean isValidInput = false;

        do {
            System.out.print("Enter row: ");
            rowInput = this.scanner.next();

            if (rowInput.equals("0")) {
                return "";
            }

            if (this.searchString.linearSearch(rowLabels, rowInput) == -1) {
                System.out.println("\nInvalid row. Try again:\n");
                continue;
            }

            isValidInput = true;
        } while (!isValidInput);

        return rowInput;
    }

    /**
     * Method to get the index of the row input.
     * @param rowLabels Array of row labels.
     * @param rowInput String representing the row input.
     * @return Integer representing the index of the row input.
     */
    public int getRowIndex(String[] rowLabels, String rowInput)
    {
        return this.searchString.linearSearch(rowLabels, rowInput);
    }

    /**
     * Method to get seat number input from the user.
     * @param rowLabels Array of row labels.
     * @param rowInput String representing the row input.
     * @param seatsMatrix 2D array representing the seats matrix.
     * @param validateOccupancy Boolean flag to validate seat occupancy.
     * @param validateVacancy Boolean flag to validate seat vacancy.
     * @return Integer representing the seat number input.
     */
    public int getSeatNumberInput(String[] rowLabels, String rowInput, int[][] seatsMatrix, boolean validateOccupancy, boolean validateVacancy)
    {
        int seatNumberInput = -1;
        boolean isValidInput = false;

        do {
            System.out.print("Enter seat number for row " + rowInput + ": ");
            try {
                seatNumberInput = scanner.nextInt();

                if (seatNumberInput == 0) {
                    return -1;
                }

                int rowIndex = this.searchString.linearSearch(rowLabels, rowInput);
                int maxSeats = seatsMatrix[rowIndex].length;
                if (seatNumberInput < 1 || seatNumberInput > maxSeats) {
                    System.out.println("\nInvalid seat number. Try again.\n");
                    continue;
                }

                if (validateOccupancy && seatsMatrix[rowIndex][seatNumberInput - 1] == 1) {
                    System.out.println("\nSeat already occupied. Please choose another seat.\n");
                    continue;
                }

                if (validateVacancy && seatsMatrix[rowIndex][seatNumberInput - 1] == 0) {
                    System.out.println("\nSeat already vacant. Please choose another seat.\n");
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

    /**
     * Method to get the index of the seat number input.
     * @param seatNumberInput Integer representing the seat number input.
     * @return Integer representing the index of the seat number input.
     */
    public int getSeatIndex(int seatNumberInput)
    {
        return seatNumberInput - 1;
    }
}