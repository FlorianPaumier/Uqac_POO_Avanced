package main.Vehicule;

import main.Autoroute.Autoroute;
import main.Interface.Vehicle;

import java.util.ArrayList;

public class VehicleController {

    private ArrayList<Vehicle> vehicles;

    /**
     * Constructor
     * @param vehicles : all vehicles on roads
     */
    public VehicleController(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    /**
     * Move all vehicles; a new game trick occurred.
     * Each vehicle final speed depend of current autoroute it is driving.
     * @param autoroutes : list of autoroutes
     */
    public void move(final ArrayList<Autoroute> autoroutes) {
        for (Autoroute autoroute : autoroutes) {
            for (Vehicle vehicle : autoroute.getVehicles()) {
                moveOneVehicle(vehicle.getId(), autoroute.getSpeed());
            }
        }
    }

    /**
     * Move just one vehicle following autoroute speed.
     * This method is private, becouse it is a tool of move method.
     * @param id ID of the vehicle to move
     * @param autorouteSpeed
     */
    private void moveOneVehicle(int id, double autorouteSpeed) {
        Vehicle vehicle = vehicles
                .stream()
                .filter(vehicle_ -> vehicle_.getId() == id)
                .findFirst()
                .get();
        int nextPostion = (int) Math.floor(autorouteSpeed * vehicle.getSpeed() + vehicle.getPosition());
        vehicle.setPosition(nextPostion);
    }
}
