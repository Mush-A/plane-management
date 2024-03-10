public class TicketView
{
    private final PersonView personView;

    public TicketView()
    {
        this.personView = new PersonView();
    }

    public Ticket getTicket(int rowIndex, int seatIndex, int[][] priceMatrix) {
        Person person = this.personView.getPersonInput();
        double price = priceMatrix[rowIndex][seatIndex];
        return new Ticket(rowIndex, seatIndex, price, person);
    }
}
