package Autoroute;

import Interface.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Autoroute {

    private int[] access;
    private ArrayList<Vehicle> vehicles;
    private double speed;
    private ArrayList<Vehicle> vehiclesOut;

    public Autoroute(int countAccess) {
        this.access = new int[countAccess];
        this.vehicles = new ArrayList<Vehicle>();
        this.vehiclesOut = new ArrayList<Vehicle>();
    }

    public int[] getAccess() {
        return access;
    }

    public void setAccess(int[] access) {
        this.access = access;
    }

    public int[] addAccess(int position){
        this.access[this.access.length - 1] = position;
        return this.access;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Vehicle> addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
        return this.vehicles;
    }

    public ArrayList<Vehicle> removeVehicle(Vehicle vehicle){
        List<Vehicle> vehicleList = this.vehicles.stream().filter(vehicle1 -> vehicle.getId() == vehicle1.getId()).toList();
        return new ArrayList<>(vehicleList);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public ArrayList<Vehicle> getVehiclesOut() {
        return vehiclesOut;
    }

    public void addVehiclesOut(Vehicle vehiclesOut) {
        this.vehiclesOut.add(vehiclesOut);
    }
}
