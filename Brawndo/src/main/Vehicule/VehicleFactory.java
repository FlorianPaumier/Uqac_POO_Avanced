package main.Vehicule;

import main.Interface.Factory;
import main.Interface.Vehicle;

import java.util.Random;

public class VehicleFactory implements Factory {

    private int id;
    private int tick;
    private int timer;

    public VehicleFactory(int timer) {
        this.id = 0;
        this.tick = 0;
        this.timer = timer;
    }

    /**
     * Generate a new vehicle each time timer is reached.
     * @return null or new vehicle
     */
    @Override
    public Vehicle generate() {
        Vehicle v = null;
        if (tick % timer == 0) {
            v = generateVehicule(id);
        }
        tick++;
        return v;
    }


    /**
     * Create a new Vehicle instance
     * @param i : id of the new vehicle
     * @return the new vehicle
     */
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
