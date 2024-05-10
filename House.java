
import java.util.*;
/*
 * House class extends Building and contains details specific to House class
 */
public class House extends Building{ 
  private ArrayList<String> residents; // Initializes the arraylist for residents
  private boolean hasDiningRoom; //initializes boolean for dining room
  private boolean hasElevator; //initializes boolean for elevator
  private int nResidents=0; //initializes int for number of residents

  /*
   * Constructs a house
   *  @param String name: the name of the house
   * @param String address: the address of the house
   * @param int nFloors: the number of floors the house has
   * @param boolean hasDiningRoom: if the house has a dining hall
   * @param boolean hasElevator: if the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) { //constructs a house using attributes from parent class Building
    super(name, address, nFloors); //imports existing classifications from Building
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<String>();
  }

  /*
   * Method to moveIn residents
   * @param String residentName: the resident to be moved in
   * throws exception if residentName already lives in the house, otherwise adds them to the list of residents
   */
  public void moveIn(String residentName){
    if (this.residents.contains(residentName)) { //checks if the resident already lives there so that they cannot move in twice
      throw new RuntimeException(residentName + " already lives in " + this.name); //throw exception if they do
  } //otherwise, proceed in adding them to the list of residents
    residents.add(residentName);
    nResidents+=1;
    System.out.println(residentName + " has successfully moved in!");
  }

  /*
   * Method to moveOut of house
   * @param String residentName: the resident to be moved out
   * throws exception if residentName doesnt live in house, otherwise removes them from the list of residents
   * @return residentName
   */
  public String moveOut(String residentName){ //enables a resident to be removed from the house
    if (!this.residents.contains(residentName)) { //checks if the resident lives in the house
      throw new RuntimeException(residentName + " doesn't live in " + this.name); //throw exception if they don't
  } //otherwise, proceed in moving out
    residents.remove(residentName); //takes the name out of the arraylist
    nResidents-=1; //decreases the count of residents
    System.out.println(residentName + " has successfully moved out. They'll be missed.");
    return residentName;
    } 

  /*
   * Method to see if house hasDiningRoom
   * @return true if this.hasDiningRoom
   * @return false is !this.hasDiningRoom
   */
  public boolean hasDiningRoom(){ //checks if a given house has a dining room
    if (!this.hasDiningRoom){ //if there is no dining room found, aka if it is false
      System.out.println( this.name + " does not have a dining room.");
      return false;
    } else {
      System.out.println(this.name + " has a dining room."); //if there is a dining room, or if it is true
      return true;
    }
  }

  /*Method to return number of residents
   * @return this.nResidents
   */
  public int nResidents(){ //public method to return number of residents in a given house
    if (this.nResidents == 1){ //adjusts text output if there is only 1 resident for better grammar
      System.out.println("There is " + this.nResidents + " resident in " + this.name + "."); 
    }else{
      System.out.println("There are " + this.nResidents + " residents in " + this.name + ".");
    }
    return this.nResidents;
  }

  /*
   * Method to see if a certain person is a house resident
   * @param String person: the person to be checked if they are a house resident
   * @return false if person is not in this.residents
   * @return true otherwise
   */
  public boolean isResident(String person){ //public method to check if a specific name is in the arraylist of residents
    if (!this.residents.contains(person)){
      System.out.println(person + " is not a resident of " + this.name + ".");
      return false;
    } else{
      System.out.println(person + " is a resident of " + this.name + ".");
      return true;
    }
  }

  /*
   * Method to adjust description
   * adds on text specific to house class
   */
  public String toString() { //public adjustment of toString to add on house features
    String desc = super.toString();
    if (this.hasDiningRoom) {
      desc += " It has a dining room.";
    } else {
      desc += " It does not have a dining room.";
    }
    if (this.hasElevator) {
      desc += " It has an elevator.";
    } else{
      desc+= " It does not have an elevator.";
    }
    return desc;
  }

  public static void main(String[] args) {
    House house= new House("Albright House", "7 Bedford Terrace", 4, false, false);
    System.out.println(house);
    house.moveIn("Kat");
    house.moveIn("Kara");
    house.isResident("Kat");
    house.hasDiningRoom();
    house.nResidents();
    house.moveOut("Kat");
    house.nResidents();
    house.isResident("Kat");
  }

}