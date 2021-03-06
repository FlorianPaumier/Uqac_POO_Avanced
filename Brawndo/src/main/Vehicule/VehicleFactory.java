package main.Vehicule;

import main.Interface.Factory;
import main.Interface.Vehicle;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public class VehicleFactory implements Factory {

    private int id;
    private int tick;
    private final int timer;
    private final ArrayList<Class<? extends Vehicle>> vehiclesClass;

    public VehicleFactory(int timer) {
        this.id = 0;
        this.tick = 0;
        this.timer = timer;

        this.vehiclesClass = new ArrayList<>() {
            {
                add(Car.class);
                add(Moto.class);
                add(Truck.class);
            }
        };
    }


    public int getTick() { return this.tick; }


    /**
     * Generate a new vehicle each time timer is reached.
     *
     * @return null or new vehicle
     */
    @Override
    public Vehicle generate() {
        Vehicle v = null;

        System.out.println("Tour n°" + tick);
        if (tick % timer == 0) {
            v = generateVehicule(id);
        }
        tick++;
        return v;
    }


    /**
     * Create a new Vehicle instance
     *
     * @param i : id of the new vehicle
     * @return the new vehicle
     */
    private Vehicle generateVehicule(int i) {
        Vehicle vehicleClass = null;

        int index = (new Random()).nextInt(this.vehiclesClass.size());

        try {
            vehicleClass = this.vehiclesClass.get(index).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        ++this.id;

        assert vehicleClass != null;

        vehicleClass.setId(++i);
        // Set a random coeffPanne between maxCoeffPanne and 0
        vehicleClass.setCoefPanne(vehicleClass.getMaxCoeffPanne() * (new Random()).nextDouble());

        System.out.printf("Création du véhicule n°%d%n", vehicleClass.getId());
        return vehicleClass;
    }
}
