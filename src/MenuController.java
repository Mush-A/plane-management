/**
 * MenuController is a class that controls the menu of the application.
 * It contains a MenuView and a MenuHandler to display the menu and handle user input respectively.
 */
public class MenuController
{
    private final MenuView menuView;
    private final MenuHandler menuHandler;

    /**
     * Constructs a new MenuController.
     * Initializes the MenuView and MenuHandler.
     */
    public MenuController()
    {
        this.menuView = new MenuView();
        this.menuHandler = new MenuHandler();
    }

    /**
     * Starts the menu loop.
     * The menu is displayed, user input is taken and handled until the user chooses to quit (input = 0).
     */
    public void startMenu()
    {
        int input;

        do {
            this.menuView.displayMenu();
            input = this.menuView.getMenuInput();
            this.menuHandler.handleMenuChoice(input);
        } while (input != 0);

        this.menuView.displayQuitMessage();
    }
}