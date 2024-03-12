public class PlaneManagement
{
    private final PlaneModel planeModel;
    private final PlaneView planeView;
    private final TicketView ticketView;
    private final Ticket[] tickets;

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

    public void buySeat()
    {
        String rowValue = this.planeView.getRowInput(this.planeModel.rowLabels);
        int columnValue = this.planeView.getSeatNumberInput(this.planeModel.rowLabels, rowValue, this.planeModel.seatsMatrix, true, false);

        if (columnValue == -1 || rowValue.isEmpty()) {
            return;
        }

        int rowIndex = this.planeView.getRowIndex(this.planeModel.rowLabels, rowValue);
        int seatIndex = this.planeView.getSeatIndex(columnValue);

        this.planeModel.seatsMatrix[rowIndex][seatIndex] = 1;
        Ticket ticket = this.ticketView.getTicket(rowIndex, seatIndex, this.planeModel.priceMatrix);
        tickets[rowIndex * this.planeModel.seatsMatrix[rowIndex].length + seatIndex] = ticket;
        ticket.save(this.planeModel.rowLabels);
    }

    public void cancelSeat()
    {
        String rowValue = this.planeView.getRowInput(this.planeModel.rowLabels);
        int columnValue = this.planeView.getSeatNumberInput(this.planeModel.rowLabels, rowValue, this.planeModel.seatsMatrix, false, true);

        if (columnValue == -1 || rowValue.isEmpty()) {
            return;
        }

        int rowIndex = this.planeView.getRowIndex(this.planeModel.rowLabels, rowValue);
        int seatIndex = this.planeView.getSeatIndex(columnValue);

        this.planeModel.seatsMatrix[rowIndex][seatIndex] = 0;
        tickets[rowIndex * this.planeModel.seatsMatrix[rowIndex].length + seatIndex] = null;
    }

    public void findFirstAvailable()
    {
        search: {
            for (int rowIndex = 0; rowIndex < this.planeModel.seatsMatrix.length; rowIndex++) {
                for (int seatIndex = 0; seatIndex < this.planeModel.seatsMatrix[rowIndex].length; seatIndex++) {
                    if (this.planeModel.seatsMatrix[rowIndex][seatIndex] == 0) {
                        System.out.println("First available seat at " + this.planeModel.rowLabels[rowIndex] + (seatIndex + 1));
                        break search;
                    }
                }
            }
        }
    }

    public void showSeatingPlan()
    {
        System.out.println();
        for (int rowIndex = 0; rowIndex < this.planeModel.seatsMatrix.length; rowIndex++) {
            for (int seatIndex = 0; seatIndex < this.planeModel.seatsMatrix[rowIndex].length; seatIndex++) {
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

    public void printTicketsInfo()
    {
        double totalSales = 0;
        for (Ticket ticket : this.tickets) {
            if (ticket != null) {
                ticket.printTicketInfo(this.planeModel.rowLabels);
                totalSales += ticket.getPrice();
            }
        }
        System.out.println("Total sales: $" + totalSales);
    }

    public void searchTicket()
    {
        String rowValue = this.planeView.getRowInput(this.planeModel.rowLabels);
        int columnValue = this.planeView.getSeatNumberInput(this.planeModel.rowLabels, rowValue, this.planeModel.seatsMatrix, false, false);

        if (columnValue == -1 || rowValue.isEmpty()) {
            return;
        }

        int rowIndex = this.planeView.getRowIndex(this.planeModel.rowLabels, rowValue);
        int seatIndex = this.planeView.getSeatIndex(columnValue);

        Ticket ticket = tickets[rowIndex * this.planeModel.seatsMatrix[rowIndex].length + seatIndex];

        if (ticket != null) {
            ticket.printTicketInfo(this.planeModel.rowLabels);
            ticket.getPerson().printInfo();
        } else {
            System.out.println("This seat is available.");
        }
    }
}
