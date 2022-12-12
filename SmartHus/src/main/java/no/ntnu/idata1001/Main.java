package no.ntnu.idata1001;

/**
 * The starting point of the application.
 * All this class does is run the application
 *
 * @author 10022
 * @version 13.12.2022
 */
public class Main {

  /**
   * The main method of the program. This method should be the only
   * method available to run.
   *
   * @param args a fixed size array of strings holding arguments provided
   *             from the command line during the startup of the application.
   */
  public static void main(String[] args) {
    WarehouseManagementApp itemRegisterApp = new WarehouseManagementApp();

    itemRegisterApp.start();
  }
}
