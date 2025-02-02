/** 
 * Filename: Library.java
 * Decription: Library class extended from Building with a hashtable attribute containing all the titles in the library's collection. Contains functions addTitle, removeTitle, checkOut, returnBook, containsTitle, isAvailable, and printCollection.
 * Overridden Methods: toString(), showOptions(), and goToFloor()
 * Overloaded Methods: containsTitle(), and isAvailable()
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, A7: Not Your Parents Methods
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: April 3, 2023
 */

/**Imports Hashtable from the java.util package */
import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building {

  /**Stored Hashtable containing Title/Author and availability for each book in the library's collection, as well as a boolean for if the libbrary has a elevator */
  private Hashtable<String, Boolean> collection;
  Boolean elevator;

  /**Constructor */
  public Library(String name, String address, int nFloors, Boolean elevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    this.elevator = elevator;
    System.out.println("You have built a library: 📖");
  }
  
  /**Manipulator to add a book to the library's collection if it isn't a part of the collection already by adding the title to the hashtable.
   * @param title string containing title/author of the book to be added to the library collection
   */
  public void addTitle(String title) {
    if (this.collection.containsKey(title)){
      throw new RuntimeException(title+" is aleady a part of this library's collection");
    }
    this.collection.put(title, true);
    System.out.println(title + " was added to the library collection");
  }
  
  /**Manipulator to remove a book from the library's collection if it is a part of the collection by removing the title from the hashtable.
   * @param title the title/author of the the book to be removed from the collection
   * @return the title/author of the book that was removed from the collection
   */
  public String removeTitle(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)){
      throw new RuntimeException("Sorry, "+title+" is not in this library's collection");
    }
    this.collection.remove(title);
    System.out.println(title+" was removed from this library's collection");
    return title; 
  }

  /**Manipulator to check a book out from the collection if it is in the collection and is available by changing the availability value associeted with the book in the hashtable to false (unavailable).
   * @param title the title/author of the book to be checked out
   */
  public void checkOut(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Sorry, "+title+ " is not a part of this library's collection");
    }
    if (this.collection.get(title)==false) {
      throw new RuntimeException(title + " is already checked out");
    }
    this.collection.replace(title, true, false);
    System.out.println(title +" was succesfully checked out!");
  }

  /**Manipulator to return a book to the collection if it is a part of the collection and is checked out by changing the availability value associated with the book in the hashtable to true (available)
   * @param title the title/author of the book to be returned
   */
  public void returnBook(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Sorry, "+title+ " is not a part of this library's collection");
    }
    if (this.collection.containsValue(true)) {
      throw new RuntimeException(title + " is not checked out.");
    }
    this.collection.replace(title, false, true);
    System.out.println(title+" was succesfully returned");
  }

  /**Acessor to determine if a book is in the collection using the containsKey function to search for presence/absence of titles.
   * @param title title/author being searched for in the collection
   * @return a boolean value for whether or not the title is in the collection 
   */
  public boolean containsTitle(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
     if (this.collection.containsKey(title)){
      System.out.println(title+" is in this library's collection");
      return true;
    }
    else {
      System.out.println(title+" is not in this library's collection");
      return false;
    }
  }

  /**Overloaded Acessor to determine if two books are in the collection at the same time using the containsKey function to search for presence/absence of titles.
   * @param title title/author of the first book being searched for in the collection
   * @param title2 title/author of the second book being searched for in the collection
   * @return a boolean value for whether or not the title is in the collection 
   */
  public boolean containsTitle(String title, String title2) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (this.collection.containsKey(title) == true) {
      if (this.collection.containsKey(title2) == true) {
        System.out.println(title+" and "+title2 +" are both in this collection!");
        return true;
      }
      if (this.collection.containsKey(title2) == false) {
        System.out.println(title+" is in this collection but "+title2 +" is not");
        return false;
      }
    }
    if (this.collection.containsKey(title) == false) {
      if (this.collection.containsKey(title2) == false) {
        System.out.println("Both "+title+" and "+title2+" are not in this collection");
        return false;
      }
      if (this.collection.containsKey(title2) == true) {
        System.out.println(title2+" is in this collection but "+title+" is not");
        return false;
      }
      return false;
    } else {
      return false;
    } 
  }

  /**Accesor to determine if a book is available to be checked out using the get() function for a specific title withing the collection.
   * @param title the title/author that's availablility status is to be determined
   * @return a boolean value for if the book is available (true = available, false = unavailable)
   */
  public boolean isAvailable(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Sorry, "+title+ " is not a part of this library's collection");
    }
    if (this.collection.get(title) == true) {
      System.out.println(title+" is available!");
      return true;
    }
    else {
      System.out.println(title + " is not available :(");
      return false;
    } 
  }

  /**Overloaded Accesor to determine if two books are available at the same time to be checked out using the get() function for a specific title withing the collection.
   * @param title the title/author of the first book that's availablility status is to be determined
   * @param title2 the title/author of the second book that's availablility status is to be determined
   * @return a boolean value for if the book is available (true = available, false = unavailable)
   */
  public boolean isAvailable(String title, String title2) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Sorry, "+title+ " is not a part of this library's collection");
    }
    if (!this.collection.containsKey(title2)) {
      throw new RuntimeException("Sorry, "+title2+ " is not a part of this library's collection");
    }
    if (this.collection.get(title) == true) {
      if (this.collection.get(title2) == true) {
        System.out.println(title+" and "+title2 +" are both available!");
        return true;
      }
      if (this.collection.get(title2) == false) {
        System.out.println(title+" is available but "+title2 +" is unavailable");
        return false;
      }
    }
    if (this.collection.get(title) == false) {
      if (this.collection.get(title2) == false) {
        System.out.println("Both "+title+" and "+title2+" are unavailable");
        return false;
      }
      if (this.collection.get(title2) == true) {
        System.out.println(title2+" is available but "+title+" is unvailable");
        return false;
      }
      return false;
    } else {
      return false;
    } 
  }

  /**Prints all of the titles within the collection nicely-formated */
  public void printCollection() {
    System.out.println("Titles in this Collection:");
    System.out.println(this.collection.toString()
                          .replace("{", " ")
                          .replace("=",":")
                          .replace(",", "\n")
                          .replace("true", " Available")
                          .replace("false", " Unavailable")
                          .replace("}", ""));
      
  }

   /*Library Extention of the Building toString() method */
  public String toString() {
    String description = super.toString();
    description+=" There is currently " + this.collection.size() + " titles in this libary.";
    return description;
  }

  /* Overridden building method. Calls building method and adds the Library class functions. */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle(title) \n + removeTitle(title) \n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)\n + printcollection()");
  }

  /**Overriden building method. If the house has an elevator then it calls the buildings original goToFloor method. If the house doesn't have an elevator, you can only move up or down one floor at a time. 
   * @param floorNum the floor that you want to travel to
   */
  public void goToFloor(int floorNum) {
    if (this.elevator == true) {
      System.out.println("...Ridng Elevator...");
      super.goToFloor(floorNum);
    }
    if (this.elevator == false) {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      else if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      else if (Math.abs(floorNum - this.activeFloor) !=1){
        throw new RuntimeException("Sorry, you can only move one floor at a time!");
      }
      else if ((floorNum - this.activeFloor) ==1) {
        this.activeFloor +=1;
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      }
      else if ((floorNum-this.activeFloor) ==-1) {
        this.activeFloor -=1;
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      }
    }
  }

  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson", "Smith College", 4, true);
    myLibrary.addTitle("The Hobbit");
    System.out.println(myLibrary.toString());
    //myLibrary.addTitle("The Hobbit");
    //myLibrary.removeTitle("The Hobbit");
    //myLibrary.removeTitle("The Hobbits");
    //myLibrary.checkOut("The Hobbit");
    //myLibrary.checkOut("The Hobbits");
    //myLibrary.returnBook("The Hobbit");
    //myLibrary.containsTitle("The Hobbit");
    //myLibrary.isAvailable("The Hobbit");
    //myLibrary.addTitle("Lord of the Rings");
    //myLibrary.addTitle("The Silmarillion");
    //myLibrary.printCollection();
    Library Tejegg  = new Library("Tejegg", "1 Bacon Way", 7, false);
    //Tejegg.addTitle("Twilight"); 
    //Tejegg.addTitle("The Hunger Games");
    Tejegg.addTitle("The Hobbit");
    System.out.println(Tejegg.toString());
    Tejegg.printCollection();
    Tejegg.showOptions();
    Tejegg.enter();
    Tejegg.goToFloor(2);
    //Tejegg.checkOut("The Hunger Games");
    Tejegg.printCollection();
    //Tejegg.checkOut("Twilight");
    //Tejegg.isAvailable("Twilight", "The Hunger Games");
    Tejegg.containsTitle("Twilight", "The Hunger Games");
  }
}
