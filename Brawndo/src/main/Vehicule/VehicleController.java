package main.Vehicule;

import main.Autoroute.Autoroute;
import main.Exception.PanneException;
import main.Interface.Vehicle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class VehicleController {

    private final ArrayList<Vehicle> vehicles;

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
     *
     * @return an array list of all vehicles to remove
     */
    public ArrayList<Autoroute> move(final ArrayList<Autoroute> autoroutes) throws PanneException {
        System.out.println("--------- Move section ---------");
        boolean turnHavePanne = (new Random()).nextDouble() < 0.05;

        for (Autoroute autoroute : autoroutes) {
            for (Vehicle vehicle : autoroute.getVehicles()) {
                if(turnHavePanne) generatePanne(vehicle);
                moveOneVehicle(vehicle, autoroute);
            };
        };
        return autoroutes;
    }

    /**
     * Move just one vehicle following autoroute speed.
     * This method is private, becouse it is a tool of move method.
     *
     * @param vehicle vehicle to move
     * @param autoroute
     *
     */
    private void moveOneVehicle(Vehicle vehicle, final Autoroute autoroute) {

        System.out.printf("Move vehicle (%s) n°%d%n", vehicle.getClass().getSimpleName(), vehicle.getId());

        int moveDist = (int)(autoroute.getSpeed() * vehicle.getSpeed());
        int nextPosition = (int) Math.floor(moveDist + vehicle.getPosition());

        if (nextPosition > autoroute.getPerimeter()){
            nextPosition = (int)(nextPosition - autoroute.getPerimeter());
            vehicle.madeATurn(true);
        }

        vehicle.setMoveDist(moveDist);
        // Remember previous position for accident handling
        vehicle.setPreviousPosition(vehicle.getPosition());
        vehicle.setPosition(nextPosition);
        System.out.printf("Le vehicule n°%d avance de %s et passe de la position %d à la position %d de l'autoroute %d%n", vehicle.getId(), new DecimalFormat("#.##").format(moveDist), vehicle.getPreviousPosition(),vehicle.getPosition(), autoroute.getId());
    }


    /**
     * Generate random Panne on vehicle
     * @param vehicle : vehicle to generate a panne
     * @throws PanneException : Thrown if a panne occured
     */
    private void generatePanne(Vehicle vehicle) throws PanneException {
        double coeff = vehicle.getCoefPanne();

        double panne = (new Random()).nextDouble();
        if (panne < coeff){
            throw new PanneException("Le vehicule n°" + vehicle.getId() + " a eu une panne");
        }
    }

    public int calculateMoveOnNextAutoroute(Vehicle vehicle, int positionNextGate, int positionNextAutorouteGate) {
        int distOnCurrentAutoroute = positionNextGate - vehicle.getPreviousPosition();
        return (int)(positionNextAutorouteGate + (vehicle.getMoveDist() - distOnCurrentAutoroute));
    }
    
    public static boolean compareTo(Vehicle v1, Vehicle v2, double autoroutePerimeter){
        if (v1.getPreviousPosition() < v2.getPreviousPosition()){
            int v1Position = v1.getPosition();
            int v2Position = v2.getPosition();
            if (v1Position < v1.getPreviousPosition()) v1Position += autoroutePerimeter;
            if (v2Position < v2.getPreviousPosition()) v1Position += autoroutePerimeter;
            if (v1.getPosition() >= v2.getPosition()){
                return true;
            }
        }
        return false;
    }
}
