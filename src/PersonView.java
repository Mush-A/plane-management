import java.util.Scanner;

/**
 * This class is responsible for creating a view to interact with the user and get Person's details.
 */
public class PersonView
{
    // Scanner object to read user input
    private final Scanner scanner;

    /**
     * Constructor for PersonView class.
     * Initializes the scanner object.
     */
    public PersonView()
    {
        this.scanner = new Scanner(System.in);
    }

    /**
     * This method is used to get Person's details from the user.
     * It validates the input and repeats the process until valid input is provided.
     * @return Person object with the details provided by the user.
     */
    public Person getPersonInput() {
        // Create a new Person object
        Person person = new Person();
        // Flag to check if the input is valid
        boolean isValidInput = false;

        do {
            try {
                // Prompt the user to enter the name
                System.out.print("Enter name: ");
                String name = scanner.next();
                // Set the name in the Person object
                person.setName(name);

                // Prompt the user to enter the surname
                System.out.print("Enter surname: ");
                String surname = scanner.next();
                // Set the surname in the Person object
                person.setSurname(surname);

                // Prompt the user to enter the email
                System.out.print("Enter email: ");
                String email = scanner.next();
                // Set the email in the Person object
                person.setEmail(email);

                // Print the Person's information
                System.out.println("Person information:");
                person.printInfo();

                // If all the inputs are valid, set the flag to true
                isValidInput = true;
            } catch (IllegalArgumentException exception) {
                // If an IllegalArgumentException is thrown, print the exception message
                System.out.println(exception.getMessage());
            } catch (Exception exception) {
                // If any other exception is thrown, print a generic error message
                System.out.println("Something went wrong...");
                // Clear the scanner
                scanner.nextLine();
            }
        } while (!isValidInput);

        // Return the Person object
        return person;
    }
}