package main.Autoroute;

import main.Exception.AccidentException;
import main.Exception.PanneException;
import main.Interface.Vehicle;
import main.Vehicule.VehicleController;

import java.util.ArrayList;
import java.util.Random;

public class AutorouteController {

    ArrayList<Vehicle> vehicles;
    VehicleController controller;
    Autoroute autoroute;

    public AutorouteController(Autoroute autoroute) {
        controller = new VehicleController(autoroute);
    }

    public void haveAccident(Vehicle a, Vehicle b) {
        //throw new AccidentException("Le vehicule");
    }

    public void handleVehicles() throws AccidentException {
        try {
            for (Vehicle vehicle : vehicles) {
                accept(vehicle);
            }
        }catch (PanneException e){
            throw new AccidentException(e.getMessage());
        }
    }

    private void accept(Vehicle vehicle) throws PanneException {
        boolean canHaveAccident = (new Random()).nextFloat() < 0.05;
        if (canHaveAccident)
            throw new PanneException(String.format("Le vehicule %d est tombé en panne", vehicle.getId()));

        boolean needToExit = controller.move(vehicle);

        if (needToExit) {
            autoroute.addVehiclesOut(vehicle);
            autoroute.removeVehicle(vehicle);
        }
    }
}
