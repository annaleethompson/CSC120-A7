/** 
 * Filename: Cafe.java
 * Decription: Cafe class extentded from Building with attributes nCoffeeOunces, nSugarPackets, nCreams, and nCups. Contains functions sellCoffee, and restock.
 * Overridden Methods: toString(), showOptions(), and goToFloor()
 * Overloaded Methods: Constructor (no nFloors), and restock()
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, A7: Not Your Parents Methods
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: April 3, 2023
 */

/* This is a stub for the Cafe class */
public class Cafe extends Building {

    /**Stores integers for the number of coffee ounces, sugar packets, creams, and cups in stock. */
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**Constructor */
    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**Manupulator to sell coffee if sufficient stock is available which decrease the stock of all attributes. 
     * @param size the number of coffee ounces used when making the coffee
     * @param nSugarPackets the number of sugar packets used in this order
     * @param nCreams the number of creams used in this order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces<size || this.nSugarPackets<nSugarPackets || this.nCreams<nCreams || this.nCups == 0) {
            System.out.println("Insufficient stock -> Restocking");
            restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Coffee succesfully sold!");
    }

    /**Manipulator to restock supplies.
     * @param nCoffeeOunces the number of coffee ounces to be added to the current stock
     * @param nSugarPackets the number of sugar packets to be added to the current stock
     * @param nCreams the number of creams to be added to the current stock
     * @param nCups the number of cups to be added to the current stock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**Overloaded Manipulator to restock only coffee.
     * @param nCoffeeOunces the number of coffee ounces to be added to the current stock
     */
    private void restock(int nCoffeeOunces) {
        this.nCoffeeOunces += nCoffeeOunces;
    }

    /*Cafe Extention of the Building toString() method */
    public String toString() {
        String description = super.toString();
        description+="This cafe has a current stock of " + this.nCoffeeOunces +" coffee ounces, " + this.nSugarPackets + " sugar packets, " + this.nCreams +" creams, and " + this.nCups + " cups.";
        return description;
    }

    /* Overridden building method. Calls building method and adds the Cafe class functions. */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugarPackets, nCreams)\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }

    /**Overriden building method. If the house has an elevator then it calls the buildings original goToFloor method. If the house doesn't have an elevator, you can only move up or down one floor at a time. 
   * @param floorNum the floor that you want to travel to
   */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("Cafe's only have one floor!");
    }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass", "Neilson", 50, 30, 20, 1);
        myCafe.sellCoffee(10, 5, 3);
        System.out.println(myCafe.toString());
        System.out.println(myCafe.nCoffeeOunces);
        System.out.println(myCafe.nSugarPackets);
        System.out.println(myCafe.nCreams);
        System.out.println(myCafe.nCups);
        myCafe.showOptions();
        myCafe.goToFloor(3);  
        myCafe.showOptions(); 
        myCafe.goToFloor(5);
        myCafe.restock(10);
    }   
}
