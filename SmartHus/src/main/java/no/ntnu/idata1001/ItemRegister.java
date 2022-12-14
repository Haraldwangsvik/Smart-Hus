package no.ntnu.idata1001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Represents the item register holding information about a storages items.
 *
 * @author 10022
 * @version 13-12-2022
 */
public class ItemRegister {
  private HashMap<String, Item> itemList = new HashMap<>();

  //The current item is the last item the user searched for.
  private Item currentItem;

  /**
   * Creates an instance of class ItemRegister.
   */
  public ItemRegister() {
  }

  /**
   * Adds an item to the storage.
   *
   * @param item the new item to add to the phone book
   */
  public void addItem(String itemId, Item item) {
    this.itemList.put(itemId, item);
  }

  /**
   * Increases the storage volume for currently chosen item by the chosen amount.
   *
   * @param amount of items added to storage
   */
  public void increaseStorageVolumeForItem(int amount) {
    currentItem.setStorageVolume(currentItem.getStorageVolume() + amount);
  }

  /**
   *Decreases the storage volume for currently chosen item by the current amount.
   *
   * @param amount of items removed from storage
   */
  public void decreaseStorageVolumeForItem(int amount) {
    currentItem.setStorageVolume(currentItem.getStorageVolume() - amount);
  }

  /**
   * Remove this item from storage
   * Unlike decrease storage volume this method removes the item completely.
   */
  public void removeItemFromStorage() {
    itemList.remove(currentItem.getItemId(), currentItem);
  }

  /**
   * Change the price of the current item.
   *
   * @param amount that the new price should be
   */
  public void setPrice(int amount) {
    currentItem.setPrice(amount);
  }

  /**
   * Set a discount by percentage for the current item.
   *
   * @param percentage taken off the item in the discount
   */
  public void setDiscount(int percentage) {
    int remainder = 100 - percentage;
    int discount = currentItem.getPrice() * (remainder) / 100;
    setPrice(discount);
  }

  /**
   * Change the description of current item.
   *
   * @param description the new description that currentItem will hold.
   */
  public void changeDescription(String description) {
    if (description == null || description.equals("")) {
      System.out.println("did not change this items description as you did not enter anything");
    } else {
      currentItem.setDescription(description);
    }
  }

  /**
   * Searches for an item using a searchValue that can be either itemID or description.
   *
   * @param searchValue used to search for an item
   * @return foundItem
   */
  public Item searchForItem(String searchValue) {

    if ((searchValue == null) || (searchValue.isBlank())) {
      return null;
    }

    Item foundItem = null;

    boolean notFound = true;

    Iterator<Item> it = getIterator();

    while ((notFound) && it.hasNext()) {
      Item item = it.next();

      if (item.getItemId().equals(searchValue) || item.getDescription().equals(searchValue)) {
        currentItem = item;
        foundItem = item;
        notFound = false;
      }
    }
    return foundItem;
  }

  /**
   * Prints out all the items in the Item register, to the console.
   */
  public void printAllItemsInRegister() {

    for (Item item : itemList.values()) {
      System.out.println(item.toString());
    }
  }

  /**
   * Return the current item held.
   */
  public Item getCurrentItem() {
    return currentItem;
  }

  /**
   * Fills item register with some items to use for testing.
   */
  public void fillItemRegister() {
    Item item1 = new Item("111aaa",
        "The door that will make you forget about the room you were in,"
            + " and make you focus on the room you currently are in",
        2500,
        "Doorluxe",
        100,
        70,
        210,
        "Black",
        34,
        3);
    Item item2 = new Item("222bbb",
        "This Floor laminate gives you splinters for every tenth step you take",
        150,
        "Barelyafloor AS",
        20,
        100,
        20,
        "Brown",
        340,
        1);
    Item item3 = new Item("333ccc",
        "Even if you are cheating, do not sneak in through this window",
        4000,
        "Widow as",
        80,
        80,
        80,
        "see through",
        107,
        2);
    Item item4 = new Item("444ddd",
        "Manly lumber for manly men",
        450,
        "Lumbro AS",
        150,
        200,
        30,
        "Brown",
        310,
        4);

    itemList.put(item1.getItemId(), item1);
    itemList.put(item2.getItemId(), item2);
    itemList.put(item3.getItemId(), item3);
    itemList.put(item4.getItemId(), item4);
  }

  /**
   * Provides the iterator for itemList.
   *
   * @return the iterator for itemList
   */
  public Iterator<Item> getIterator() {
    return this.itemList.values().iterator();
  }

}
