public class MenuController
{
    private final MenuView menuView;
    private final MenuHandler menuHandler;

    public MenuController()
    {
        this.menuView = new MenuView();
        this.menuHandler = new MenuHandler();
    }

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
