package no.ntnu.idata1001;

import java.util.Scanner;

/**
 * Represents the ItemRegister application, including the dialog with
 * the user (input and output)
 *
 * @author Harald W Fredriksen
 * @version 11.12.2022
 */
public class WarehouseManagementApp {

    // Constants used for the menu choice.
    private static final int ADD_ITEM = 1;
    private static final int LIST_ALL_ITEMS = 2;
    private static final int SEARCH_FOR_ITEM = 3;
    private static final int EXIT = 4;

    // Constants used for the item menu choice.
    private static final int INCREASE_AMOUNT_IN_STORAGE = 1;
    private static final int DECREASE_AMOUNT_IN_STORAGE = 2;
    private static final int CHANGE_PRICE = 3;
    private static final int APPLY_DISCOUNT = 4;
    private static final int CHANGE_DESCRIPTION = 5;
    private static final int DELETE_THIS_ITEM = 6;
    private static final int GO_BACK = 7;

    // The register handling the collection of items
    private ItemRegister itemRegister;

    /**
     * Creates an instance of the user interface.
     */
    public WarehouseManagementApp() {
        this.itemRegister = new ItemRegister();
    }

    /**
     * Initializes the application
     */
    public void init() {
        itemRegister.fillItemRegister();
    }

    /**
     * Starts the application, by presenting a menu for the user.
     * From this menu, the user is presented with the different actions
     * he can take.
     * After a task is performed, the menu is displayed again.
     */
    public void start() {
        boolean finished = false;

        //Keep looping as long as the user does not exit the application
        while (!finished) {
            int mainMenu = showMainMenu();

            switch (mainMenu)
            {
                case ADD_ITEM:
                    this.addItem();
                    break;

                case LIST_ALL_ITEMS:
                    this.printAllItems();
                    break;

                case SEARCH_FOR_ITEM:
                    this.searchForItem();
                    this.itemMenu();
                    break;

                case EXIT:
                    System.out.println("Closing the application");
                    finished = true;
                    break;

                default:
                    System.out.println("You seem to have entered a wrong value."
                            + "\nPLease try again");
                    break;
            }
        }
    }

    public void itemMenu() {
        boolean finished = false;

        while (!finished) {
            int itemMenu = showItemMenu();

            switch(itemMenu) {
                case INCREASE_AMOUNT_IN_STORAGE:
                    this.increaseStorageVolume();
                    break;

                case DECREASE_AMOUNT_IN_STORAGE:
                    this.decreaseStorageVolume();
                    break;

                case CHANGE_PRICE:
                    this.changePrice();
                    break;

                case APPLY_DISCOUNT:
                    this.applyDiscount();
                    break;

                case CHANGE_DESCRIPTION:
                    this.changeDescription();
                    break;

                case DELETE_THIS_ITEM:
                    this.deleteItem();
                    break;

                case GO_BACK:
                    finished = true;
            }
        }
    }

    /**
     * Executes the "Delete item from storage" menu choice.
     *
     * Deletes an item fully from storage.
     */
    private void deleteItem() {
        itemRegister.removeItemFromStorage();
    }

    /**
     * Executes the "Change description" menu choice.
     *
     * Changes the description of the currently chosen item by user input
     */
    private void changeDescription() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("The description for " + itemRegister.getCurrentItem().getItemId() +
            "currently is: \n" + itemRegister.getCurrentItem().getDescription());

        System.out.println("\nPlease enter the description you want to change it into:\n If you dont wish to change it, leave the space blank");

        String newDescription = userInput.nextLine();

