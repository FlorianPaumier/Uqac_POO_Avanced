package main.Autoroute;

import main.Acces.Acces;
import main.Exception.AccidentException;
import main.Exception.PanneException;
import main.Interface.Vehicle;
import main.Vehicule.VehicleController;

import java.util.*;
import java.util.stream.Collectors;

public class AutorouteController {

    // vehicleController acts on all vehicles on roads
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
            List<Vehicle> crashed = a
                    .getVehicles()
                    .stream()
                    .filter(vehicle -> vehicle.getPosition() == v.getPosition())
                    .toList();
            // If superior 2 => 2 vehicles at the same position
            if (crashed.size() > 2)
                return new ArrayList<Vehicle>(crashed);
        }
        return new ArrayList<Vehicle>();
    }

    /**
     * Move all vehicle; a copy of autoroutes is created on the ground
     * Vehicles controller cannot change autoroutes throught association
     * @throws AccidentException
     */
    public void next() throws AccidentException, PanneException {

        ArrayList<Autoroute> copyOfAutoroutes = new ArrayList<>(autoroutes);
        autoroutes = this.vehicleController.move(copyOfAutoroutes); // TODO

        for (Autoroute autoroute : autoroutes) {
            LinkedList<Vehicle> vehiculeToChange = new LinkedList<>();

            Autoroute nextAutoroute = null;

            if (autoroute.getId() + 1 > autoroutes.size()) {
                nextAutoroute = autoroutes.get(autoroute.getId() - 1);
            } else {
                nextAutoroute = autoroutes.get(autoroute.getId());
            }

            for (Vehicle vehicle : autoroute.getVehicles()) {

                if (vehicle.getPosition() > vehicle.getStartPosition() && vehicle.haveMakeATurn()) {
                    System.out.printf("Le vehicule n°%d va de l'autoroute n°%d à l'autoroute n°%d%n", vehicle.getId(), autoroute.getId(), nextAutoroute.getId());

                    Collections.sort(nextAutoroute.getAccess().getGates());

                    int counterModulo = 0;
                    for (int nextGate : nextAutoroute.getAccess().getGates()) {
                        if (nextGate < vehicle.getPosition() || counterModulo == nextAutoroute.getAccess().getGates().size() - 1) {
                            vehiculeToChange.add(vehicle);
                            vehicle.setStartPosition(nextGate);
                            vehicle.setPosition(vehicle.getPosition() - nextGate);
                            vehicle.madeATurn(false);
                            break;
                        } else counterModulo++;
                    }
                }
            }
            for (Vehicle v : vehiculeToChange) {
                changeVehicle(false, v, autoroute);
                changeVehicle(true, v, nextAutoroute);
                System.out.printf("vehicle %d\n", v.getId());
            }
            System.out.printf("%d vehicles on autoroute %d\n", autoroute.getVehicles().size(), autoroute.getId());
        }

        checkAccident();
    }

    /**
     * Add a vehicle on the out autoroute
     * @param v : vehicle to insert
     */
    public void insertVehicle(Vehicle v) {
        if (v == null) return;
        System.out.printf("Insert Vehicle %d, type : %s\n", v.getId(), v.getClass().getSimpleName());
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
            if (this.autoroutes.contains(a)){

                if (add) {
                    Acces access = a.getAccess();
                    int indexGate = (new Random()).nextInt(access.getGates().size());
                    int position = access.getGates().get(indexGate);
                    v.setStartPosition(position);
                    addVehicleToAutoroute(a, v);
                }
                else removeVehicleFromAutoroute(a, v);
            }
        } catch (Exception e) {
            System.out.println("Change vehicle : "
                    + (add ? "add " : "remove ")
                    + e.getMessage());
        }
    }

    /**
     * Get out autoroute
     * @return Autauroute which has the bigger rayon
     */
    private Autoroute getBigger() {
        // Copy autoroutes to not act on attribute.
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


    /**
     * Remove a vehicle from out vehicles
     * @param autoroute : autoroute to act on
     * @param vehicle :
     */
    public void removeVehicleOut(Autoroute autoroute, Vehicle vehicle) {
        autoroute.getVehiclesOut().remove(vehicle);
    }

    /**
     * Add a vehicle to a specific autoroute
     * @param autoroute : autoroute to act on
     * @param vehicle : vehicle to add
     */
    public void addVehicleToAutoroute(Autoroute autoroute, Vehicle vehicle){
        autoroute.getVehicles().add(vehicle);
    }

    /**
     * Remove a vehicle from a specific autoroute
     * @param autoroute : autoroute to act on
     * @param vehicle : vehicle to remove
     */
    public void removeVehicleFromAutoroute(Autoroute autoroute, Vehicle vehicle) {
        autoroute.getVehicles().remove(vehicle);
    }
}
