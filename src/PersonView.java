import helper.Search;

import java.util.Scanner;

public class PersonView
{
    private final Scanner scanner;

    public PersonView()
    {
        this.scanner = new Scanner(System.in);
    }

    public Person getPersonInput() {
        Person person = new Person();
        boolean isValidInput = false;

        do {
            try {
                System.out.print("Enter name: ");
                String name = scanner.next();
                person.setName(name);

                System.out.print("Enter surname: ");
                String surname = scanner.next();
                person.setSurname(surname);

                System.out.print("Enter email: ");
                String email = scanner.next();
                person.setEmail(email);

                System.out.println("Person information:");
                person.printInfo();

                isValidInput = true;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception exception) {
                System.out.println("Something went wrong...");
                scanner.nextLine();
            }
        } while (!isValidInput);

        return person;
    }
}
