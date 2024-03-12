import helper.Search;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneView
{
    private final Scanner scanner;
    private final Search<String> searchString;

    public PlaneView()
    {
        this.scanner = new Scanner(System.in);
        this.searchString = new Search<String>();
    }

    public String getRowInput(String[] rowLabels)
    {
        String rowInput = "";
        boolean isValidInput = false;

        do {
            System.out.print("Enter row: ");
            rowInput = this.scanner.next();

            if (this.searchString.linearSearch(rowLabels, rowInput) == -1) {
                System.out.println("\nInvalid row. Try again:\n");
                continue;
            }

            isValidInput = true;
        } while (!isValidInput);

        return rowInput;
    }

    public int getRowIndex(String[] rowLabels, String rowInput)
    {
        return this.searchString.linearSearch(rowLabels, rowInput);
    }

    public int getSeatNumberInput(String[] rowLabels, String rowInput, int[][] seatsMatrix, boolean validateOccupancy, boolean validateVacancy)
    {
        int seatNumberInput = -1;
        boolean isValidInput = false;

        do {
            System.out.print("Enter seat number for row " + rowInput + ": ");
            try {
                seatNumberInput = scanner.nextInt();

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

    public int getSeatIndex(int seatNumberInput)
    {
        return seatNumberInput - 1;
    }
}
