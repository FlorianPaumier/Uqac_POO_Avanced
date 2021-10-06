package main.Autoroute;

import main.Acces.Acces;
import main.Interface.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Autoroute {

    private int id;
    private Acces access;
    private ArrayList<Vehicle> vehicles;
    private double speed;
    private ArrayList<Vehicle> vehiclesOut;
    private double perimeter;
    private int rayon;

    public Autoroute() {
        this.access = null;
        this.vehicles = new ArrayList<Vehicle>();
        this.vehiclesOut = new ArrayList<Vehicle>();
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return this.id; }

    public Acces getAccess() {
        return access;
    }

    public void setAccess(Acces access) {
        this.access = access;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
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

    public void setVehiclesOut(ArrayList<Vehicle> vehiclesOut) { this.vehiclesOut = vehiclesOut; }

    public double getPerimeter() { return perimeter; }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }
}
