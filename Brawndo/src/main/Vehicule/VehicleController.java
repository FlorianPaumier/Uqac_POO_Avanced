package main.Vehicule;

import main.Autoroute.Autoroute;
import main.Autoroute.AutorouteController;
import main.Exception.PanneException;
import main.Interface.Vehicle;

import java.util.ArrayList;
import java.util.Optional;

public class VehicleController {

    private ArrayList<Vehicle> vehicles;

    /**
     * Constructor
     *
     * @param vehicles : all vehicles on roads
     */
    public VehicleController(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Move all vehicles; a new game trick occurred.
     * Each vehicle final speed depend of current autoroute it is driving.
     *
     * @param autoroutes : list of autoroutes
     */
    public void move(final ArrayList<Autoroute> autoroutes) throws PanneException {
        autoroutes.forEach(autoroute -> {
            autoroute.getVehicles().forEach(vehicle -> {
                if (!this.vehicles.contains(vehicle)) {
                    vehicles.add(vehicle);
                }
            });
        });


        for (Autoroute autoroute : autoroutes) {
            for (Vehicle vehicle : autoroute.getVehicles()) {
                generateAccident(vehicle);
                moveOneVehicle(vehicle.getId(), autoroute);

                if (autoroute.getVehiclesOut().contains(vehicle)) {
                    Autoroute nextAutoroute = null;

                    if (autoroute.getId() + 1 > autoroutes.size()) {
                        nextAutoroute = autoroutes.get(autoroute.getId() - 1);
                    } else {
                        nextAutoroute = autoroutes.get(autoroute.getId());
                    }

                    System.out.println(String.format("Le vehicule va de l'autoroute n°%d à l'autoroute n°%d", autoroute.getId(), nextAutoroute.getId()));

                    for (int gate : nextAutoroute.getAccess().getGates()) {
                        int positionGate = AutorouteController.getGatePosition(gate, autoroute.getRayon());
                        if (positionGate < vehicle.getPosition()){
                            int nextGate = AutorouteController.getGatePosition(gate, nextAutoroute.getRayon());
                            autoroute.removeVehicleOut(vehicle);
                            nextAutoroute.addVehicle(vehicle);
                            vehicle.setStartPosition(nextGate);
                            vehicle.setPosition(vehicle.getPosition() - nextGate);
                            vehicle.madeATurn(false);
                        }
                    }
                }
            }
        }
    }

    /**
     * Move just one vehicle following autoroute speed.
     * This method is private, becouse it is a tool of move method.
     *
     * @param id        ID of the vehicle to move
     * @param autoroute
     */
    private void moveOneVehicle(int id, Autoroute autoroute) {
        System.out.println("Move vehicle " + id);

        Optional<Vehicle> stream = vehicles
                .stream()
                .filter(vehicle_ -> vehicle_.getId() == id)
                .findFirst();

        if (stream.isPresent()) {
            Vehicle vehicle = stream.get();

            double moveDist = autoroute.getSpeed() * vehicle.getSpeed();
            int nextPosition = (int) Math.floor(moveDist + vehicle.getPosition());
            if (nextPosition > autoroute.getPerimeter()){
                nextPosition = (int)(nextPosition - autoroute.getPerimeter());
                vehicle.madeATurn(true);
            }
            if (nextPosition > vehicle.getStartPosition() && vehicle.haveMakeATurn()) {
                System.out.println(String.format("Le vehicule %d change d'autoroute", vehicle.getId()));
                autoroute.removeVehicle(vehicle);
                autoroute.addVehiclesOut(vehicle);
            }
            vehicle.setPosition(nextPosition);
            System.out.println(String.format("Le vehicule n°%d avance de %f et est à la position %d", vehicle.getId(), moveDist, vehicle.getPosition()));
        }
    }

    private void generateAccident(Vehicle vehicle) throws PanneException {
        double coef = vehicle.getCoefAccident();
        float accident = 1;
        if (accident < 0.005){
            throw new PanneException("Le vehicule n°"+vehicle.getId()+" a un accident");
        }
    }
}
