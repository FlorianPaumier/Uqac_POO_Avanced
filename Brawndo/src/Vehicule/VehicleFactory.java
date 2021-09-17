package Vehicule;

import Interface.Factory;
import Interface.Vehicle;

import java.util.ArrayList;
import java.util.Random;

public class VehicleFactory implements Factory {

    private int countVehicle;

    public VehicleFactory(int count) {
        this.countVehicle = count;
    }

    @Override
    public ArrayList<Vehicle> generate() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < this.countVehicle; i++) {
                Vehicle vehicleClass = generateVehicule(i);
                vehicles.add(vehicleClass);
        }

        return vehicles;
    }

    private Vehicle generateVehicule(int i) {
        Vehicle vehicleClass = null;

        int index = (new Random()).nextInt(2);

        switch (index) {
            case 0 -> vehicleClass = new Moto();
            case 1 -> vehicleClass = new Car();
            case 2 -> vehicleClass = new Truck();
            default -> vehicleClass = new Car();
        }
        vehicleClass.setId(i + 1);

        return vehicleClass;
    }
}
