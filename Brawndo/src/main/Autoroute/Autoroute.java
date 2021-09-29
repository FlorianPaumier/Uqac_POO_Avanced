package main.Autoroute;

import main.Acces.Acces;
import main.Interface.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Autoroute {

    private Acces access;
    private ArrayList<Vehicle> vehicles;
    private double speed;
    private ArrayList<Vehicle> vehiclesOut;
    private double perimeter;
    private int rayon;
    private AutorouteController autorouteController;

    public Autoroute() {
        this.vehicles = new ArrayList<Vehicle>();
        this.vehiclesOut = new ArrayList<Vehicle>();
        this.autorouteController = new AutorouteController(this);
    }

    public Acces getAccess() {
        return access;
    }

    public Autoroute setAccess(Acces access) {
        this.access = access;
        return this;
    }


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public Autoroute setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
        return null;
    }

    public ArrayList<Vehicle> addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
        return this.vehicles;
    }

    public ArrayList<Vehicle> removeVehicle(Vehicle vehicle){
        List<Vehicle> vehicleList = this.vehicles.stream().filter(vehicle1 -> vehicle.getId() == vehicle1.getId()).collect(Collectors.toList());
        return new ArrayList<>(vehicleList);
    }

    public double getSpeed() {
        return speed;
    }

    public Autoroute setSpeed(double speed) {
        this.speed = speed;
        return null;
    }

    public ArrayList<Vehicle> getVehiclesOut() {
        return vehiclesOut;
    }

    public void addVehiclesOut(Vehicle vehiclesOut) {
        this.vehiclesOut.add(vehiclesOut);
    }

    public double getPerimeter() {
        return perimeter;
    }

    public Autoroute setPerimeter(double perimeter) {
        this.perimeter = perimeter;
        return null;
    }

    public int getRayon() {
        return rayon;
    }

    public Autoroute setRayon(int rayon) {
        this.rayon = rayon;
        return null;
    }

    public AutorouteController getAutorouteController() {
        return autorouteController;
    }

    public Autoroute setAutorouteController(AutorouteController autorouteController) {
        this.autorouteController = autorouteController;
        return null;
    }
}
