package factory_design_pattern;

// Abstract class Vehicle, the base class for all vehicle types
abstract class Vehicle {
	public abstract int getWheel(); // An abstract method to get the number of wheels

	public String toString() {
		return "Wheel: " + this.getWheel();
	}
}

// Car class extends Vehicle, representing a specific type of vehicle
class Car extends Vehicle {
	int wheel;

	Car(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Bike class extends Vehicle, representing another specific type of vehicle
class Bike extends Vehicle {
	int wheel;

	Bike(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// VehicleFactory class is responsible for creating instances of different vehicle types
class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if (type.equals("car")) { // Use .equals() for string comparison
			return new Car(wheel);
		} else if (type.equals("bike")) {
			return new Bike(wheel);
		}
		return null; // Return null if the type is not recognized
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		// Use the factory to create vehicle instances

		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
