import java.io.IOException;

/**
 * The Ticket class represents a ticket for a seat at an event.
 * Each ticket is associated with a row, seat, price, and a person.
 */
public class Ticket {
    private int rowIndex; // The index of the row for the seat
    private int seatIndex; // The index of the seat in the row
    private double price; // The price of the ticket
    private Person person; // The person who owns the ticket
    private final FileManager fileManager; // The file manager to handle file operations

    /**
     * Constructs a new Ticket with the given row, seat, price, and person.
     * Initializes the file manager with the directory "tickets".
     */
    public Ticket(int row, int seat, double price, Person person) {
        this.rowIndex = row;
        this.seatIndex = seat;
        this.price = price;
        this.person = person;

        this.fileManager = new FileManager("tickets");
    }

    // Getter and setter methods for rowIndex, seatIndex, price, and person

    /**
     * Prints the ticket information to the console.
     * @param rowLabels The labels for the rows.
     */
    public void printTicketInfo(String[] rowLabels) {
        System.out.println("Ticket Information:");
        System.out.println("Row: " + rowLabels[rowIndex]);
        System.out.println("Seat: " + (seatIndex + 1));
        System.out.println("Price: $" + price);
    }

    /**
     * Saves the ticket information to a file.
     * The file name is based on the row label and seat number.
     * The file content includes the ticket and person information.
     * @param rowLabels The labels for the rows.
     */
    public void save(String[] rowLabels)
    {
        String fileName = rowLabels[rowIndex] + (seatIndex + 1) + ".txt";

        String content = "Ticket Information:\n" +
                "Row: " + rowLabels[rowIndex] + "\n" +
                "Seat: " + (seatIndex + 1) + "\n" +
                "Price: $" + price + "\n" +
                "Person Information:\n" +
                "Name: " + this.person.getName() + " " + this.person.getSurname() + "\n" +
                "Email: " + this.person.getEmail() + "\n";

        try {
            this.fileManager
                    .setFileName(fileName)
                    .setFileContent(content)
                    .createDirectoryAndFile();

            System.out.println("Ticket saved!");
        } catch (IOException e) {
            System.out.println("Unable to save ticket: " + e.getMessage());
        }
    }
}