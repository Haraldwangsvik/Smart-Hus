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

    //The current item is the last item the user searched for.
    private Item currentItem;

    /**
     * Creates an instance of class ItemRegister
     */
    public ItemRegister() {
    }

    /**
     * Adds an item to the storage.
     *
     * @param item the new item to add to the phone book
     */
    public void addItem(String itemId,Item item) {
        this.itemList.put(itemId, item);
    }

    /**
     * Increases the storage volume for item chosen by the itemID
     * by the chosen amount
     *
     * @param amount
     */
    public void increaseStorageVolumeForItem(int amount) {
        currentItem.setStorageVolume(currentItem.getStorageVolume() + amount);
    }

    /**
     *
     * @param amount
     */
    public void decreaseStorageVolumeForItem(int amount) {
        currentItem.setStorageVolume(currentItem.getStorageVolume() - amount);
    }

    /**
     * Remove this item from storage
     * Unlike decrease storage volume this method removes the item completely
     */
    public void removeItemFromStorage() {
        itemList.remove(currentItem.getItemId(), currentItem);
    }

    /**
     * Change the price of the current item
     *
     * @param amount
     */
    public void setPrice(int amount) {
        currentItem.setPrice(amount);
    }

    /**
     * Set a discount by percentage for the current item
     *
     * @param percentage
     */
    public void setDiscount(int percentage) {
        int discount = currentItem.getPrice() * ((1 - percentage) / 100);
        setPrice(discount);
    }

    /**
     * Change the description of current item
     *
     * @param description the new description that currentItem will hold.
     */
    public void changeDescription(String description) {
        if (description == null || description == "") {
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
        for (Map.Entry<String, Item> item : itemList.entrySet()) {
            if (item.getKey().equals(searchValue) || item.getValue().getDescription().equals(searchValue)) {
                currentItem = item.getValue();
            }
        }
        return currentItem;
    }

    /**
     * Prints out all the items in the Item register, to the console
     */
    public void printAllItemsInRegister() {
        for (Map.Entry<String, Item> item : itemList.entrySet()) {
            System.out.println(item.getValue().toString());
        }
    }

    /**
     * Return the current item
     */
    public Item getCurrentItem() {
        return currentItem;
    }

}
