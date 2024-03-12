/**
 * MenuHandler is a class that handles the user's menu choices.
 * It contains a PlaneManagement instance to perform various operations related to plane management.
 */
public class MenuHandler
{
    private final PlaneManagement planeManagement;

    /**
     * Constructs a new MenuHandler.
     * Initializes the PlaneManagement instance.
     */
    public MenuHandler() {
        this.planeManagement = new PlaneManagement();
    }

    /**
     * Handles the user's menu choice.
     * Depending on the user's choice, it calls the appropriate method of the PlaneManagement instance.
     *
     * @param choice the user's menu choice
     */
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