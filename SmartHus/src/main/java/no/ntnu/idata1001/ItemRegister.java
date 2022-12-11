package no.ntnu.idata1001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Represents the item register holding information about a storages items
 *
 * @author Harald Wangsvik Fredriksen
 * @version 17-11-2022
 */
  public class ItemRegister {
  private HashMap<String, Item> itemList = new HashMap<>();
  public Item item;

  /**
   * Creates an instance of class ItemRegister
   */
  public ItemRegister() {
  }

  /**
   * Adds an item to the storage.
   * @param item the new item to add to the phone book
   */
  public void addItem(Item item) {
    this.itemList.put(item.getItemId(), item);
  }

  /**
   * Increases the storage volume for item chosen by the itemID
   * by the chosen amount
   *
   * @param itemId
   * @param amount
   */
  public void increaseStorageVolumeForItem(String itemId, int amount) {
    itemList.get(itemId).setStorageVolume(itemList.get(itemId).getStorageVolume() + amount);
  }

  public void decreaseStorageVolumeForItem(String itemId, int amount) {
    itemList.get(itemId).setStorageVolume(itemList.get(itemId).getStorageVolume() - amount);
  }

  public void removeItemFromStorage(Item item) {
    itemList.remove(item.getItemId(), item);
  }

  public void setDiscountByPrice(Item item, int amount) {
    item.setPrice(item.getPrice());
  }

  /**
   * Searches for an item using a search value.
   * if the search value matches an items item ID or its description
   * we return that item.
   * @param searchValue A string value that will be used to search for an item.
   * @return foundItem
   */
  public Item findItem(String searchValue) {
    //Create a boolean
    Boolean found = false;
    //Create an Item to return
    Item foundItem = null;

    Iterator<Item> it = getIterator();

    while (it.hasNext() && !found) {
      Item item = it.next();
      if (searchValue.equals(item.getItemId()) ||
          searchValue.equals(item.getDescription())) {
        foundItem = item;
        found = true;
      }
    }
    return foundItem;
  }

  /**
   * Prints out all the items in the Item register, to the console
   */
  public void printAllItemsInRegister() {
    for (Map.Entry<String, Item> item : itemList.entrySet()) {
      System.out.println(item.toString());
    }
  }

  /**
   * Returns an iterator making it possible to iterate over
   * all the items in the register.
   *
   * @return an iterator to iterate over all items in the register
   */
  public Iterator<Item> getIterator() {
    return this.itemList.iterator();
  }
}
