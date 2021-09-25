package Autoroute;

import Interface.Vehicle;
import Vehicule.VehicleController;

import java.util.ArrayList;

public class AutorouteController {

    ArrayList<Vehicle> vehicles;
    VehicleController controller;
    Autoroute autoroute;

    public AutorouteController(Autoroute autoroute){
        controller = new VehicleController(autoroute);
    }

    public void haveAccident(Vehicle a, Vehicle b){
        //throw new AccidentException("Le vehicule");
    }

    public void handleVehicle(){
        vehicles.forEach(vehicle -> {
            controller.move(vehicle);
        });
    }
}
