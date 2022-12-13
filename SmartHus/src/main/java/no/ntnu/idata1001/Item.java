package no.ntnu.idata1001;

import java.util.HashMap;
import jdk.jfr.Category;

/**
 * The item class holds all the information of an item
 * and holds the get and set methods for the different values.
 *
 * @author 10022
 * @version 13-12-2022
 */
public class Item {
  //A distinctive ID for one specified item in storage.
  // It includes both letters and numbers (for example: ABC123)
  private String itemId;

  private String description;   //Text that briefly describes the item
  private int price;            //How much the item costs
  private String brand;         //The name of the items brand
  private double weight;        //The weight of the item in kg (kilograms)
  private double length;        //The length of the item
  private double height;        //The height of the item
  private String color;         //The color of the item

  // amount of items currently in storage. This value will never be less than zero
  private int storageVolume;

  private Category category;    //The items category

  // A number representing the category of the item.
  // These are the 4 categories: 1: floor laminates, 2: window, 3: door, 4: Lumber
  enum Category {
    FloorLaminates(1), Window(2), Door(3), Lumber(4);

    Category(int categoryNumber) {}
  }

  // A number that represents the lowest possible value that the category field currently can be
  private static final int lowestCategoryValue = 1;

  // A number that represents the highest possible value that the category field currently can be
  private static final int highestCategoryValue = 4;

  /**
   *Initializes an item with different values describing itself.
   *
   * @param itemId A distinctive ID for one specified item in storage.
   *               It includes both letters and numbers (for example: ABC123)
   * @param description Text that briefly describes the item
   * @param price How much the item costs
   * @param brand The name of the items brand
   * @param weight The weight of the item in kilograms(kg)
   * @param length The length of the item in cm
   * @param height The height of the item in cm
   * @param color The color of the item
   * @param storageVolume amount of items currently in storage.
   *                      This value will never be less than zero
   * @param categoryNumber A number representing the category of the item.
   *                       These are the 4 categories:
   *                       1: floor laminate, 2: window, 3: door, 4: Lumber
   */
  public Item(String itemId, String description, int price, String brand,
              double weight, double length, double height, String color,
              int storageVolume, int categoryNumber) {
    setItemId(itemId);
    setDescription(description);
    setPrice(price);
    setBrand(brand);
    setWeight(weight);
    setLength(length);
    setHeight(height);
    setColor(color);
    setStorageVolume(storageVolume);
    setCategory(categoryNumber);
  }

  /**
   * Returns the item ID.
   *
   * @return itemId
   */
  public String getItemId() {
    return this.itemId;
  }

  /**
   * Set the item ID.
   *
   * @param itemId A distinctive ID for one specified item in storage.
   *               It includes both letters and numbers (for example: ABC123)
   */
  public void setItemId(String itemId) {
    if (itemId == null) {
      throw new IllegalArgumentException("Item ID can not be null");
    } else {
      this.itemId = itemId;
    }
  }

  /**
   * Returns the description of the item.
   *
   * @return description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Set a description for the item.
   *
   * @param description Text that briefly describes the item
   */
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Description can not be null");
    } else {
      this.description = description;
    }
  }

  /**
   * Returns the price of the item.
   *
   * @return price of the item
   */
  public int getPrice() {
    return this.price;
  }

  /**
   * Set a price for the product.
   *
   * @param price How much the item costs
   */
  public void setPrice(int price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price must be greater than zero");
    } else {
      this.price = price;
    }
  }

  /**
   * Returns the items brand name.
   *
   * @return the brand name
   */
  public String getBrand() {
    return this.brand;
  }

  /**
   * Set the name for the brand of the item.
   *
   * @param brand The name of the items brand
   */
  public void setBrand(String brand) {
    if (brand == null) {
      throw new IllegalArgumentException("Brand can not be null");
    } else {
      this.brand = brand;
    }
  }

  /**
   * Returns the weight of the item in kilograms(kg).
   *
   * @return weight of the item in kilograms(kg)
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * Set the weight of the item in kilograms(kg).
   *
   * @param weight The weight of the item in kilograms(kg)
   */
  public void setWeight(double weight) {
    if (weight < 0) {
      throw new IllegalArgumentException("Weight must be greater than zero");
    } else {
      this.weight = weight;
    }
  }

  /**
   * Returns the length of the item in cm.
   *
   * @return length of the item in cm
   */
  public double getLength() {
    return this.length;
  }

;  /**
   * Set the length of the item in cm.
   *
   * @param length The length of the item in cm
   */
  public void setLength(double length) {
    if (length < 0) {
      throw new IllegalArgumentException("Length must be greater than zero");
    } else {
      this.length = length;
    }
  }

  /**
   * Returns the height of the item in cm.
   *
   * @return height of the item in cm
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Set height of the product in cm.
   *
   * @param height The height of the item in cm
   */
  public void setHeight(double height) {
    if (height < 0) {
      throw new IllegalArgumentException("Height must be greater than zero");
    } else {
      this.height = height;
    }
  }

  /**
   * Returns the items color.
   *
   * @return the items color
   */
  public String getColor() {
    return this.color;
  }

  /**
   * Set the items color.
   *
   * @param color The color of the item
   */
  public void setColor(String color) {
    if (color == null) {
      throw new IllegalArgumentException("Color can not be null");
    } else {
      this.color = color;
    }
  }

  /**
   * Returns the amount of items currently in storage.
   *
   * @return amount of items currently in storage
   */
  public int getStorageVolume() {
    return this.storageVolume;
  }

  /**
   * Set the amount of items in the storage.
   *
   * @param storageVolume amount of items currently in storage.
   *                      This value will never be less than zero
   */
  public void setStorageVolume(int storageVolume) {
    if (storageVolume < 0) {
      throw new IllegalArgumentException("Storage volume must be greater than zero");
    } else {
      this.storageVolume = storageVolume;
    }
  }

  /**
   * Return a number that represents the category
   * (1: floor laminates, 2: windows, 3: doors, 4: Lumber).
   *
   * @return category of item
   */
  public Category getCategory() {
    return this.category;
  }

  /**
   * Set a number that represents the category
   * (1: floor laminates, 2: windows, 3: doors, 4: Lumber).
   *
   * @param categoryNumber A number representing the category of the item.
   *                       These are the 4 categories:
   *                       1: floor laminates, 2: windows, 3: doors, 4: Lumber
   */
  public void setCategory(int categoryNumber) {
    if (categoryNumber < lowestCategoryValue || categoryNumber > highestCategoryValue) {
      throw new IllegalArgumentException("Category must be a number between "
          + lowestCategoryValue + " and " + highestCategoryValue);
    } else {
      switch (categoryNumber) {
        case 1 -> this.category = Category.FloorLaminates;
        case 2 -> this.category = Category.Window;
        case 3 -> this.category = Category.Door;
        case 4 -> this.category = Category.Lumber;
        default -> this.category = null;
      }
    }
  }

  /**
   * Return a formatted string that arranges the items values in a clear way.
   *
   * @return A String that holds all the items values
   */
  public String toString() {
    return ("Item ID: " + getItemId() + "\n"
        + "Description: " + getDescription()
        + "\n Price: " + getPrice()
        + "\nBrand: " + getBrand()
        + "\nWeight: " + getWeight()
        + "\nLength: " + getLength()
        + "\nHeight: " + getHeight()
        + "\nColor: " + getColor()
        + "\nStorage volume: " + getStorageVolume()
        + "\nCategory: " + getCategory()
        + "\n\n");
  }


}
