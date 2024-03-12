/**
 * This class is responsible for managing the plane's seating and ticketing system.
 */
public class PlaneManagement
{
    // The model of the plane
    private final PlaneModel planeModel;
    // The view of the plane
    private final PlaneView planeView;
    // The view of the ticket
    private final TicketView ticketView;
    // An array of tickets
    private final Ticket[] tickets;

    /**
     * The constructor initializes the plane model, plane view, ticket view and tickets array.
     */
    public PlaneManagement()
    {
        this.planeModel = new PlaneModel();
        this.planeView = new PlaneView();
        this.ticketView = new TicketView();

        int totalSeats = 0;
        for (int[] row : this.planeModel.seatsMatrix) {
            totalSeats += row.length;
        }

        this.tickets = new Ticket[totalSeats];
    }

    /**
     * This method is used to buy a seat on the plane.
     */
    public void buySeat()
    {
        // Get the row and seat number from the user
        String rowValue = this.planeView.getRowInput(this.planeModel.rowLabels);
        int columnValue = this.planeView.getSeatNumberInput(this.planeModel.rowLabels, rowValue, this.planeModel.seatsMatrix, true, false);

        // If the row or seat number is invalid, return
        if (columnValue == -1 || rowValue.isEmpty()) {
            return;
        }

        // Get the index of the row and seat
        int rowIndex = this.planeView.getRowIndex(this.planeModel.rowLabels, rowValue);
        int seatIndex = this.planeView.getSeatIndex(columnValue);

        // Mark the seat as taken in the seats matrix
        this.planeModel.seatsMatrix[rowIndex][seatIndex] = 1;
        // Create a new ticket and save it in the tickets array
        Ticket ticket = this.ticketView.getTicket(rowIndex, seatIndex, this.planeModel.priceMatrix);
        tickets[rowIndex * this.planeModel.seatsMatrix[rowIndex].length + seatIndex] = ticket;
        // Save the ticket
        ticket.save(this.planeModel.rowLabels);
    }

    /**
     * This method is used to cancel a seat on the plane.
     */
    public void cancelSeat()
    {
        // Get the row and seat number from the user
        String rowValue = this.planeView.getRowInput(this.planeModel.rowLabels);
        int columnValue = this.planeView.getSeatNumberInput(this.planeModel.rowLabels, rowValue, this.planeModel.seatsMatrix, false, true);

        // If the row or seat number is invalid, return
        if (columnValue == -1 || rowValue.isEmpty()) {
            return;
        }

        // Get the index of the row and seat
        int rowIndex = this.planeView.getRowIndex(this.planeModel.rowLabels, rowValue);
        int seatIndex = this.planeView.getSeatIndex(columnValue);

        // Mark the seat as available in the seats matrix
        this.planeModel.seatsMatrix[rowIndex][seatIndex] = 0;
        // Remove the ticket from the tickets array
        tickets[rowIndex * this.planeModel.seatsMatrix[rowIndex].length + seatIndex] = null;
    }

    /**
     * This method is used to find the first available seat on the plane.
     */
    public void findFirstAvailable()
    {
        search: {
            for (int rowIndex = 0; rowIndex < this.planeModel.seatsMatrix.length; rowIndex++) {
                for (int seatIndex = 0; seatIndex < this.planeModel.seatsMatrix[rowIndex].length; seatIndex++) {
                    // If the seat is available, print its location and break the loop
                    if (this.planeModel.seatsMatrix[rowIndex][seatIndex] == 0) {
                        System.out.println("First available seat at " + this.planeModel.rowLabels[rowIndex] + (seatIndex + 1));
                        break search;
                    }
                }
            }
        }
    }

    /**
     * This method is used to print the seating plan of the plane.
     */
    public void showSeatingPlan()
    {
        System.out.println();
        for (int rowIndex = 0; rowIndex < this.planeModel.seatsMatrix.length; rowIndex++) {
            for (int seatIndex = 0; seatIndex < this.planeModel.seatsMatrix[rowIndex].length; seatIndex++) {
                // Print 'O' for available seats and 'X' for taken seats
                if (this.planeModel.seatsMatrix[rowIndex][seatIndex] == 0) {
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

    /**
     * This method is used to print the information of all the tickets.
     */
    public void printTicketsInfo()
    {
        double totalSales = 0;
        for (Ticket ticket : this.tickets) {
            if (ticket != null) {
                // Print the ticket info and add its price to the total sales
                ticket.printTicketInfo(this.planeModel.rowLabels);
                totalSales += ticket.getPrice();
            }
        }
        // Print the total sales
        System.out.println("Total sales: $" + totalSales);
    }

    /**
     * This method is used to search for a ticket.
     */
    public void searchTicket()
    {
        // Get the row and seat number from the user
        String rowValue = this.planeView.getRowInput(this.planeModel.rowLabels);
        int columnValue = this.planeView.getSeatNumberInput(this.planeModel.rowLabels, rowValue, this.planeModel.seatsMatrix, false, false);

        // If the row or seat number is invalid, return
        if (columnValue == -1 || rowValue.isEmpty()) {
            return;
        }

        // Get the index of the row and seat
        int rowIndex = this.planeView.getRowIndex(this.planeModel.rowLabels, rowValue);
        int seatIndex = this.planeView.getSeatIndex(columnValue);

        // Get the ticket from the tickets array
        Ticket ticket = tickets[rowIndex * this.planeModel.seatsMatrix[rowIndex].length + seatIndex];

        // If the ticket exists, print its info and the person's info
        if (ticket != null) {
            ticket.printTicketInfo(this.planeModel.rowLabels);
            ticket.getPerson().printInfo();
        } else {
            // If the ticket does not exist, print that the seat is available
            System.out.println("This seat is available.");
        }
    }
}