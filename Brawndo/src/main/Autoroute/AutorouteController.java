package main.Autoroute;

import main.Exception.AccidentException;
import main.Interface.Vehicle;
import main.Vehicule.VehicleController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AutorouteController {

    // vehicleController acts on all vehicles on the road
    VehicleController vehicleController;
    // All created autoroutes by the factory
    ArrayList<Autoroute> autoroutes;

    public AutorouteController(ArrayList<Autoroute> autoroutes){
        this.autoroutes = autoroutes;

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        for (Autoroute autoroute : autoroutes) {
            vehicles.addAll(autoroute.getVehicles());
        }

        vehicleController = new VehicleController(vehicles);
    }

    /**
     * Check if an accident occured each time vehicles move.
     * @throws AccidentException : Exception throw when an accident happen.
     */
    private void checkAccident() throws AccidentException {
        for(Autoroute autoroute : autoroutes) {
            // Check if incident
            ArrayList<Vehicle> arrayOfCollision = checkIfVehiclesAreInSamePosition(autoroute);
            if (!arrayOfCollision.isEmpty())
                throw new AccidentException(arrayOfCollision);
        }
    }

    /**
     * Check if 2 vehicles of the same autoroute are in the same position or not
     *
     * @param a autouroute to check collision
     * @return
     * an empty list if there is no collision,
     * else an array containing crashed vehicles.
     */
    private ArrayList<Vehicle> checkIfVehiclesAreInSamePosition(Autoroute a) {
        for(Vehicle v : a.getVehicles()) {
            List<Vehicle> crashed = a.getVehicles().stream().filter(vehicle -> vehicle.getPosition() == v.getPosition()).toList();
            // If superior 2 => 2 vehicles at the same position
            if (crashed.size() > 2) return new ArrayList<Vehicle>(crashed);
        }
        return new ArrayList<Vehicle>();
    }

    /**
     * Move all vehicle; a copy of autoroutes is created on the ground
     * Vehicles controller cannot change autoroutes throught association
     * @throws AccidentException
     */
    public void next() throws AccidentException {
        final ArrayList<Autoroute> autoroutesCopy = new ArrayList<>(autoroutes);
        vehicleController.move(autoroutes);
        checkAccident();
    }

    /**
     * Add a vehicle on the out autoroute
     * @param v : vehicle to insert
     */
    public void insertVehicle(Vehicle v) {
        if (v == null) return;
        changeVehicle(true, v, getBigger());
    }

    /**
     * Add or remove a vehicle from an autoroute.
     * This method is private on the ground, just instance need to access it
     * and not Idioroute Class. Idioroute class can only insert a new vehicle.
     * @param add : if set to true, then add else remove
     * @param v : vehicle to change
     * @param a : autoroute to involve
     */
    private void changeVehicle(boolean add, Vehicle v, Autoroute a) {
        try {
            final Autoroute autoroute = autoroutes
                    .stream()
                    .filter(autoroute_ -> autoroute_.getId() == a.getId())
                    .findFirst()
                    .get();
            ArrayList<Vehicle> vehicles = autoroute.getVehicles();

            if (add == true) vehicles.add(v);
            else vehicles.remove(v);

            autoroute.setVehicles(vehicles);
        } catch (Exception e) {
            System.out.println("Change vehicle : "
                    + (add == true ? "add " : "remove ")
                    + e.getMessage());
        }
    }

    /**
     * Get out autoroute
     * @return Autauroute which has the bigger rayon
     */
    private Autoroute getBigger() {
        // Copy autoroutes to not influence attribute.
        ArrayList<Autoroute> autoroutesCopy = new ArrayList<Autoroute>(autoroutes);

        // Sort autoroutes by rayon.
        Collections.sort(autoroutesCopy, new Comparator<Autoroute>() {
            @Override
            public int compare(Autoroute o1, Autoroute o2) {
                final int rayonO1 = o1.getRayon();
                final int rayonO2 = o2.getRayon();

                return rayonO1 == rayonO2 ? 0 : rayonO1 > rayonO2 ? -1 : 1;
            }
        });

        return autoroutesCopy.get(0);
    }
}
