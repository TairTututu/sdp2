package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Vehicle class is the prototype with a list of vehicle names
class Vehicle implements Cloneable {
  private List<String> vehicleList;

  public Vehicle() {
    this.vehicleList = new ArrayList<String>();
  }

  public Vehicle(List<String> list) {
    this.vehicleList = list;
  }

  public void insertData() {
    vehicleList.add("Honda amaze");
    vehicleList add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  public List<String> getVehicleList() {
    return this.vehicleList;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> tempList = new ArrayList<String>();

    for (String s : this.getVehicleList()) {
      tempList.add(s);
    }

    return new Vehicle(tempList);
  }
}

public class PrototypePattern {
  public static void main(String[] args) throws CloneNotSupportedException {
    // Create a prototype vehicle
    Vehicle a = new Vehicle();
    a.insertData();

    // Clone the prototype to create a new vehicle (b)
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    list.add("Honda new Amaze");

    // Display the vehicle lists of both the original and the cloned vehicles
    System.out.println(a.getVehicleList());
    System.out.println(list);

    // Remove an item from the cloned vehicle's list
    b.getVehicleList().remove("Audi A4");
    System.out.println(list);

    // The original vehicle's list remains unchanged
    System.out.println(a.getVehicleList());
  }
}
