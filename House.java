/** 
 * Filename: House.java
 * Decription: House class extentded from Building with attributes hasDiningRoom (boolean), and an array list containing all residents. Contains functions hasDiningRoom, nResidents, moveOut, moveIn and isResident.
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, A6: Use What Your Parent (Class) Gave You
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: March 19, 2023
 */

/**Imports ArrayList from the java.util package */
import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building{

  /**Store House ArrayList of residents and a boolean for whether the house has a dining room. */
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  
  /**Constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
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

  public static void main(String[] args) {
    House myHouse = new House("Egg", "1 Chapin Way", 4, true);
    System.out.println(myHouse.toString());
    myHouse.moveIn("Yoke");
    System.out.println(myHouse.toString());
    //myHouse.moveIn("Yoke");
    //myHouse.moveOut("Yoke");
    //myHouse.moveOut("Y");
    //myHouse.isResident("Yoke");
    //myHouse.isResident("Y");
  }

}
