package main.Vehicule;

import main.Interface.Factory;
import main.Interface.Vehicle;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public class VehicleFactory implements Factory {

    private int countVehicle;
    private ArrayList<Class<? extends Vehicle>> vehiclesClass;

    public VehicleFactory(int count) {

        this.countVehicle = count;
        this.vehiclesClass = new ArrayList<>() {
            {
                add(Car.class);
                add(Moto.class);
                add(Truck.class);
            }
        };
    }

    @Override
    public ArrayList<Vehicle> generate() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < this.countVehicle; i++) {
                Vehicle vehicleClass = generateVehicle(i);
                vehicles.add(vehicleClass);
        }

        return vehicles;
    }

    private Vehicle generateVehicle(int i) {
        Vehicle vehicleClass = null;

        int index = (new Random()).nextInt(this.vehiclesClass.size() - 1);

        try {
            vehicleClass = this.vehiclesClass.get(index).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        vehicleClass.setId(i + 1);

        return vehicleClass;
    }
}
