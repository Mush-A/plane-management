import java.io.IOException;

public class Ticket {
    private int rowIndex;
    private int seatIndex;
    private double price;
    private Person person;
    private final FileManager fileManager;

    public Ticket(int row, int seat, double price, Person person) {
        this.rowIndex = row;
        this.seatIndex = seat;
        this.price = price;
        this.person = person;

        this.fileManager = new FileManager("tickets");
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getSeatIndex() {
        return seatIndex;
    }

    public void setSeatIndex(int seatIndex) {
        this.seatIndex = seatIndex;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void printTicketInfo(String[] rowLabels) {
        System.out.println("Ticket Information:");
        System.out.println("Row: " + rowLabels[rowIndex]);
        System.out.println("Seat: " + (seatIndex + 1));
        System.out.println("Price: $" + price);
    }

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
