import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Mwangi Cultural Center", "12 Prospect Street", 1));
        myMap.addBuilding(new House("99 Green Street", 4, false, false));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "1 Chapin Way", 10, 10, 10, 10));
        myMap.addBuilding(new Building("Alumnae Gymnasium", "83 Green Street", 2));
        myMap.addBuilding(new Building("Burton Hall", "46 College Lane", 4));
        myMap.addBuilding(new Building("Botanical Garden", "16 College Lane", 1));
        myMap.addBuilding(new Building("Design Thinking Inititive", "Henshaw Avenue", 2));
        myMap.addBuilding(new Building("Mwangi Cultural Center", "12 Prospect Street", 1));
        myMap.addBuilding(new Building("Unity House", "Bedford Terrace", 2));

        System.out.println(myMap);
    }   
}
