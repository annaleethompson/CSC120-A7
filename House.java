/** 
 * Filename: House.java
 * Decription: House class extended from Building with attributes hasDiningRoom (boolean), an array list containing all residents, and a boolean for whether there is an elevator. Contains functions hasDiningRoom(), nResidents(), moveOut(), moveIn(), and isResident().
 * Overriden Methods: toString(), showOptions(), and goToFloor()
 * Overloaded Methods: Conctructor (no name), and isResident()
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, A7: Not Your Parents Methods
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: April 3, 2023
 */

/**Imports ArrayList from the java.util package */
import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building{

  /**Store House ArrayList of residents and a boolean for whether the house has a dining room and an elevator. */
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  Boolean elevator;
  
  /**Constructor */
  public House(String address, int nFloors, boolean hasDiningRoom, boolean elevator) {
    super(address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.elevator = elevator;
    System.out.println("You have built a house: 🏠");
  }

  /**Accessor for the boolean hasDiningRoom
   * @return the boolean for whether or not the house has a dining room
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**Accessor for the number of residents in the house
   * @return the length of the Array List containing all the residents = the number of residents
   */
  public int nResidents(){
    return residents.size();
  }

  /**Manipulator to "move in" a resident. If the person isn't already a resident then they are added to the Array List of residents.
   * @param name name of the resident to be moved into the house
   */
  public void moveIn(String name) {
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of this house");
    }
    this.residents.add(name);
    System.out.println(name + " was moved into the house.");
  }

  /**Manipulator to "move out" a resident. If the person is a resident and there are residents in the house then they are removed from the Array list contianing all the residents.
   * @param name name of resident to be moved out of the house
   * @return name of resident that was moved out of the house
   */
  public String moveOut(String name){
    if (this.residents.size() == 0){
      throw new RuntimeException("Sorry, there are no residents in this house");
    }
    if (!this.residents.contains(name)){
      throw new RuntimeException("Sorry, "+name+" is not a resident in this house");
    }
    this.residents.remove(name);
    System.out.println(name + " was moved out of the house.");
    return name;
  }

  /**Accessor for whether or not a person is a resident of the house
   * @param person person to be determined if they are a resident of the house
   * @return boolean describing if person is a resident (true = resident, false = not a resident)
   */
  public boolean isResident(String person) {
    if (this.residents.size() == 0){
      throw new RuntimeException("Sorry, there are no residents in this house");
    }
    if (this.residents.contains(person)){
      System.out.println(person + " is a resident of this house");
      return true;
    }
    else {
      System.out.println(person + " is not a resident of this house");
      return false;
    }
  }

  /**Overloaded Accessor for whether or not two people are residents of the house
   * @param person first person to be determined if they are a resident of the house
   * @param person2 second person to be determined if they are a resident of the house
   * @return boolean describing if each person is a resident (true = resident, false = not a resident)
   */
  public boolean isResident(String person, String person2) {
    if (this.residents.size() == 0){
      throw new RuntimeException("Sorry, there are no residents in this house");
    }
    if (this.residents.contains(person) == true) {
      if (this.residents.contains(person2) == true) {
        System.out.println(person+" and "+person2 +" are both residents of this house!");
        return true;
      }
      if (this.residents.contains(person2) == false) {
        System.out.println(person+" is a resident but "+person2 +" is not");
        return false;
      }
    }
    if (this.residents.contains(person) == false) {
      if (this.residents.contains(person2) == false) {
        System.out.println("Both "+person+" and "+person2+" are not residents of this house");
        return false;
      }
      if (this.residents.contains(person2) == true) {
        System.out.println(person2+" is a resident but "+person+" is not");
        return false;
      }
      return false;
    } else {
      return false;
    } 
  }

   /*House Extention of the Building toString() method */
  public String toString() {
    String description = super.toString();
    description+=" There are currently " +this.residents.size()+ " residents in this house.";
    description+=" This house";
    if (this.hasDiningRoom) {
      description+= " has";
    }
    else{
      description+=" does not have";
    }
    description+=" a dining room";
    return description;
  }

  /* Overridden building method. Calls building method and adds the House class functions. */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn(name)\n + moveOut(name)\n + isResident(person)");
  }

  /**Overridden building method. If the house has an elevator then it calls the buildings original goToFloor method. If the house doesn't have an elevator, you can only move up or down one floor at a time. 
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
    House myHouse = new House("1 Chapin Way", 4, true, false);
    System.out.println(myHouse.toString());
    myHouse.moveIn("Yoke");
    System.out.println(myHouse.toString());
    House Tejegg  = new House("1 Bacon Way", 7, true, false);
    //Tejegg.moveIn("Tejas");
    Tejegg.moveIn("Yoke");
    //myHouse.moveOut("Yoke");
    //myHouse.moveOut("Y");
    //myHouse.isResident("Yoke");
    //myHouse.isResident("Y");
    Tejegg.showOptions();
    Tejegg.enter();
    //Tejegg.goToFloor(2);
    Tejegg.isResident("Yoke", "Tejas");
  }
}
