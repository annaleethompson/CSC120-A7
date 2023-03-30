/** 
 * Filename: Cafe.java
 * Decription: Cafe class extentded from Building with attributes nCoffeeOunces, nSugarPackets, nCreams, and nCups. Contains functions sellCoffee, and restock.
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, A6: Use What Your Parent (Class) Gave You
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: March 19, 2023
 */

/* This is a stub for the Cafe class */
public class Cafe extends Building {

    /**Stores integers for the number of coffee ounces, sugar packets, creams, and cups in stock. */
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**Constructor */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
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

    /*Cafe Extention of the Building toString() method */
    public String toString() {
        String description = super.toString();
        description+="This cafe has a current stock of " + this.nCoffeeOunces +" coffee ounces, " + this.nSugarPackets + " sugar packets, " + this.nCreams +" creams, and " + this.nCups + " cups.";
        return description;
      }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass", "Neilson", 1, 50, 30, 20, 1);
        myCafe.sellCoffee(10, 5, 3);
        System.out.println(myCafe.toString());
        System.out.println(myCafe.nCoffeeOunces);
        System.out.println(myCafe.nSugarPackets);
        System.out.println(myCafe.nCreams);
        System.out.println(myCafe.nCups);
        
    }
    
}
