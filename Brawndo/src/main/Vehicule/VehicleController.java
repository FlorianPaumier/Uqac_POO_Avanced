package main.Vehicule;

import main.Autoroute.Autoroute;
import main.Interface.Vehicle;

import java.util.ArrayList;

public class VehicleController {

    private ArrayList<Vehicle> vehicles;

    // VehicleController acts on all vehicles
    public VehicleController(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    // Move all vehicles. Each vehicle final speed depend of current autoroute it is driving.
    public void move(ArrayList<Autoroute> autoroutes) {
        for (Autoroute autoroute : autoroutes) {
            for (Vehicle vehicle : autoroute.getVehicles()) {
                moveOneVehicle(vehicle.getId(), autoroute.getSpeed());
            }
        }
    }

    // Move just one vehicle following autoroute speed
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
