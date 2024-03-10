public class MenuHandler
{
    private final PlaneManagement planeManagement;

    public MenuHandler() {
        this.planeManagement = new PlaneManagement();
    }

    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                this.planeManagement.buySeat();
                break;
            case 2:
                this.planeManagement.cancelSeat();
                break;
            case 3:
                this.planeManagement.findFirstAvailable();
                break;
            case 4:
                this.planeManagement.showSeatingPlan();
                break;
            case 5:
                this.planeManagement.printTicketsInfo();
                break;
            case 6:
                this.planeManagement.searchTicket();
                break;
            default:
                System.out.println("That is not a valid option sire!");
        }
    }
}
