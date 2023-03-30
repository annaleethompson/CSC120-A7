/** 
 * Filename: Library.java
 * Decription: Library class extentded from Building with a hashtable attribute containing all the titles in the library's collection. Contains functions addTitle, removeTitle, checkOut, returnBook, containsTitle, isAvailable, and printCollection.
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, A6: Use What Your Parent (Class) Gave You
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: March 19, 2023
 */

/**Imports Hashtable from the java.util package */
import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building {

  /**Stored Hashtable containing Title/Author and Availability for each book in the library's collection */
  private Hashtable<String, Boolean> collection;

  /**Constructor */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
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
    if (this.collection.containsValue(false)) {
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
    description+="There is currently " + this.collection.size() + " titles in this libary.";
    return description;
  }

  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson", "Smith College", 4);
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
  }
}
