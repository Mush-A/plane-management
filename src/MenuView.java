import java.util.InputMismatchException;
import java.util.Scanner;
import helper.Search;

/**
 * MenuView is a class that displays the menu of the application and takes user input.
 * It contains a Scanner for user input and a Search for validating the input.
 * It also contains the labels and numbers of the menu items.
 */
public class MenuView
{
    private final Scanner scanner;
    private final Search<Integer> searchInteger;
    private final String[] menuItemLabels = {"Buy a seat", "Cancel a seat", "Find first available seat", "Show seating plan", "Print tickets information and total sales", "Search ticket", "Quit"};
    private final Integer[] menuItemNumber = {1, 2, 3, 4, 5, 6, 0};

    /**
     * Constructs a new MenuView.
     * Initializes the Scanner and Search instances.
     */
    public MenuView()
    {
        this.scanner = new Scanner(System.in);
        this.searchInteger = new Search<Integer>();
    }

    /**
     * Displays the menu to the user.
     * The menu contains the labels and numbers of the menu items.
     */
    public void displayMenu()
    {
        System.out.println("**********************************************");
        System.out.println("*                MENU OPTION                 *");
        System.out.println("**********************************************");

        int counter = 0;
        for (String label : this.menuItemLabels)
        {
            System.out.println("    " + this.menuItemNumber[counter] + ")  " + label);
            counter++;
        }

        System.out.println("**********************************************");
        System.out.print("Please select an option: ");
    }

    /**
     * Displays a quit message to the user and closes the Scanner.
     */
    public void displayQuitMessage()
    {
        this.scanner.close();
        System.out.println("Program quit.");
    }

    /**
     * Gets the user's menu choice.
     * The user's input is validated and if it is not valid, the user is asked to input again.
     *
     * @return the user's menu choice
     */
    public int getMenuInput()
    {
        int input = -1;
        boolean isValidInput = false;

        do {
            try {
                input = this.scanner.nextInt();

                if (input == 0) break;

                if (searchInteger.linearSearch(this.menuItemNumber, input) == -1) {
                    System.out.println("\nInvalid input. Try again:\n");
                    continue;
                }

                isValidInput = true;
            }
            catch (InputMismatchException exception) {
                System.out.println("Invalid input. Try again:");
                this.scanner.nextLine();
            }
            catch (Exception exception) {
                System.out.println("Something went wrong...");
                this.scanner.nextLine();
            }
        } while (!isValidInput);

        return input;
    }
}