        itemRegister.changeDescription(newDescription);
    }

    /**
     * Executes the "Apply discount" menu choice.
     *
     * Applies a discount to the currently chosen item
     * The discount should be entered in the wanted percentage taken off.
     */
    private void applyDiscount() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the amount of discount you want to apply to this item: \n " +
            "(The discount is calculated in percentage, so if you would want 10% off write 10, 50% off write 50 and so on.)");

        int percentage = checkInteger();

        itemRegister.setDiscount(percentage);

        System.out.println("The price for " + itemRegister.getCurrentItem().getItemId() +
            " is now at: " + itemRegister.getCurrentItem().getPrice());
    }

    /**
     * Executes the "Change price" menu choice.
     *
     * Change the price of an item by asking for the wanted price,
     * then changing the price into the wanted price.
     */
    private void changePrice() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("The price for " + itemRegister.getCurrentItem().getItemId() +
            " is currently at: " + itemRegister.getCurrentItem().getPrice());
        System.out.println("Please enter the new price wanted to this item:");

        int newPrice = checkInteger();

        itemRegister.setPrice(newPrice);

        System.out.println("The price for " + itemRegister.getCurrentItem().getItemId() +
            " is now at: " + itemRegister.getCurrentItem().getPrice());
    }

    /**
     * Executes the "Decrease amount in storage" menu choice.
     *
     * Takes a wanted amount of an item out of storage.
     */
    private void decreaseStorageVolume() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("You currently have " + itemRegister.getCurrentItem().getStorageVolume() +
            " wares in storage for item " + itemRegister.getCurrentItem().getItemId());
        System.out.println("Please enter how many you would like to take out of storage:");

        int takenOut = checkInteger();

        itemRegister.decreaseStorageVolumeForItem(takenOut);

        System.out.println("The new stock for " + itemRegister.getCurrentItem().getItemId() +
            " is now at: " + itemRegister.getCurrentItem().getStorageVolume());
    }

    /**
     * Execute the "Increase amount in storage" menu choice.
     *
     * Adds a wanted amount of an item into the storage.
     */
    private void increaseStorageVolume() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("You currently have " + itemRegister.getCurrentItem().getStorageVolume() +
            " wares in storage for item " + itemRegister.getCurrentItem().getItemId());
        System.out.println("Please enter how many you would like to add to storage:");

        int addedAmount = checkInteger();

        itemRegister.increaseStorageVolumeForItem(addedAmount);

        System.out.println("The new stock for " + itemRegister.getCurrentItem().getItemId() +
            " is now at: " + itemRegister.getCurrentItem().getStorageVolume());
    }

    /**
     * Execute the "add items" menu choice.
     */
    private void addItem() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the following information about the item to add:");
        System.out.println("Item ID:");

        String itemId = userInput.nextLine();


        System.out.println("Description:");

        String description = userInput.nextLine();

        System.out.println("Price:");

        int price = checkInteger();

        System.out.println("Brand:");

        String brand = userInput.nextLine();

        System.out.println("Weight:");

        double weight = checkDouble();

        System.out.println("Length:");

        double length = checkDouble();

        System.out.println("Height:");

        double height = checkDouble();

        System.out.println("Color:");

        String color = userInput.nextLine();

        System.out.println("How much of this item you want to add in the storage:");

        int storageVolume = checkInteger();

        System.out.println("There are four available category options: " +
            "1: Floor laminate, 2: Window, 3: Door, 4: Lumber");
        System.out.println("Please put in the number of the category for this item: ");

        int categoryNumber = checkInteger();

        Item item = new Item(itemId, description, price, brand,
            weight, length, height, color,
            storageVolume, categoryNumber);
        itemRegister.addItem(itemId, item);

        System.out.println(item.toString());
    }

    /**
     * Executes the "Print all items" menu choice, by
     * printing all items to the console window
     */
    private void printAllItems() {
        System.out.println("List of all items in the item register:");
        itemRegister.printAllItemsInRegister();
    }

    /**
     * Executes the "search for an item" menu choice.
     */
    private void searchForItem() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the item ID or the description " +
            "to the item you want to search for:");

        String searchValue = userInput.nextLine();


        if (itemRegister.searchForItem(searchValue) == null) {
            System.out.println("The item you searched for is not in the register.");
        } else {
            System.out.println("The item you searched for:");
            System.out.println(itemRegister.getCurrentItem().toString());
        }
    }

    /**
     * Displays the main menu for the user, followed by waiting for the user to choose an action
     *
     * @return the menu choice of the user as an integer. If the user input is invalid, 0 is returned.
     */
    private int showMainMenu() {
        int selectedChoice = 0;
        System.out.println("\n*** Welcome to Smart House AS Application ***\n");

        System.out.println("1. Add item");
        System.out.println("2. List all items");
        System.out.println("3. Search for an item");
        System.out.println("4. Exit");
        System.out.println("\nPlease enter the number for what you would like to do.\n");

        Scanner userInput = new Scanner(System.in);

        if (userInput.hasNextInt()) {
            selectedChoice = userInput.nextInt();
            userInput.nextLine();
        } else {
            System.out.println("Sorry, you seem to have entered a wrong value."
                + "\nPlease try again.");
        }

        return selectedChoice;
    }

    /**
     * Displays the item menu for the user, followed by waiting for the user to choose an action
     *
     * @return the menu choice of the user as an integer. If the user
     * input is invalid zero is returned
     */
    private int showItemMenu() {
        int selectedChoice = 0;
        System.out.println("\n*** This is the item menu for your chosen item ***\n");

        System.out.println("1. Increase amount in storage");
        System.out.println("2. Decrease amount in storage");
        System.out.println("3. Change price");
        System.out.println("4. Apply discount");
        System.out.println("5. Change description");
        System.out.println("6. Delete item from storage");
        System.out.println("7. Go back to main menu");
        System.out.println("\nPlease enter the number for what you would like to do.\n");

        Scanner userInput = new Scanner(System.in);

        if (userInput.hasNextInt()) {
            selectedChoice = userInput.nextInt();
            userInput.nextLine();
        } else {
            System.out.println("Sorry, you seem to have entered a wrong value."
                + "\nPlease try again.");
        }

        return selectedChoice;
    }

    /**
     * Check that an entered integer actually is a number,
     * and if not it won't allow the input.
     * @return input when valid
     */
    private int checkInteger() {
        Scanner userInput = new Scanner(System.in);
        int input = 0;
        boolean finished = false;

        while (!finished) {
            if (userInput.hasNextInt()) {
                input = userInput.nextInt();
                userInput.nextLine();
                finished = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number");
                userInput.next();
            }
        }
        return input;
    }

    /**
     * Check that an entered double actually is a number,
     * and if not it won't allow the input.
     * @return input when valid
     */
    private double checkDouble() {
        Scanner userInput = new Scanner(System.in);
        double input = 0;
        boolean finished = false;

        while (!finished) {
            if (userInput.hasNextDouble()) {
                input = userInput.nextDouble();
                finished = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number");
                userInput.next();
            }
        }
        return input;
    }
}
