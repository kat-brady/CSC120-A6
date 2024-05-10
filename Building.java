/*
 * Building class establishes basic information about a generic building
 */
public class Building {

    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;

    /*
     * Constructs a building
     * @param String name: the name of the building
     * @param String address: the address of the building
     * @param int nFloors: the number of floors the building has
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /*
     * Method to return the name of the building
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /*Method to return address of building
     * @return address
     */
    public String getAddress() {
        return this.address;
    }

    /*Method to retun nFloors
     * @return nFloors
     */
    public int getFloors() {
        return this.nFloors;
    }

    /*
     * Method to return description of building
     * @return "this.name is a this.nFloors-story building located at this.address."
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}
