/**
 * This class represents a view for a ticket.
 */
public class TicketView
{
    // The view for the person associated with the ticket
    private final PersonView personView;

    /**
     * The constructor for the TicketView class.
     * It initializes the personView object.
     */
    public TicketView()
    {
        this.personView = new PersonView();
    }

    /**
     * This method is used to get a ticket.
     * @param rowIndex This is the row index of the seat for the ticket.
     * @param seatIndex This is the seat index for the ticket.
     * @param priceMatrix This is a 2D array representing the price matrix of the seats.
     * @return Ticket This returns a new Ticket object.
     */
    public Ticket getTicket(int rowIndex, int seatIndex, int[][] priceMatrix) {
        // Get the person input from the person view
        Person person = this.personView.getPersonInput();
        // Get the price from the price matrix using the row and seat index
        double price = priceMatrix[rowIndex][seatIndex];
        // Return a new ticket with the row index, seat index, price and person
        return new Ticket(rowIndex, seatIndex, price, person);
    }
}