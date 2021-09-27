package main.Vehicule;

import main.Interface.Factory;
import main.Interface.Vehicle;

import java.util.ArrayList;
import java.util.Random;

public class VehicleFactory implements Factory {

    //private int countVehicle;
    private int id;

    public VehicleFactory() {
        id = 0;
        //this.countVehicle = count;
    }

    @Override
    public Vehicle generate() {
        /*ArrayList<Vehicle> vehicles = new ArrayList<>();*/
        /*for (int i = 0; i < this.countVehicle; i++) {*/
                Vehicle vehicleClass = generateVehicule(id);
                /*vehicles.add(vehicleClass);*/
        //}

        /*return vehicles;*/
        return vehicleClass;
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

        id = i++;
        vehicleClass.setId(id);

        return vehicleClass;
    }
}
